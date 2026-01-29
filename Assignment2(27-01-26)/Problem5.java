/*PROBLEM-5
Write a Java program that reads student details from a text file, processes the data, and writes the results to another file.
 
Each line in the input file contains:
id,name,age
 
The program should:
Read the file line by line
Clean and format the data
Ignore duplicate student entries
Handle invalid data without stopping the program
Store and display processed data
Write valid and invalid records to separate files
Log important steps during execution*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

class Student {
    int id;
    String name;
    int age;
    
    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student other = (Student) obj;
        return id == other.id;
    }
} 

public class Problem5 {
    public static void main(String[] args){
        Logger logger=Logger.getLogger(Problem5.class.getName());
        HashSet<Student> students=new HashSet<>();
        FileReader fr=null;
        BufferedReader br=null;
        FileWriter validFw=null;
        BufferedWriter validBw=null;
        FileWriter invalidFw=null;
        BufferedWriter invalidBw=null;
        try{
            fr=new FileReader("C://Innovatechs//Backend_Assignments//Assignment2(27-01-26)/students.txt");
            br=new BufferedReader(fr);
            validFw=new FileWriter("C://Innovatechs//Backend_Assignments//Assignment2(27-01-26)/valid.txt");
            validBw=new BufferedWriter(validFw);
            invalidFw=new FileWriter("C://Innovatechs//Backend_Assignments//Assignment2(27-01-26)/invalid.txt");
            invalidBw=new BufferedWriter(invalidFw);

            List<String> lines = new ArrayList<>();
            String line;
            while((line = br.readLine()) != null){
                lines.add(line);
            }

            Map<Integer, Integer> idCounts = new HashMap<>();
            for(String l : lines){
                String[] p = l.split(",");
                if(p.length == 3){
                    try{
                        int id = Integer.parseInt(p[0].trim());
                        idCounts.put(id, idCounts.getOrDefault(id, 0) + 1);
                    }catch(NumberFormatException e){
                        // non-numeric id: ignore for counting
                    }
                }
            }

            HashSet<Integer> seenIds = new HashSet<>();
            for(String l : lines){
                String[] parts = l.split(",");
                try{
                    if(parts.length != 3){
                        logger.log(Level.SEVERE, "Invalid input: " + l);
                        invalidBw.write(l);
                        invalidBw.newLine();
                        continue;
                    }
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim().replaceAll("\\s+"," ");
                    int age = Integer.parseInt(parts[2].trim());

                    if(seenIds.contains(id)){
                        // subsequent occurrence -> invalid
                        logger.log(Level.INFO, "Duplicate student found: " + l);
                        invalidBw.write(l);
                        invalidBw.newLine();
                        continue;
                    } else {
                        // first occurrence
                        seenIds.add(id);
                        if(age < 18 && idCounts.getOrDefault(id, 0) < 2){
                            // underage and not duplicated -> invalid
                            logger.log(Level.WARNING, "Invalid age for student: " + l);
                            invalidBw.write(l);
                            invalidBw.newLine();
                            continue;
                        } else {
                            // accept (either age>=18 or duplicated id with first allowed)
                            Student studentObj = new Student(id, name, age);
                            students.add(studentObj);
                            String validLine = id + "," + name + "," + age;
                            validBw.write(validLine);
                            validBw.newLine();
                            logger.log(Level.INFO, "Added student: " + validLine);
                        }
                    }
                }catch(NumberFormatException e){
                    logger.log(Level.SEVERE, "Number format exception for line: " + l + " - " + e.getMessage());
                    invalidBw.write(l);
                    invalidBw.newLine();
                }catch(Exception e){
                    logger.log(Level.SEVERE, "Error processing line: " + l + " - " + e.getMessage());
                    invalidBw.write(l);
                    invalidBw.newLine();
                }
            }
        }catch(IOException e){
            logger.log(Level.SEVERE,"IO Exception: " +e.getMessage());
        }catch(Exception e){
            logger.log(Level.SEVERE,"Exception: " +e.getMessage());
        }finally{
            try{
                if(br!=null) br.close();
                if(fr!=null) fr.close();
                if(validBw!=null) validBw.close();
                if(validFw!=null) validFw.close();
                if(invalidBw!=null) invalidBw.close();
                if(invalidFw!=null) invalidFw.close();
            }catch(IOException e){
                logger.log(Level.SEVERE,"Error closing resources: " +e.getMessage());
            }
        }
    }
    
}
