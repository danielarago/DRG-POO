package Collections;
import Entities.Student;

public interface CourseVectorExample {
    int numMaxStudents();

    int numRegisteredStudents();

    boolean addStudent(Student s);

    boolean removeStudent(Student s);

    Student getStudent(Student s);

    Student updateStudent(Student s);
}
