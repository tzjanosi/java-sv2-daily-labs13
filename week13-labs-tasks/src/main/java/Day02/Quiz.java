package Day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Quiz {
    private Map<String, Answers> answersList=new TreeMap<>();

    public void readFromFIle(Path path){
        //Paths.get("src/test/resources/result.txt")
        List<String> lines;
        try {
            lines= Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file: "+path, ioe);
        }
        process(lines);
    }

    private void process(List<String> lines) {
        List<String> rightAnswers=new ArrayList<String>(Arrays.asList(lines.get(0).split("")));
        
        for(int i=1;i< lines.size();i++){
            processLine(rightAnswers,lines.get(i));
        }
    }

    private void processLine(List<String> rightAnswers, String line) {
        String[] fieldsArray=line.split(" ");
        String ID=fieldsArray[0];
        String answer=fieldsArray[1];
        answersList.putIfAbsent(ID, new Answers(rightAnswers));
        answersList.get(ID).addAnswer(answer);
    }
    private Optional<Integer> maxPoints(){
        return answersList.entrySet().stream()
                .map(e->e.getValue().getTotalPoints())
                .max(Integer::compare);
    }

    public List<String> getWinners(){
        Integer maxPoints=maxPoints().get();
        return answersList.entrySet().stream()
                .filter(e->e.getValue().getTotalPoints()==maxPoints)
                .map(e->e.getKey())
                .toList();
    }

    public static void main(String[] args) {
        Quiz quiz=new Quiz();
        quiz.readFromFIle(Paths.get("src/main/resources/result.txt"));
        List<String> winners=quiz.getWinners();
        String anouncement=(winners.size()==1?"The winner is: ":"The winners are: ");
        System.out.println(anouncement);
        System.out.println(winners);
    }
}
