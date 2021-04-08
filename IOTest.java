import java.io.*; //needed for File and IOException
import java.util.*; //needed for Scanner class

public class IOTest
{   
    public static void main(String[] args) throws IOException      
    {         
        File aFile = new File("sentences.txt");
        Scanner input = new Scanner(aFile);

        PrintWriter output; 
        String filename = "myoutput.txt";      // File name           
        output = new PrintWriter(filename); 

 
        String allText = "";

        while(input.hasNext()) //loop while there is more data to read         
        {            
            String thisLine = input.nextLine();
            allText += thisLine;     // could just put += input.nextLIne
        }           

        //System.out.println(allText);
        output.println(allText);    
        
        input.close();     
        output.close();   

        System.out.println("Data written to the file.");   

    } // end main
} // end class
