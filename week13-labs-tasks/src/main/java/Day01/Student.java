package Day01;

import java.util.Objects;

public class Student implements Comparable<Student>{
    private int ID;
    private String name;

    public Student(int ID) {
        this.ID = ID;
    }
    public Student(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        return ID-o.ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return ID == student.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }
}
