
import java.io.*; //needed for File and IOException
import java.util.*; //needed for Scanner class

/** * THis is a simple example of how to read data from a text file. 
 * * Before you run this, you must create a data file using Notepad. 
 * * Open Notepad, write about five sentences. Save the file and write 
 * * down where you save it and what you named it. *  
 * * Later in lecture we will discuss what happens if you 
 * * type the name of a non-existent file in the constructor call. */

public class ReadFile
{    //because this code is working with a FIle the throws clause    
    //must be added to the method heading    
    public static void main(String [ ] args) throws IOException      
    {         
        Scanner input;         
        //In the line blow, the path of the data file is sent to the File class constructor         
        //Be sure sentences.txt is saved in the same folder as this code.         
        input = new Scanner(new File("sentences.txt")); 
        //create a Scanner object sending a File reference to the constructor         
        //the hasNext( ) method of the Scanner class returns         
        //true if there is more data in the file that has not         
        //yet been read    
        String allText = "";

        while(input.hasNext( )) //loop while there is more data to read         
        {            
            //read an entire line of text from the file            
            //and print it to the screen             
        //    System.out.println(input.nextLine( ));   
            String thisLine = input.nextLine();
          //  System.out.println(thisLine);
            allText += thisLine;     // keeps adding to the variable
        }           

        System.out.println(allText);
        
        input.close( );//call the close method when done reading from the file      

    } // end main
} // end class
