import java.util.Random;

public class PrimitiveQuestion implements Question
{
    private Type datatype;
    private String variableName;
    private String value;
    private String answer;
    private String question;
    static Random randomizer = new Random();
    

    public PrimitiveQuestion()
    {
        datatype = Type.getRandomType(); // picks a random datatype from TYPES array
        variableName = getRandomItem(Data.VARIABLE_NAMES); // picks a random variable name from VARIABLE_NAMES array
        // picks a random value for the variable based on the datatype
        switch (datatype)
        {
            case STRING:
                value = getRandomItem(Data.STRING_VALUES);
                break;
            case CHAR:
                value = getRandomItem(Data.CHAR_VALUES);
                break;
            case INT:
                value = String.valueOf(randomizer.nextInt(1998) - 999);
                break;
            case DOUBLE:
                value = String.valueOf((randomizer.nextInt(198) - 99) 
                        + ((int)(randomizer.nextDouble() * 1000) / 1000.0));
                break;
            case BOOLEAN:
                value = String.valueOf(randomizer.nextBoolean());
                break;
        }
        if (randomizer.nextInt(100) <= 33) // 10% chance you will just declare the variable with no value
        {
            value = "";
        }
        else if (randomizer.nextInt(100) <= 33) // if there is a value, 10% chance of there being no type (means you assign a value to an existing variable)
        {
            datatype = null;
        }
        answer = generateAnswer();
        question = generateQuestion();
    }
    public String getRandomItem(String[] arrayOfStrings)
    {
        int indexOfRandomItem = randomizer.nextInt(arrayOfStrings.length);
        return arrayOfStrings[indexOfRandomItem];
    }
    public String generateAnswer()
    {
        // chooses the question/answer type based on whether or not a value or type was given
        if (value.isEmpty())
        {
            answer = datatype + " " + variableName;
        }
        else if (datatype == null)
        {
            answer =              variableName + " = " + value;
        }
        else
        {
            answer = datatype + " " + variableName + " = " + value;
        }
        answer += ";";

        return answer;
    }
    public String generateQuestion()
    {
        // declare a variable called x and assign it the value 3
        // You need a variable called name to hold the value Susan

        String verb = getRandomItem(Data.VERBS); // "Declare", "Define", "Create"
        String noun = getRandomItem(Data.NOUNS); // "variable", "identifier"
        String identifier = getRandomItem(Data.IDENTIFIER); // "called", "named", etc.
        String assign = getRandomItem(Data.ASSIGN); // "set it to", "give it the value", etc.

        String assignAndDefineText = verb + " " + noun + " " + identifier + " " + variableName + " and " + assign + " " + value;
        String assignText = "Given a variable " + identifier + " " + variableName + ", " + assign + " " + value;
        String defineText = verb + " " + noun + " " + identifier + " " + variableName + ", to hold a(n)" + (datatype == Type.INT ? "(n) " : " ")  + datatype;

        // chooses which question type to ask based on whether or not there is a type or value
        if (value.length() > 0)
        {
            if (datatype != null)
            {
                return assignAndDefineText;
            }
            else
            {
                return assignText;
            }
        }
        else
        {
            return defineText;
        }
    }
    public String[] formatAnswer(String answer)
    {
        if (answer.contains("=") && answer.contains(";"))
        {
            answer = answer.replace("="," ");
            answer = answer.replace(";","");
            return answer.split("\\s+");
        }
        else return new String[] {"Incorrect"};
    }
    public String getAnswer()
    {
        return answer;
    }
    public Type getDatatype()
    {
        return datatype;
    }
    public String toString()
    {
        return question;
    }
} // end of class