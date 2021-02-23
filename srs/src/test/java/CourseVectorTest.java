import Entities.Student;
import Collections.CourseVector;
import Collections.CourseVectorExample;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class CourseVectorTest {

    @Test
    @DisplayName("GIVEN a course with quota WHEN a student attempts to register SHOULD allow and add them to course")
    public void shouldAddStudent(){
        Student student1 = new Student(1, "Marco");
        Student student2 = new Student(2, "Polo");
        CourseVectorExample course = new CourseVector();

        assertTrue(course.addStudent(student1), "The student was successfully registered");
        assertTrue(course.addStudent(student2), "The student was successfully registered");
        assertEquals(2, course.numRegisteredStudents());
    }

    @Test
    @DisplayName("GIVEN a course with quota WHEN an already registered student (identified with their id) attempts to register SHOULD not add them to course")
    public void shouldNotAddStudentTwice(){
        Student student1 = new Student(1, "Marco");
        Student student2 = new Student(1, "Polo");
        CourseVectorExample course = new CourseVector();

        assertTrue(course.addStudent(student1), "The student was successfully registered");
        assertFalse(course.addStudent(student2), "The student was not successfully registered");
        assertEquals(1, course.numRegisteredStudents());
    }

    @Test
    @DisplayName("GIVEN a course without quota WHEN a student attempts to register SHOULD not add them to course")
    public void shouldNotAddStudentWhenNoQuota(){
        Student student1 = new Student(1, "Marco");
        CourseVectorExample course = new CourseVector();

        for (int i=0; i<course.numMaxStudents(); i++){
            course.addStudent(new Student(i, "Polo"));
        }

        assertFalse(course.addStudent(student1), "The student was not successfully registered");
        assertEquals(course.numRegisteredStudents(), course.numMaxStudents());
    }

    @Test
    @DisplayName("GIVEN a student that is registered in a course WHEN removing them SHOULD delete them from course")
    public void shouldRemoveAStudent(){
        Student student1 = new Student(1, "Marco");
        Student student2 = new Student(2, "Polo");
        CourseVectorExample course = new CourseVector();

        assertTrue(course.addStudent(student1), "The student was successfully registered");
        assertTrue(course.addStudent(student2), "The student was successfully registered");
        assertEquals(2, course.numRegisteredStudents());

        assertTrue(course.removeStudent(student1), "The student was successfully removed");
        assertEquals(1, course.numRegisteredStudents());
    }

    @Test
    @DisplayName("GIVEN a student that is not registered in a course WHEN removing them SHOULD not allow")
    public void shouldNotRemoveAStudent(){
        Student student1 = new Student(1, "Marco");
        Student student2 = new Student(2, "Polo");
        Student student3 = new Student(3, "Amelia");
        CourseVectorExample course = new CourseVector();

        assertTrue(course.addStudent(student1), "The student was successfully registered");
        assertTrue(course.addStudent(student2), "The student was successfully registered");
        assertEquals(2, course.numRegisteredStudents());

        assertFalse(course.removeStudent(student3), "The student does not exist");
        assertEquals(2, course.numRegisteredStudents());
    }

    @Test
    @DisplayName("GIVEN a student that is registered in a course WHEN attempting to find them SHOULD get the student")
    public void shouldGetStudent(){
        Student student1 = new Student(1, "Marco");
        Student student2 = new Student(2, "Polo");
        CourseVectorExample course = new CourseVector();

        assertTrue(course.addStudent(student1), "The student was successfully registered");
        assertTrue(course.addStudent(student2), "The student was successfully registered");
        assertEquals(2, course.numRegisteredStudents());

        assertEquals(student1, course.getStudent(student1), "The student was successfully retrieved");
    }

    @Test
    @DisplayName("GIVEN a student that is not registered in a course WHEN attempting to find them SHOULD not get the student")
    public void shouldNotGetStudent(){
        Student student1 = new Student(1, "Marco");
        Student student2 = new Student(2, "Polo");
        Student student3 = new Student(3, "Amelia");
        CourseVectorExample course = new CourseVector();

        assertTrue(course.addStudent(student1), "The student was successfully registered");
        assertTrue(course.addStudent(student2), "The student was successfully registered");
        assertEquals(2, course.numRegisteredStudents());

        assertNull(course.getStudent(student3), "The student does not exist");
    }

    @Test
    @DisplayName("GIVEN a student that is registered in a course WHEN attempting to change any part of their information SHOULD update the student in course")
    public void shouldUpdateNameOfStudent(){
        Student student1 = new Student(1, "Marco");
        Student student2 = new Student(2, "Polo");
        CourseVectorExample course = new CourseVector();

        assertTrue(course.addStudent(student1), "The student was successfully registered");
        assertTrue(course.addStudent(student2), "The student was successfully registered");
        assertEquals(2, course.numRegisteredStudents());

        Student student3 = new Student(1, "Amelia");
        assertNotNull(course.updateStudent(student3), "The right student was found");
        assertEquals(student3.getName(), course.getStudent(student1).getName(),"The student was succcessfully updated");
    }

    @Test
    @DisplayName("GIVEN a student that is not registered in a course WHEN attempting to change any part of their information SHOULD not update the student in course")
    public void shouldNotUpdateStudent(){
        Student student1 = new Student(1, "Marco");
        Student student2 = new Student(2, "Polo");
        Student student3 = new Student(1, "Amelia");
        CourseVectorExample course = new CourseVector();

        assertTrue(course.addStudent(student1), "The student was successfully registered");
        assertTrue(course.addStudent(student2), "The student was successfully registered");
        assertEquals(2, course.numRegisteredStudents());

        assertEquals(student3, course.updateStudent(student3), "The student does not exist");
    }
}
