import java.io.*; //needed for File and IOException
import java.util.*; //needed for Scanner class

public class ReadFile
{   
    public static void main(String[] args) throws IOException      
    {         
        // File aFile = new File("sentences.txt");
        // Scanner input = new Scanner(aFile);
        Scanner input = new Scanner(new File("sentences.txt")); 
        String allText = "";

        while(input.hasNext()) //loop while there is more data to read         
        {            
            String thisLine = input.nextLine();
            allText += thisLine;     // could just put += input.nextLIne
        }           

        System.out.println(allText);
        
        input.close();//call the close method when done reading from the file      

    } // end main
} // end class
