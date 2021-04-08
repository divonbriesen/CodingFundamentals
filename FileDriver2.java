import java.io.*;
import java.util.Scanner;

public class FileDriver2
{
    public static void main(String[] args)
    {
        String welcome = "Welcome to the Jelani Company. We hug.";
        System.out.println(welcome.toUpperCase());
        
        //try (BufferedReader br = new BufferedReader(
        //    new FileReader(fileName, StandardCharsets.UTF_8))) {

        try 
        {
            String fileToRead = "filename.txt"; // this is just a string
            File anInputFile = new File(fileToRead); // creates the representation of the actual file within code
    
            FileReader aFileReader = new FileReader(anInputFile);
            BufferedReader aBufferedReader = new BufferedReader(aFileReader);
    
            Scanner console = new Scanner(System.in);
            //Scanner fileReader = new Scanner(inputFile);
 
            int counter = 0;
            String sInputString = "";
            try
            {
                while ((sInputString = aBufferedReader.readLine()) != null) // does 3 things at once
                { 
                    // strings are immutable! What does that mean?
                    sInputString = sInputString.replaceAll("\\t", ""); // replaces tabs with nothing
                    sInputString = sInputString.replaceAll(".", "\n"); // replace double spaces with single 
                
                    // want to count words in this line
                counter++; 
                if (sInputString.length() > 10) // worth looking at- otherwise it's a blank line
                {
                String[] brokenStringList = sInputString.split("\\t");  // replace a method with the THING IT RETURNS
                    
                for(int i = 0; i < brokenStringList.length; i++)
                    {
                        //brokenStringList[i] = brokenStringList[i].trim();
                        brokenStringList[i] = brokenStringList[i].replaceAll(" ", "BOOYAHHH");

                        String[] brokenBySpaces = brokenStringList[i].split(" ");
                        
                        for(String thisString : brokenBySpaces)
                        {
                     //       System.out.println(i + "<< " + thisString);
                        } // end 2nd for

                     //   System.out.println(i + "> " + brokenStringList[i]);
                    } // end first for
                } // end if length >1

                //System.out.println(counter + ") " + sInputString + ", which is " + sInputString.length() + " chars long.");
                if (sInputString.length() > 0) System.out.println(counter + ". " + sInputString);    
            } // end while

                aBufferedReader.close();
            } // end try file read
            catch(Exception e)
            {
                System.out.println("Couldn't read the file: " + e);
            }
            System.out.println("You read " + counter + " lines.");

          } // end try
          catch (FileNotFoundException e) 
          {
            System.out.println("An error occurred.");
            e.printStackTrace();
          } // end catch


        System.out.println("END\n");
    }

}