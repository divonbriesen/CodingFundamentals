
import java.util.*;
/** * Write a description of class Whitespace here. *  
 * * @author (your name)  
 * * @version (a version number or a date) */
public class Whitespace{ 
       public static void main(String[ ] args)    
    {        
        char symbol;        
        int count;        
        Scanner in;        
        in = new Scanner(System.in).useDelimiter("\\n");        
        count = 0;        
        System.out.print("Enter a character or a space to quit: ");        
        symbol = in.next( ).charAt(0);      
        //  in.nextLine( );        
        while(symbol != ' ')        
        {            count ++;            
            System.out.print("Enter a character or a space to quit: ");            
            symbol = in.next( ).charAt(0);         
            //   in.nextLine( );        
        }        System.out.println("Your entered " + count + " symbols");    
    }     
}
