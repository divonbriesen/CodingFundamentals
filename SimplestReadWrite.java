import java.io.*;
import java.util.*;
// about the most straightforward way to read from one file and put into another
public class SimplestReadWrite
{
    public static void main (String[] args) throws IOException
    {
        // reads the whole file
        File aFile = new File("input.txt");
        Scanner input = new Scanner(aFile);

      //  String aLine = input.nextLine();
      //  System.out.println(aLine); // reads and outputs at same time

        String allLines = "";

        // loops thru file if there's another line to read and puts them all together
        while(input.hasNext())
        {
            String thisLine = input.nextLine();
            System.out.println("Just read: " + thisLine);
            allLines +=  thisLine + "\n"; 
        }

        input.close();

        // write to file
        PrintWriter output = new PrintWriter("output.txt");
        output.write(allLines);

        output.close();
    }
}