import Entities.Course;
import Entities.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    @Test
    @DisplayName("GIVEN a course with quota WHEN a Entities.Student attempts to register THEN should allow")

    public void shouldAllowStudentToRegister() {
        Student student = new Student(1, "Juan");
        Course course = new Course(1, 4,"POO");

        boolean result = course.register(student);
        assertTrue(result, "The student has been successfully registered");
    }

    @Test
    @DisplayName("GIVEN a course with no quota WHEN registering a Entities.Student THEN should not allow")
    public void shouldNotAllowStudentToRegister() {
        Course course = new Course(1, 4,"POO");

        for (int i = 0; i < Course.MAXIMUM_QUOTA; i++) {
            int id = i+1;
            Student student = new Student(id, "Juan "+id);
            course.register(student);
        }

        Student student = new Student(Course.MAXIMUM_QUOTA + 1, "Pedro");
        boolean result = course.register(student);
        assertFalse(result, "The student has not been registered");
    }

    @Test
    @DisplayName("GIVEN a course with the student already registered WHEN registering the Entities.Student THEN should not allow")
    public void shouldNotAllowStudentToRegisterTwice(){
        Student student = new Student(1, "Juan");
        Course course = new Course(1, 4,"POO");

        boolean result = course.register(student);
        assertTrue(result, "The student has been registered");

        result = course.register(student);
        assertFalse(result, "The student has not been registered");
    }
}
