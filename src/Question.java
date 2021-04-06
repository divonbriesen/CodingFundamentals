import java.util.Random;

public class Question
{
    private String type;
    private String variableName;
    private String value;
    private String answer;
    private String question;
    private String tags;
    Random randomizer = new Random();

    public Question()
    {
        type = getRandomItem(Data.TYPES); // picks a random datatype from TYPES array
        variableName = getRandomItem(Data.VARIABLE_NAMES); // picks a random variable name from VARIABLE_NAMES array
        // picks a random value for the variable based on the datatype
        if (type.equals("String"))
            value = getRandomItem(Data.STRING_VALUES);
        if (type.equals("char"))
            value = getRandomItem(Data.CHAR_VALUES);
        if (type.equals("int"))
            // this gets negative ints rom -999-999
            value = String.valueOf(randomizer.nextInt(1998) - 999);
        if (type.equals("double"))
            // this looks weird but all it does is round to three decimal places
            value = String.valueOf((randomizer.nextInt(198) - 99) + ((int)(randomizer.nextDouble() * 1000) / 1000.0));
        if (type.equals("boolean"))
            value = String.valueOf(randomizer.nextBoolean());

        if (randomizer.nextInt(100) <= 10) // 10% chance you will just declare the variable with no value
        {
            value = "";
        }
        else if (randomizer.nextInt(100) <= 10) // if there is a value, 10% chance of there being no type (means you assign a value to an existing variable)
        {
            type = "";
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
            answer = type + " " + variableName;
        }
        else if (type.isEmpty())
        {
            answer =              variableName + " = " + value;
        }
        else
        {
            answer = type + " " + variableName + " = " + value;
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
        String defineText = verb + " " + noun + ", " + identifier + " " + variableName + ", to hold a(n) " + type;

        // chooses which question type to ask based on whether or not there is a type or value
        if (value.length() > 0)
        {
            if (type.length() > 0)
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
    public String getAnswer()
    {
        return answer;
    }
    public String getType()
    {
        return type;
    }
    public String toString()
    {
        return question;
    }
/*
    public boolean compareAnswer(String answerAttempt)
    {
       String[] answerAttemptArray = formatAnswer(answerAttempt);
       String[] correctAnswerArray = formatAnswer(answer);

       return Arrays.equals(answerAttemptArray, correctAnswerArray);
    }
    public String[] formatAnswer(String answer)
    {
        // if the question doesn't require a type then the answer will be compared with all spaces removed
        // if the question does require a type, then the answer will be compared  in the format of {type, restOfAnswer}
        // to ensure that there is at least one space between the type and the variable name
        String[] answerSplitAtSpaces = answer.split(" ");

        String answerWithNoSpaces = "";
        for (int i = 1; i < answerSplitAtSpaces.length; i++)
        {
            answerWithNoSpaces += answerSplitAtSpaces[i];
        }

        if (type.isEmpty())
        {
            return new String[] {answerSplitAtSpaces[0] + answerWithNoSpaces};
        }
        return new String[] {answerSplitAtSpaces[0], answerWithNoSpaces};
    }
*/

} // end of class