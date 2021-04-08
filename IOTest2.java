import java.io.*; //needed for File and IOException
import java.util.*; //needed for Scanner class

public class IOTest2
{   
    public static void main(String[] args) throws IOException      
    {   // setup all the input
        File inputFile = new File("sentences.txt");
        Scanner input = new Scanner(inputFile);

        String allText = "";
        int counter = 1;
        while(input.hasNext()) //loop while there is more data to read         
        {            
            String thisLine = input.nextLine();
            // do some other operations with this one line of code
            allText += "\n" + counter++ + thisLine;     // could just put += input.nextLIne

        }   
        input.close();  
        System.out.println("Just read thru the whole file. Now going to write to the new one.");
        
        // setup all the output //////////////////////////////////////////////////////////////////
        String filename = "myoutput.txt";      // File name           
        PrintWriter output = new PrintWriter(filename); 
        
        allText = allText.replace(" ", "$$$");
        output.println(allText);    
        output.close();   

        System.out.println("Data written to the file.");   
    } // end main
} // end class
