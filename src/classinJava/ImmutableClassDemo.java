package classinJava;

import java.util.ArrayList;
import java.util.List;

public class ImmutableClassDemo {
    public static void main(String[] args) {
        Student student1 = new Student("SURAJ", 75);
        Student student2 = new Student("CZAR", 100);
        List<Student>  studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);

        ImmutableClass immutableClass = new ImmutableClass(1000);
        immutableClass.getStudents();

        //after modifying student internally
        student1.setId(458);
        immutableClass.getStudents();

    }


}

final class ImmutableClass{
    private final int classId;
    private  final List<Student> students;
     ImmutableClass( int classId){
        this.classId=classId;
        this.students=new ArrayList<>();
    }

    public void getStudents() {
        for(Student student:students){
            System.out.println(student.getId()+" , "+student.getName());
        }
    }

    // Private method, only used inside the class
    private void addStudent(String name, int id) {
        students.add(new Student(name, id));
    }


    public int getClassId() {
        return classId;
    }
}

class Student{
    int id;
    String name;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}