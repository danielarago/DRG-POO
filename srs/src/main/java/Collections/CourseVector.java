package Collections;
import Entities.Student;
import java.util.*;

public class CourseVector implements CourseVectorExample{

    public static final int MAXIMUM_QUOTA = 30;
    private Vector <Student> students;

    public CourseVector () {
        students = new Vector<Student> (MAXIMUM_QUOTA);
    }

    public int numMaxStudents() {
        return MAXIMUM_QUOTA;
    }

    public int numRegisteredStudents() {
        return students.size();
    }

    public boolean addStudent(Student s) {
        boolean result = false;
        boolean exists = false;

        if (numRegisteredStudents() < MAXIMUM_QUOTA){
            for (int i=0; i<numRegisteredStudents(); i++){
                if (students.get(i).equals(s)){
                    exists = true;
                }
            }
            if (!exists){
                students.add(s);
                result = true;
            }
        }
        else if (numRegisteredStudents() == MAXIMUM_QUOTA){
            result = false;
        }

        return result;
    }

    public boolean removeStudent(Student s) {
        return students.removeElement(s);
    }

    public Student getStudent(Student s) {
        Student result = null;
        if (students.contains(s)){
            result = s;
        }
        return result;
    }

    public Student updateStudent(Student s){
        Student result = s;
        for (int i=0; i<numRegisteredStudents(); i++){
            Student student = students.get(i);
            if (s.getId() == student.getId()) {
                String nameS = s.getName();
                String nameStudent = student.getName();
                student.changeName(student, s.getName());
                result = student;
            }
        }
        return result;
    }
}
