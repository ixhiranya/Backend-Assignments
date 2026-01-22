/*Problem 1 – Basic Program Flow & Conditions
Problem Statement
Create a Java program that:
Accepts a number from the user
Checks whether the number is:
Positive, Negative, or Zero
Even or Odd
Prints the result */

import java.util.Scanner;
public class Problem1{
    static void EvenOdd(int n){
        if(n%2==0){
            System.out.print(" and Even");
        }
        else{
            System.out.print(" and Odd");
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n=sc.nextInt();
        System.out.print("The number is :");
        if(n>0){
            System.out.print(" Positive");
            EvenOdd(n);
        }
        else if(n<0){
            System.out.print(" Negative");
            EvenOdd(n);
        }
        else{
            System.out.println(" Zero");
        }
    }
}