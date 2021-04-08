import java.util.*;

public class IfElsaPalooza
{


    public static void main(String[] commandLineArguments)
    {
        for(int j = 1; j <= 140; j++)
        {
            System.out.print("=");
        }
        String welcomeMessage = "YO YO YO YO YO YO YO YO YO YO";
        System.out.println("\n" + welcomeMessage);

        Scanner console = new Scanner(System.in);


        System.out.println("Are you happy today? ");
        String sInput = console.nextLine();
        System.out.println("You typed in : " + sInput);

        boolean userIsHappy = sInput.equalsIgnoreCase("yes"); // change to check for firstletter only as "y" - substrining

        if(sInput.equals(userIsHappy)) System.out.println("GREAT!! (Clap your hands...)");
        else System.out.println("Sorry....");

        int startNumber = 1;
        int endNumber = 1;

        for(int i = startNumber; i <= endNumber; i++)  
        // for(; startNumber <= endNumber; startNumber++)
        {
           

            if(i % 10 == 0) 
            { 
                System.out.print(i + ") SHAKE!"); 
                for(int j = 1; j <= 5; j++)
                {
                    System.out.print("Shake Shake yer body!");
                }
                System.out.println("");
            }
            else 
            { 
                System.out.println(i + ") STIR!");
            }

            // $93.93  4 20's 1 10, 3 1's 3 quarters 1 dime 1 nicke 3 pennies
            // convert to pennies or break out dollars and pennies
            // 
            // 23534235.23

        }
        // simple if/else - is it raining?
        boolean itIsRaining = true;
        boolean needUmbrella;

        boolean good = true; 

        if(itIsRaining) // (itIsRaining == true)     (!itIsRaining != true) (!itIsRaining == false)
        {
            needUmbrella = true;
        }
        else
        {
            needUmbrella = false; 
        }

        // add an if - do you care if you get wet?
        // if it's raining
        //        do you care? if not, never mind
        //        are you going out? if not, never mind
        //     if yes get umbrella
                

        // what about a nested one - can't find umbrella, get raincoat, or suck it up

        // separate if's - where one does not exclude/include the other - no dependencies. 

        // example of teacher - tests, labs, attendance - must have missed only 1 of each to pass - flag or if statement?


        System.out.println(welcomeMessage.replace("YO", "GO!"));
    }
}