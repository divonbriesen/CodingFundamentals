public class MagicSquareChecker
{
    int[][] theSquare; 
    boolean itIsMagic;
    
    public MagicSquareChecker(int[] listOfNumbers)
    {
        if (checkForCube(listOfNumbers.length))
        {
            theSquare = listOfNumbers
        }
        else itIsMagic = false; 
    }

    public void convertToSquare()
    {
        double squareRoot = Math.sqrt(int _count);

        if (squareRoot % 1 == 0) // square root is evenly divisible by a whole number
        { 
            System.out.print("Square root is even: " + squareRoot);
            return true;
        } else  return false;
    }
    public boolean checkForCube(int count)
    {

    }

    public boolean checkHorizontalSums(int[] row,  int sum)
    {

    }

    public boolean checkVerticalSums(int)
    {

    }
}