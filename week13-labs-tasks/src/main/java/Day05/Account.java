package Day05;

import java.util.Objects;

public class Account implements Comparable<Account>{
    private String ID;
    private int balance=0;

    public Account(String ID) {
        this.ID = ID;
    }
    private void changeBalance(int amount){
        balance+=amount;
    }
    public void plus(int amount){
        changeBalance(amount);
    }
    public void minus(int amount){
        changeBalance(-1*amount);
    }

    @Override
    public String toString() {
        return "Account{" +
                "ID='" + ID + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public int compareTo(Account o) {
        return this.ID.compareTo(o.ID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(ID, account.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
