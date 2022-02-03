package Day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Bank {
    private Map<String,Account> accountsMap=new TreeMap<>();
    private List<Transfer> transfersList=new ArrayList<>();

    public void readFromFIle(Path path){
        //Paths.get("src/test/resources/transfers.csv")
        List<String> lines;
        try {
            lines= Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file: "+path, ioe);
        }
        process(lines);
    }

    private void process(List<String> lines) {
        for(int i=0;i<lines.size();i++){
            processLine(lines.get(i));
        }
    }

    private void processLine(String line) {
        String[] fieldsArray=line.split(",");
        String from=fieldsArray[0];
        String to=fieldsArray[1];
        int amount=Integer.valueOf(fieldsArray[2]);
        accountsMap.putIfAbsent(from,new Account(from));
        accountsMap.putIfAbsent(to,new Account(to));
        transfersList.add(new Transfer(accountsMap.get(from),accountsMap.get(to),amount));
    }

    public String reportOnAccounts(){
        String output="";
        for(String ID:accountsMap.keySet()){
//            System.out.println(accountsMap.get(ID));
            output+=(accountsMap.get(ID).toString()+"\n");
        }
        return output;
    }

    public Map<String, Account> getAccountsMap() {
        return accountsMap;
    }

    public List<Transfer> getTransfersList() {
        return transfersList;
    }

    public static void main(String[] args) {
        Bank bank=new Bank();
        bank.readFromFIle(Paths.get("src/main/resources/transfers.csv"));
        int numberOfTransfers=bank.getTransfersList().size();
        System.out.println("Number of transactions: "+numberOfTransfers);

        for(int i=0;i<numberOfTransfers;i++){
            bank.getTransfersList().get(i).realize();
        }
        System.out.println(bank.reportOnAccounts());

    }
}
