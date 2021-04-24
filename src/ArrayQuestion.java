import java.util.Random;

public class ArrayQuestion implements Question
{
    private Type datatype;
    private String variableName;
    private String[] values;
    private int numberOfElements;
    private String answer;
    private String question;
    static Random randomizer = new Random();

    public ArrayQuestion()
    {
        numberOfElements = randomizer.nextInt(4) + 1; // picks random num of elements from 1-5
        datatype = Type.getRandomType(); // picks a random datatype from Type enum
        variableName = getRandomItem(Data.ARRAY_VARIABLE_NAMES); // picks a random variable name from VARIABLE_NAMES array

        switch (datatype)  // picks a random value for the variable based on the datatype
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
        if (randomizer.nextInt(100) <= 33) // 33% chance there will be no values (e.g. int[] x = new int[13];)
        {
            values = new String[0];
            numberOfElements = randomizer.nextInt(24) + 1;
        }
        else if (randomizer.nextInt(100) <= 50) // 33% chance there will be no datatype (e.g. x[3] = 'a';)
        {
            datatype = null;
            // converts values to an array with one element which will be the value to assign (the 'a' in the above comment)
            String temp = values[0];
            values = new String[1];
            values[0] = temp;
        }
        answer = generateAnswer();
        question = generateQuestion();
   }
   public String generateAnswer()
    {
        // chooses the question/answer type based on whether or not a value or type was given
        if (values.length == 0)
        {
            answer = String.format("%s[] %s = new %s[%d];",datatype, variableName, datatype, numberOfElements);
        }
        else if (datatype == null)
        {
            answer = String.format("%s[%d] = %s;",variableName, numberOfElements, arrayValuesToString(values));
        }
        else
        {
            answer = String.format("%s[] %s = {%s};",datatype,variableName, arrayValuesToString(values));
        }
        return answer;
    }
    public String generateQuestion()
    {
        // declare a variable called x and assign it the value 3
        // You need a variable called name to hold the value Susan
        String ordinalWord = Data.ORDINAL_WORDS[numberOfElements];
        String ordinalSuffix = ordinalWord.substring(ordinalWord.length() - 2);
        String ordinalNumeral = numberOfElements + 1 + ordinalSuffix;
        final String[] VERBS = {"Declare", "Define", "Create"};
        final String[] IDENTIFIER = {"called", "named", "that's named", "with the name"};
        final String[] ASSIGN = {"assign it the value", "give it the value", "initialize it with the value"};

        final String[] NUMBER = {String.format("the element at index %d", numberOfElements),
                                 String.format("the %s element", Math.random() > .5 ? ordinalWord : ordinalNumeral)};
        String verb = getRandomItem(VERBS); // "Declare", "Define", "Create"
        String identifier = getRandomItem(IDENTIFIER); // "called", "named", etc.
        String assign = getRandomItem(ASSIGN); // "set it to", "give it the value", etc.
        String number = getRandomItem(NUMBER);
        boolean plural = numberOfElements > 1;
        String assignAndDefineText = verb + " an array " + identifier + " " + variableName + " and " + assign +
                                            (plural ? "s ": " ") + arrayValuesToPlainEnglish(values);
        String assignText = "Given an array " + identifier + " " + variableName + ", " + assign.split(" ")[0]
                            + " " + number + " the value " + arrayValuesToPlainEnglish(values);
        String defineText = verb + " an array " + identifier + " " + variableName + ", to hold " + numberOfElements
                            + " " + datatype + (plural ? "s ": "");
        // chooses which question type to ask based on whether or not there is a type or value
        String question;
        if (values.length == 0)
        {
            question = defineText;
        }
        else if (datatype == null)
        {
            question = assignText;
        }
        else
        {
            question = assignAndDefineText;
        }
        return question;
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
    public String[] formatAnswer(String answer)
    {
        // adds spaces around all important characters and returns the answer split into an array on spaces
        answer = answer.strip();
        String[] keySymbols = {"=", ";", "{", "}", "[", "]",","};
        for (String symbol : keySymbols)
        {
            if (answer.contains(symbol))
            {
                String replacement = String.format(" %s ", symbol);
                answer = answer.replace(symbol,replacement);
            }
        }
        return answer.split("\\s+");
    }
    public String arrayValuesToPlainEnglish(String[] stringArray)
    {
        // two special cases
        if (stringArray.length == 0) return "";
        if (stringArray.length == 2) return String.format("%s and %s", stringArray[0], stringArray[1]);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringArray.length; i++)
        {
            String string = stringArray[i];

            if (i == stringArray.length - 2)
            {
                stringBuilder.append(String.format("%s, and ", string)); // adds "and" between last two elements
            }
            else
            {
                stringBuilder.append(String.format("%s, ", string));
            }
        }
        String result = stringBuilder.toString();
        result = result.substring(0, result.length() - 2); // gets rid of trailing comma and space
        return result;
    }
    public String arrayValuesToString(String[] stringArray) // same as above method but without "and"s
    {
        if (stringArray.length == 0) return "";
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : stringArray)
        {
            stringBuilder.append(String.format("%s, ", string));
        }
        String result = stringBuilder.toString();
        result = result.substring(0, result.length() - 2);
        return result;
    }
    public String getAnswer()
    {
        return answer;
    }
    public String toString()
    {
       return question;
    }
}