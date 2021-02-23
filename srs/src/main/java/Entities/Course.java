package Entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Entities.Course
 * Invariants:
 * 1. MAXIMUM_QUOTA > 8
 * 2. MAXIMUN_QUOTA >= number of registered students
 *
 * @author Daniela Ramirez
 */

public class Course {
    public static final int MAXIMUM_QUOTA = 30;
    private String name;
    private int credits;
    private int id;
    private List<Student> registeredStudents;
    private List<Course> preRequirements;

    public Course(int id, int credits, String name) {
        this.id = id;
        this.credits = credits;
        this.name = name;

        registeredStudents = new ArrayList<>();
    }

    /**
     * If it is possible to register a new student into the course. The conditions are:
     * 1. There is quota in the course
     * 2. The student has not been registered in the course
     * 3. The student meets the pre requirements
     *
     * @param student The student has to be added
     * @return true if the student has successfully registered, otherwise false
     */
    public boolean register(Student student) {
        boolean result = false;
        if (MAXIMUM_QUOTA > this.registeredStudents.size()){
            if (!registeredStudents.contains(student)){
                result = this.registeredStudents.add(student);
            }
        }
        return result;
    }
}
