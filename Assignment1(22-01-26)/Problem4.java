/*Problem 4 – OOP: Class, Object & Encapsulation
Problem Statement
Create a class Student with:
Private fields:
id
name
marks
Constructor to initialize values
Getters and setters
Method:
isPassed() → returns true if marks ≥ 40
Create objects of Student and display result. */

import java.util.*;

class Student{
    private int id;
    private String name;
    private int marks;

    public Student(int id, String name, int marks){
        this.id=id;
        this.name=name;
        this.marks=marks;
    }

    public void setId(int id){
        this.id=id;
    }

    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setMarks(int marks){
        this.marks=marks;
    }

    public int getMarks(){
        return marks;
    }

    public boolean isPassed(){
        return marks >= 40;
    }

    public void displayStudentDetails(){
        System.out.println("Student ID: "+getId());
        System.out.println("Student Name: "+getName());
        System.out.println("Student Marks: "+getMarks());
        if(isPassed()){
            System.out.println("Status: Passed");
        }
        else{
            System.out.println("Status: Failed");
        }
    }
}
public class Problem4 {
    public static void main(String args[]){
        Student s=new Student(0, null, 0);
        s.setId(1);
        s.setName("Hiranya");
        s.setMarks(95);
        s.displayStudentDetails();
    }
}