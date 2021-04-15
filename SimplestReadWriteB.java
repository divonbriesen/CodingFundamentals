import java.io.*;
import java.util.*;
// about the most straightforward way to read from one file and put into another
// the B version has things the same but arranged together (i.e. declarations with each other)
public class SimplestReadWriteB
{
    public static void main (String[] args) throws IOException
    {
        // reads the whole file
        File aFile = new File("input.txt");
        Scanner input = new Scanner(aFile);
        PrintWriter output = new PrintWriter("output.txt");

        String allLines = "";

        // loops thru file if there's another line to read and puts them all together
        while(input.hasNext())
        {
            String thisLine = input.nextLine();
            System.out.println("Just read: " + thisLine);
            allLines +=  thisLine + "\n"; 
        }
        output.write(allLines);

        input.close();
        output.close();
    }
}