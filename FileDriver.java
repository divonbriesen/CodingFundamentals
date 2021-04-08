import java.io.*;
import java.util.Scanner;

public class FileDriver
{
    public static void main(String[] args)
    {
        String welcome = "Welcome to the Jelani Company. We hug.";
        System.out.println(welcome.toUpperCase());
        
        if(args.length == 1) 
        { 
            System.out.println("Looks like you want to read from " + args[0]);
        }
        else if (args.length == 2)
        {
            System.out.println("Looks like you want to read from " + args[0] + " and write to " + args[1]);
        }
        else 
        {
            System.out.println("I don't see 1 or 2 command line arguments, so i'm not going to take you seriously.");
        }

        String fileToRead = "filename4.txt";

        Scanner console = new Scanner(System.in);

        try 
        {
            File inputFile = new File(fileToRead);
            Scanner fileReader = new Scanner(inputFile);
 
            int counter = 0;

            while (fileReader.hasNextLine()) 
            {
             // System.out.println(fileReader.hasNextLine());
              String inputString = fileReader.nextLine();
                // want to count words in this line
                // von Briesen, D.I. - 4/1/21 9:45am - Yes, and i thought it was pretty straightforward, but definitely had materials one would have had to study. Grateful there were no enums or obscure access modifier questions.	von Briesen D.I. 1/30/21 9:45 am - i’d like to have fixed the syllabus stuff and quiz so it had my information in it (or at least generic information)	Von Briesen, D.I. - 3/25/21 9:25am - this pandemic thing is gonna be big- buy stocks and move somewhere cool to work remotely!	von Briesen, D.I. - 3/23/21 9:41 am - umm… it’s easier than C?	1213 - 3/18/21	1213  -  3/16/21	1213 - 3/11/21	1213 3/9/21 - what you'd like changed about canvas	1213 3/4/21 most confusing item	1213 3/2/21 favorite thing	1213 2/25/21 - thursday - least favorite thing about class	1213 2/23/21 - tuesday	1213 2/18/2021 Thursday	1213 2/16/2021 Tuesday 	1213 2/4/2021 Thursday	1213 2/2/2021 Tuesday	1213 1/28/2021 - Thursday	1213 1/26/2021 - Tuesday

               counter++; 

               String[] brokenStringList = inputString.split("\\t");  // replace a method with the THING IT RETURNS
                
               for(int i = 0; i < brokenStringList.length; i++)
                {
                    //brokenStringList[i] = brokenStringList[i].trim();
                    brokenStringList[i].replaceAll(" ", "BOOYAHHH");

                    String[] brokenBySpaces = brokenStringList[i].split(" ");
                    
                    for(String thisString : brokenBySpaces)
                    {
                        System.out.println(i + "<< " + thisString);
                    }

                    System.out.println(i + "> " + brokenStringList[i]);
                }


              System.out.println(counter + ") " + inputString);
            }
            System.out.println("You read " + counter + " lines.");
            fileReader.close();
          } // end try
          catch (FileNotFoundException e) 
          {
            System.out.println("An error occurred.");
            e.printStackTrace();
          } // end catch


        System.out.println("END\n");
    }

}