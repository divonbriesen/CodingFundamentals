import java.io.*; //needed for File and IOException
import java.util.*; //needed for Scanner class

public class BasicReaderWriter
{
    Scanner inputReader;
    PrintWriter outputWriter;

    // constructor will setup up file reader and writer when called
    public BasicReaderWriter(String _nameOfInputFile, String _nameOfOutputFile)
    {
        File inputFile = new File(_nameOfInputFile);
        inputReader = new Scanner(inputFile);
         
        PrintWriter outputWriter = new PrintWriter(_nameOfOutputFile);  
    }

    public String readLine()
    {
        String nextLine = inputReader.nextLine();
        return nextLine;
    }

    public String readAllLines()
    {
        String allLines = "";
        while(inputReader.hasNext()) //loop while there is more data to read         
        {            
            String thisLine = inputReader.nextLine(); // could also just call method readLine() above
            allLines += "\n" + thisLine;     // could just put += input.nextLIne
        }   
        return allLines;
    }

    public void writeLine(String _thisText)
    { // you can manipulate the string before you write it here if you want
        outputWriter.println(_thisText); 
    }

    public void closeConnections()
    {
        inputReader.close();
        outputWriter.close(); 
    }

   /* public static void main(String[] args) throws IOException      
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
            // stupid to add a line number on every line, but shows how you can

        }   
        input.close();  
        System.out.println("Just read thru the whole file. Now going to write to the new one.");
        
        // setup all the output ///////////////////////////////////////////////////
        String filename = "myoutput.txt";      // File name           
        PrintWriter output = new PrintWriter(filename); 
        
        allText = allText.replace(" ", "$$$"); // stupid thing to do, but illustrates how it works
        output.println(allText);    
        output.close();   

        System.out.println("Data written to the file.");   
        */
    } // end main
} // end class