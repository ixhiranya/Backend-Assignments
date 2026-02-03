/*Problem-1
Create a program that:
Reads a paragraph from a file.
Performs the following:
Count total words, sentences, and characters (excluding spaces).
Find the top 5 most frequent words (case-insensitive).
Replace multiple spaces with a single space.
Reverse each sentence without changing word order.
Compare strings using both == and equals() and print results with explanation.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Problem1{
    public static void main(String[] args) {
    FileReader fr = null;
    try{
        fr=new FileReader("C://Innovatechs//Backend_Assignments//Assignment2(27-01-26)/input.txt");
        BufferedReader br=new BufferedReader(fr);
        StringBuilder sb=new StringBuilder();
        String line;
        while((line=br.readLine())!=null){
            sb.append(line).append(" ");
        }
        String paragraph=sb.toString().trim();

        //No of words
        String[] words=paragraph.split("\\s+");
        System.out.println("Total no of words: "+words.length);

        //No of sentences
        String[] sentences=paragraph.split("[.!?]+");
        System.out.println("Total no of sentences: "+sentences.length);

        //No of characters excluding spaces
        String paragraphNoSpaces=paragraph.replace(" ","");
        System.out.println("Total no of characters (excluding spaces): "+paragraphNoSpaces.length());

        //Top 5 frequent words
        HashMap<String,Integer> wordCount=new HashMap<>();
        for(String word:words){
            String w=word.toLowerCase();
            if(w.length()>0){
                wordCount.put(w,wordCount.getOrDefault(w,0)+1);
            }
        }
        System.out.println("Top 5 most frequent words:");
        for(int i=0;i<5;i++){
            String maxWord="";
            int maxCount=0;
            for(String w:wordCount.keySet()){
                if(wordCount.get(w)>maxCount){
                    maxCount=wordCount.get(w);
                    maxWord=w;
                }
            }
            if(maxCount>0){
                System.out.println(maxWord+": "+maxCount);
                wordCount.remove(maxWord);
            }
        }

        //Replacing multiple spaces with single space
        String singleSpacedParagraph=paragraph.replaceAll("\\s+"," ");
        System.out.println("Paragraph with single spaces:\n"+singleSpacedParagraph);

        //Reversing each sentence
        System.out.println("Reversed sentences:");
        for(String sentence:sentences){
            String trimmedSentence=sentence.trim();
            String[] sentenceWords=trimmedSentence.split("\\s+");
            StringBuilder reversedSentence=new StringBuilder();
            for(int i=sentenceWords.length-1;i>=0;i--){
                reversedSentence.append(sentenceWords[i]);
                if(i!=0) reversedSentence.append(" ");
            }
            System.out.println(reversedSentence.toString());
        }
        br.close();
    }  catch(IOException e){
        System.out.println("An error occurred: "+e.getMessage()); 
    }
    String s1="Hello";
        String s2="Hello";
        String s3=new String("Hello");
        
        //Comparing strings
        System.out.println(s1==s2); 
        System.out.println(s1==s3);
        System.out.println(s1.equals(s2)); 
        System.out.println(s1.equals(s3));
        //'==' checks for reference equality, while 'equals()' checks for value equality.        
    }
}