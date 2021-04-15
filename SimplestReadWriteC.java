import java.io.*;
import java.util.*;

// same as B but deals with some numbers  - takes in lines, converts them to arrays, then cycles
// thru each value in the array and tries to convert it to a number - failing that it converts it to zero
// then puts it all out into another document. Currently line breaks are awkward.
public class SimplestReadWriteC
{
    public static void main (String[] args) throws IOException
    {
        // reads the whole file
        File aFile = new File("input.txt");
        Scanner input = new Scanner(aFile);
        PrintWriter output = new PrintWriter("output.txt");

        String allLines = "";

        // loops thru file if there's another line to read and puts them all together
        // tries to convert words to numbers and if it can't... puts a zero?
        while(input.hasNext())
        {
            String thisLine = input.nextLine();
            System.out.println("Just read: " + thisLine);
            String[] thisLineOfThings = thisLine.split(" "); // breaks up items by space
            System.out.println("Just read in a line with " + thisLineOfThings.length + " item(s).");

            int thisNumber = 0;
            for(String thisOne: thisLineOfThings)
            {
                thisNumber = convertToNumber(thisOne);
                System.out.print(" - Converted " + thisOne + " to: " + thisNumber); 
                if(thisNumber != 0) // we care about it
                {
                    allLines +=  thisNumber + " ";
                }
            }
            allLines += "\n";  // puts return even when you don't want one
           // System.out.println(allLines.subString(allLines.length - 2, allLines.length);
             
        }

        output.write(allLines);

        input.close();
        output.close();
    }

    public static int convertToNumber(String _potentialNumber)
    {
        try
        {
            int aNumber = Integer.parseInt(_potentialNumber);
            return aNumber;
        }
        catch (Exception e)
        {
            return 0;
        }
    }
}