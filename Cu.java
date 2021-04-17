public class Cu
{
    public static void main(String[] args)
    {
        int[] list = {3, 6, 0, -2, -2, -2, 4, 6, 7};
        System.out.println(countUniqueIntegers(list));
    }

    public static int countUniqueIntegers(int[] arr)
    {    
        // Initialize int "counter" with value 0
        int num_unique = 0;
        // TO DO: Add logic to count unique values
        for (int i = 0; i < arr.length; i++)
        { 
            int j = 0; 

            for (j = 0; j < i; j++)
            { 
                if (arr[i] == arr[j])
                { 
                    break; // where does this go?
                }
            }

            if (i == j)
            {
                num_unique++; 
            }
        }
        return num_unique;
    }
}