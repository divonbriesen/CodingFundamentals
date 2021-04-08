import java.io.*;   // Needed for File and IOException

public class WriteFileB
{      public static void main(String[] args) throws IOException   
    {      
        String filename = "myoutput.txt";      // File name           
        PrintWriter output = new PrintWriter(filename);           
        output.println("Now is the summer of our discontent");          
        output.close();              
        System.out.println("Data written to the file.");      
    }
}