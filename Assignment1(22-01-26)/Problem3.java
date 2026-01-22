/*Problem 3 – Methods & Reusability
Problem Statement
Create a Java program that has the following methods:
add(int a, int b) → returns sum
isEven(int number) → returns true/false
findFactorial(int number) → returns factorial
Call these methods from main() and print results. */

import java.util.*;
public class Problem3{

    static void add(int a,int b){
        System.out.println("Sum: "+(a+b));
    }

    static boolean isEven(int number){
        if(number%2==0){
            return true;
        }
        else{
            return false;
        }
    }

    static void findFactorial(int number){
        long fact=1;
        for(int i=1;i<=number;i++){
            fact*=i;
        }
        System.out.println("Factorial of number "+"n :"+fact);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int number=sc.nextInt();
        add(a,b);
        System.out.println("Is Even: "+isEven(number));
        findFactorial(number);
    }
}
