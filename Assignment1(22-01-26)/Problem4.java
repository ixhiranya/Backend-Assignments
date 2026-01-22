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

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getMarks(){
        return marks;
    }

    public boolean isPassed(){
        return marks >= 40;
    }
}
public class Problem4 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Student ID:");
        int id=sc.nextInt();
        System.out.println("Enter Student Name:");
        sc.nextLine();
        String name=sc.nextLine();
        System.out.println("Enter Student Marks:");
        int marks=sc.nextInt();

        Student student=new Student(id,name,marks);
        System.out.println("Student ID: "+student.getId());
        System.out.println("Student Name: "+student.getName());
        System.out.println("Student Marks: "+student.getMarks());
        System.out.println("Is Passed: "+student.isPassed());
    }
}