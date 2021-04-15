import java.lang.reflect.Array;

public class MagicSquareChecker
{
    int[][] theSquare;

    boolean itIsMagic;
    
    public MagicSquareChecker(int[] listOfNumbers)
    {
        if (checkForSquareRoot(listOfNumbers.length))
        {
            theSquare = listOfNumbers
        }
        else itIsMagic = false; 
    }

    public void convertToSquare(int[] _listOfNumbers)
    {
       int squareRoot = (int)Math.sqrt(_listOfNumbers.length);
       int lengthOfSquare = squareRoot;
       //need to convert to 2D Array
       theSquare = new int[lengthOfSquare][lengthOfSquare];

       for(int i = 0; i < lengthOfSquare; i++ )
       {
            theSquare[i][i] = _listOfNumbers[i];
       }
    }

    public boolean checkForSquareRoot(int _count)
    {
        double squareRoot = Math.sqrt(_count);

        if (squareRoot % 1 == 0) // square root is evenly divisible by a whole number
        { 
            System.out.print("Square root is even: " + squareRoot);
            return true;
        } 
        else  
        {
            return false;
        }
    }

    public boolean checkHorizontalSums(int[] row,  int sum)
    {

    }

    public boolean checkVerticalSums(int)
    {

    }
}