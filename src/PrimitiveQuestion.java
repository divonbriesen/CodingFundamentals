import java.util.Random;

public class PrimitiveQuestion implements Question
{
    private PrimitiveType datatype;
    private String variableName;
    private String value;
    private String answer;
    private String question;
    static Random randomizer = new Random();
    
    public enum PrimitiveType
    {
        STRING("String"),
        INT("int"),
        BOOLEAN("boolean"),
        DOUBLE("double"),
        CHAR("char");

        private String stringValue;
        private PrimitiveType(String stringValue)
        {
            this.stringValue = stringValue;
        }
        public static PrimitiveType getRandomPrimitiveType()
        {
            PrimitiveType[] primitiveTypes = PrimitiveType.values();
            int primitiveTypeIndex = randomizer.nextInt(primitiveTypes.length);
            return primitiveTypes[primitiveTypeIndex];
            
        }
        public String toString()
        {
            return stringValue;
        }
    }
    public PrimitiveQuestion()
    {
        datatype = PrimitiveType.getRandomPrimitiveType(); // picks a random datatype from TYPES array
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
    public String getRandomItem(String[] _stringArray)
    {
        int indexOfRandomItem = randomizer.nextInt(_stringArray.length);
        return _stringArray[indexOfRandomItem];
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
        String defineText = verb + " " + noun + " " + identifier + " " + variableName + ", to hold a(n) " + datatype;

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
        // if the question doesn't require a type then the answer will be compared with all spaces removed
        // if the question does require a type, then the answer will be compared  in the format of {type, restOfAnswer}
        // to ensure that there is at least one space between the type and the variable name
        String[] answerSplitAtSpaces = answer.split(" ");
        StringBuilder answerWithNoSpaces = new StringBuilder();
        for (int i = 1; i < answerSplitAtSpaces.length; i++)
        {
            answerWithNoSpaces.append(answerSplitAtSpaces[i]);
        }
        if (getDatatype() == null)
        {
            return new String[] {answerSplitAtSpaces[0] + answerWithNoSpaces};
        }
        return new String[] {answerSplitAtSpaces[0], answerWithNoSpaces.toString()};
    }
    public String getAnswer()
    {
        return answer;
    }
    public PrimitiveType getDatatype()
    {
        return datatype;
    }
    public String toString()
    {
        return question;
    }
} // end of class