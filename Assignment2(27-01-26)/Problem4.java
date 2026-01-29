/*Create a program that:
Accepts numeric input as strings.
Converts them into appropriate wrapper objects.
Stores them in a List<Number>.
Calculates:
Sum of all integers
Average of floating-point numbers
Logs invalid inputs. */

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Iterator;
import java.util.List;

public class Problem4 {
 public static void main(String[] args){
    //logging setup
    Logger logger=Logger.getLogger(Problem4.class.getName());
    String[] s=new String[]{"10","0.5","13","45.2","56"};

    List<Number> numbers=new ArrayList<>();
    for(String str:s){
        try{
            if(str.contains(".")){
                Double d=Double.parseDouble(str);
                numbers.add(d);
            }else{
                Integer i=Integer.parseInt(str);
                numbers.add(i);
            }
        }catch(NumberFormatException e){
            logger.log(Level.SEVERE,"Invalid input: " + str);
        }
    }

    int sum=0;
    for(Number num:numbers){
        if(num instanceof Integer){
            sum+=num.intValue();
        }
    }
    System.out.println("Sum of integers: " + sum);

    // double floatSum=0.0;
    // int floatCount=0;
    // for(Number num:numbers){ //for-each 
    //     if(num instanceof Double){
    //         floatSum+=num.doubleValue();
    //         floatCount++;
    //     }
    // }
    // System.out.println("Average of floating-point numbers: " + (floatCount>0 ? floatSum/floatCount : 0));
     
    double floatSum=0.0;
    Iterator<Number> iterator=numbers.iterator(); //iterator method
    int floatCount=0;
    while(iterator.hasNext()){
        Number num=iterator.next();
        if(num instanceof Double){
            floatSum+=num.doubleValue();
            floatCount++;
        }
    }
    System.out.println("Average of floating-point numbers: " + (floatCount>0 ? floatSum/floatCount : 0));

 }    
}
