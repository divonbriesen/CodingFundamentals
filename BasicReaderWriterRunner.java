import java.io.*;
public class BasicReaderWriterRunner
{
    public static void main (String[] args) throws Exception
    {
        System.out.println("START");

        try
        {
            BasicReaderWriter aReaderWriter = new BasicReaderWriter("magicsquaredata.txt", "myoutput.txt");

            String aLine = aReaderWriter.readLine();
            System.out.println("The line says: " + aLine);

            String allLines = aReaderWriter.readAllLines();
            System.out.println("All of it says: " + allLines);

            aReaderWriter.writeLine(allLines);

            aReaderWriter.closeConnections();
        }
        catch (Exception e)
        {
          //  System.out.println("I'm afraid you had a file problem. Not gonna try: " + e);
        }




        // call the methods
        System.out.println("END");
    }
}