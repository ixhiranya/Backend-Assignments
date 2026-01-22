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
            System.out.println("Even");
        }
        else{
            System.out.println("Odd");
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n>0){
            System.out.println("Positive");
            EvenOdd(n);
        }
        else if(n<0){
            System.out.println("Negative");
            EvenOdd(n);
        }
        else{
            System.out.println("Zero");
        }
    }
}