package Day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ClassNoteBook {
    private TreeMap<Student, List<Mark>> recordsMap=new TreeMap();

    public void addStudent(Student student){
        recordsMap.put(student, new ArrayList<>());
    }

    public void addMark(int id, int mark){
        for(Map.Entry<Student, List<Mark>> record:recordsMap.entrySet()){
            if(record.getKey().getID()==id) {
                record.getValue().add(markToInt(mark));
            }
        }


    }
    public static Mark markToInt(int value) {
        for (Mark mark : Mark.values()) {
            if (mark.getValue()==value) {
                return mark;
            }
        }
        throw new IllegalArgumentException("The mark is not valid!");
    }

    public TreeMap<Student, List<Mark>> getNotebook() {
        return recordsMap;
    }
}
