public class Vehicle
{
    public static void main(String[] commandLineArguments)
    {

        String[] newList = new String[commandLineArguments.length];

        for( int counter = 0; counter < commandLineArguments.length ; counter++ )
        {
            String anArgument = commandLineArguments[counter];
            System.out.print(" || " + (counter + 1) + " " + anArgument);
        }

        System.out.println("\n=========================\n");
        
        for(int counter = commandLineArguments.length -1; counter >= 0; counter--)
        {
            String anArgument = commandLineArguments[counter];
            System.out.print(" || " + (counter + 1) + " " + anArgument);
            newList[counter] = anArgument;
            // 10 0, 9, 1, 8-2, 7-3, 6-4
        }

        System.out.println("\n=========================\n");
        
        for( int counter = 0; counter < commandLineArguments.length ; counter++ )
        {
            String anArgument = newList[counter];
            System.out.print(" || " + (counter + 1) + " " + anArgument);
        }
/*
        System.out.println("=========================");

        for(String anArgument : commandLineArguments)
        {
            System.out.println(anArgument);
        }
*/
    }
}

// devops - infrastructure
// syntax
// logic
// java Vehicle Tom Dick Harry Sally Ayesha