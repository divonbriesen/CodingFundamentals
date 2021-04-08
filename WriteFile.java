
import java.util.Scanner; // Needed for Scanner
import java.io.*;   // Needed for File and IOException
/** *  This program is a simple example of how to write data to a file.  */

public class WriteFile
{  //because this code is working with a file you must  
   //add the throws clause to the method heading   
    public static void main(String[] args) throws IOException   
    {      
        String filename;      // File name      
        String friendName;    // Friend's name      
        int numFriends;       // Number of friends      
        Scanner keyboeard;    //will be used to get input from the user      
        PrintWriter output;   //will be used to write data to a file      
        // Create a Scanner object for keyboard input.      
        Scanner keyboard = new Scanner(System.in);      
        // Get the number of friends.      
        System.out.print("How many friends do you have? ");      
        numFriends = keyboard.nextInt();      
        // Consume the remaining newline character.      
        keyboard.nextLine();      
        // Get the name and location to write the date to      
        //Be sure you remeber the location you specify here      
        System.out.print("Enter the location and name of the file to write to: ");      
        filename = keyboard.nextLine();      
        // Open the file to accpet data      
        output = new PrintWriter(filename);     
        //Get data from user and write it to the file.      
        for (int i = 1; i <= numFriends; i++)      
        {         // Get the name of a friend.         
            System.out.print("Enter the name of friend " 
            +                          "number " + i + ": ");  
                   friendName = keyboard.nextLine();         
                   // Write the friend's name to the file.         
                   //Notice this is very similar to System.out.println         
                   output.println(friendName);      
        }      // Close the file so the end of file marker is written      
                //to the data file      
                output.close();      
                //inform the user the task is complete      
                System.out.println("Data written to the file.");      
                //once you run this, look in your folder to see if the text file was created.      
                //Open it and see that it saved your output.   
    }
}