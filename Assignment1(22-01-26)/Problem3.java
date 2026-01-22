/*Problem 3 – Methods & Reusability
Problem Statement
Create a Java program that has the following methods:
add(int a, int b) → returns sum
isEven(int number) → returns true/false
findFactorial(int number) → returns factorial
Call these methods from main() and print results. */

import java.util.*;
public class Problem3{

    static int add(int a,int b){
        int sum=a+b;
        return sum;
    }

    static boolean isEven(int number){
        if(number%2==0){
            return true;
        }
        else{
            return false;
        }
    }

    static long findFactorial(int number){
        long fact=1;
        for(int i=1;i<=number;i++){
            fact*=i;
        }
        return fact;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter two numbers a & b to add:");
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println("Enter a number to check  whether it is even and find it's factorial:");
        int number=sc.nextInt();
        System.out.println(add(a,b));
        System.out.println("Number is Even: "+isEven(number));
        System.out.println("Factorial of number "+number+" is: "+findFactorial(number));
    }
}
