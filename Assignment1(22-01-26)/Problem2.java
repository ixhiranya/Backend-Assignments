/*Problem 2 – Loops & Logic Building
Problem Statement
Write a Java program to:
Print numbers from 1 to N
Print all even numbers between 1 and N
Calculate the sum of numbers from 1 to N */

import java.util.Scanner;
public class Problem2{
    
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long sum=0;
        System.out.print("Numbers till "+ n +" : ");
        for(int i=1;i<=n;i++){
            System.out.print(i+" ");
            sum+=i;
        }
        System.out.println();
        System.out.print("Even Numbers till "+ n +" : ");
        for(int i=1;i<=n;i++){
            if(i%2==0){
                System.out.print(i+" ");
            }
        }
        System.out.println();
        System.out.println("Sum: "+sum);
    }
}
