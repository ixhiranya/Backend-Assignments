/*Problem-2
Given an array of employee names (with duplicates):
Convert array → ArrayList
Remove duplicates using HashSet
Create a HashMap<String, Integer> for frequency count
Display data using multiple iteration techniques
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Problem2{
    public static void main(String args[]){
        String[] employees={"Hiranya","Ashmitha","Harati","Divya","Snehith","Abhishek","Ashmitha","Harati","Snehith"};

        //Array to ArrayList
        ArrayList<String> employeeList=new ArrayList<>(Arrays.asList(employees));
        System.out.println("Employee List: "+employeeList);

        //Remove duplicates
        HashSet<String> employeeSet=new HashSet<>(employeeList);
        System.out.println("Employees HashSet: "+employeeSet);

        //HashMap
        HashMap<String,Integer> frequencyMap=new HashMap<>();
        for(String emp:employeeList){
            frequencyMap.put(emp,frequencyMap.getOrDefault(emp,0)+1);
        }
        System.out.println("Employee Frequency Map: "+frequencyMap);

        //Iterator Techniques
        System.out.println("Using Iterator:");
        Iterator<String> it=employeeSet.iterator();
        while(it.hasNext()){
            String emp=it.next();
            System.out.println(emp+" : "+frequencyMap.get(emp));
        }

        //Display data using enhanced for-loop
        System.out.println("Using Enhanced For-Loop:");
        for(String emp:employeeSet){
            System.out.println(emp+" : "+frequencyMap.get(emp));
        }
    }
}