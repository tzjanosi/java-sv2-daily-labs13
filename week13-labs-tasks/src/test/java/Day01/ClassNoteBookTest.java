package Day01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ClassNoteBookTest {
    @Test
    void testAddStudent(){
        ClassNoteBook ClassNoteBook = new ClassNoteBook();

        Student s = new Student(1,"John");
        ClassNoteBook.addStudent(s);

        assertTrue(ClassNoteBook.getNotebook().keySet().contains(s));
        assertEquals(0, ClassNoteBook.getNotebook().get(s).size());

    }

    @Test
    void testAddStudentInOrder(){
        ClassNoteBook ClassNoteBook = new ClassNoteBook();

        Student s = new Student(1,"John");
        Student s2 = new Student(3,"John");
        Student s3 = new Student(2,"John");
        ClassNoteBook.addStudent(s);
        ClassNoteBook.addStudent(s2);
        ClassNoteBook.addStudent(s3);

        assertEquals(List.of(s, s3, s2), new ArrayList<>(ClassNoteBook.getNotebook().keySet()));

        int i=1;
        for(Map.Entry<Student, List<Mark>> actual : ClassNoteBook.getNotebook().entrySet()){
            assertEquals(i, actual.getKey().getID());
            i++;
        }
    }

    @Test
    void testAddMark(){
        ClassNoteBook ClassNoteBook = new ClassNoteBook();

        Student s = new Student(1,"John");
        Student s2 = new Student(3,"John");
        Student s3 = new Student(2,"John");
        ClassNoteBook.addStudent(s);
        ClassNoteBook.addStudent(s2);
        ClassNoteBook.addStudent(s3);

        ClassNoteBook.addMark(2,5);

        assertEquals(5,ClassNoteBook.getNotebook().get(s3).get(0).getValue());

    }

}