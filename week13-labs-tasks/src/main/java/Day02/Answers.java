package Day02;

import java.util.ArrayList;
import java.util.List;

public class Answers {
    private List<String> rightAnswers;
    private List<String> actualAnswers=new ArrayList<>();

    public Answers(List<String> rightAnswers) {
        this.rightAnswers = rightAnswers;
    }
    public void addAnswer(String answer){
        actualAnswers.add(answer);
    }

    public boolean isThisAnswerCorrect(int answerNumber){
        return rightAnswers.get(answerNumber-1).toUpperCase().equals(actualAnswers.get(answerNumber-1).toUpperCase());
    }
    private boolean isThisAnswerSkipped(int answerNumber){
        return actualAnswers.get(answerNumber-1).toUpperCase().equals("X");
    }

    public int getTotalPoints(){
        int total=0;
        for(int i=1; i<=Math.min(rightAnswers.size(),actualAnswers.size());i++){
            if(!isThisAnswerSkipped(i)){
                if(isThisAnswerCorrect(i)){
                    total+=i;
                }
            else{
                total-=2;
                }
            }
        }
        return total;
    }
}
