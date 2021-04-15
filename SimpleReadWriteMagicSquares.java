import java.io.*;
import java.util.*;

// same as B but deals with some numbers  - takes in lines, converts them to arrays, then cycles
// thru each value in the array and tries to convert it to a number - failing that it converts it to zero
// then puts it all out into another document. Currently line breaks are awkward.
public class SimpleReadWriteMagicSquares
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

            String[] thisLineOfThings = thisLine.split(" "); // breaks up items by space

            int numberCount = thisLineOfThings.length; // need to see if it's cubed
            System.out.println("\nJust read: " + thisLine + ", which has  " + numberCount + " item(s): ");

            if (Math.sqrt(numberCount) %1 == 0) // square root is evenly divisible by a whole number
            { 
                System.out.print(" This could be a square!");
            }
            else System.out.print(" This can't be a square!" );

            int thisNumber = 0;
            for(String thisOne: thisLineOfThings)
            {
                thisNumber = Integer.parseInt(thisOne);
                //System.out.print(" " + thisOne + " => " + thisNumber); 
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
}