import java.util.Random;
import java.util.ArrayList;
public class ArrayQuestion implements Question
{
    private ArrayType datatype;
    private String variableName;
    private String[] values;
    private int numberOfElements;
    private String answer;
    private String question;
    static Random randomizer = new Random();
    public enum ArrayType
    {
        STRING("String[]"),
        INT("int[]"),
        BOOLEAN("boolean[]"),
        DOUBLE("double[]"),
        CHAR("char[]");

        private String stringValue;
        private ArrayType(String stringValue)
        {
            this.stringValue = stringValue;
        }
        public static ArrayType getRandomArrayType()
        {
            ArrayType[] arrayTypes = ArrayType.values();
            int arrayTypeIndex = randomizer.nextInt(arrayTypes.length);
            return arrayTypes[arrayTypeIndex];
            
        }
        public String toString()
        {
            return stringValue;
        }
    }
    public ArrayQuestion()
    {
        numberOfElements = randomizer.nextInt(5);
        datatype = ArrayType.getRandomArrayType(); // picks a random datatype from TYPES array
        variableName = getRandomItem(Data.VARIABLE_NAMES); // picks a random variable name from VARIABLE_NAMES array
      // picks a random value for the variable based on the datatype
        switch (datatype)
        {
            case STRING:
                values = getRandomElements(Data.STRING_VALUES);
                break;
            case CHAR:
                values = getRandomElements(Data.CHAR_VALUES);
                break;
            case INT:
                values = generateRandomIntArray();
                break;
            case DOUBLE:
                values = generateRandomDoubleArray();
                break;
            case BOOLEAN:
                values = generateRandomBooleanArray();
                break;
        }
        if (randomizer.nextInt(100) <= 33) // 10% chance you will just declare the variable with no value
        {
            values = null;
        }
        else if (randomizer.nextInt(100) <= 33) // if there is a value, 10% chance of there being no type (means you assign a value to an existing variable)
        {
            datatype = null;
        }
        answer = generateAnswer();
        question = generateQuestion();
   }
   public String generateAnswer()
    {
        // chooses the question/answer type based on whether or not a value or type was given
        if (values == null)
        {
            answer = datatype + " " + variableName;
        }
        else if (datatype == null)
        {
            answer = variableName + " = {" + values + "}";
        }
        else
        {
            answer = datatype + " " + variableName + " = " + values;
        }
        answer += ";";

        return answer;
    }
    public String[] getRandomElements(String[] arrayOfStrings)
    {
        String[] randomElements = new String[numberOfElements];
        for (int i = 0; i < numberOfElements; i++)
        {
            randomElements[i] = getRandomItem(arrayOfStrings);
        }
        return randomElements;
     }

    public String getRandomItem(String[] arrayOfStrings)
    {
        int indexOfRandomItem = randomizer.nextInt(arrayOfStrings.length);
        return arrayOfStrings[indexOfRandomItem];
    }
    public String[] generateRandomIntArray()
    {
        String[] randomArray = new String[numberOfElements];
        for (int i = 0; i < numberOfElements; i++)
        {
            randomArray[i] = String.valueOf(randomizer.nextInt(198) - 99);
        }
        return randomArray;
    }
    public String[] generateRandomBooleanArray()
    {
        String[] randomArray = new String[numberOfElements];
        for (int i = 0; i < numberOfElements; i++)
        {
            randomArray[i] = String.valueOf(randomizer.nextBoolean());
        }
        return randomArray;
    }
    public String[] generateRandomDoubleArray()
    {
        String[] randomArray = new String[numberOfElements];
        for (int i = 0; i < numberOfElements; i++)
        {
            randomArray[i] = String.valueOf((randomizer.nextInt(198) - 99) 
                           + ((int)(randomizer.nextDouble() * 1000) / 1000.0));
        }
        return randomArray;
    }
    public String getAnswer()
    {
        return answer;
    }
    public String generateQuestion()
    {
        return "";
    }
    public String[] formatAnswer(String s)
    {
        return new String[3];
    }
    public String toString()
    {
       return answer;
    }
}