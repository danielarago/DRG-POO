package Entities;

/**
 * Represents a Student
 *
 * @author Daniela Ramírez
 */

public class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Student changeName(Student s, String newName){
        s.name = newName;
        return s;
    }

    @Override
    public boolean equals(Object o){

        //verificar not null
        if (o == null){
            return false;
        }

        //verificar que object sea instancia de student
        if (!(o instanceof Student)){
            return false;
        }

        //casteo
        Student s = (Student)o;

        //validar
        return this.id == s.getId();
    }
}
