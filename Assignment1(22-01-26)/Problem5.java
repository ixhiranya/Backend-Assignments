/*Problem 5 – Static, Multiple Objects & Mini Scenario
Problem Statement
Create a class Employee with:
Fields:
id, name, monthlySalary
Static field:
companyName
Constructor
Method:
calculateAnnualSalary()
Method:
displayEmployeeDetails()
Create at least 2 Employee objects and print their details. */

import java.util.*;

class Employee{
    private int id;
    private String name;
    private double monthlySalary;

    static String companyName="Innovatechs";

    public Employee(int id, String name, double monthlySalary){
        this.id=id;
        this.name=name;
        this.monthlySalary=monthlySalary;
    }

    public double calculateAnnualSalary(){
        return monthlySalary * 12;
    }

    public void displayEmployeeDetails(){
        System.out.println("Employee ID: "+id);
        System.out.println("Employee Name: "+name);
        System.out.println("Monthly Salary: "+monthlySalary);
        System.out.println("Company Name: "+companyName);
        System.out.println("Annual Salary: "+calculateAnnualSalary());
    }

}

public class Problem5{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Employee 1 details:");
        System.out.print("ID: ");
        int id1=sc.nextInt();
        System.out.print("Name: ");
        sc.nextLine();
        String name1=sc.nextLine();
        System.out.print("Monthly Salary: ");
        double salary1=sc.nextDouble();

        System.out.println("Enter Employee 2 details:");
        System.out.print("ID: ");
        int id2=sc.nextInt();
        System.out.print("Name: ");
        sc.nextLine();
        String name2=sc.nextLine();
        System.out.print("Monthly Salary: ");
        double salary2=sc.nextDouble();
         
        Employee emp1=new Employee(id1,name1,salary1);
        Employee emp2=new Employee(id2,name2,salary2);

        System.out.println("Result:");
        System.out.println("\nEmployee 1 Details:");
        emp1.displayEmployeeDetails();
        System.out.println("\nEmployee 2 Details:");
        emp2.displayEmployeeDetails();
    }
}