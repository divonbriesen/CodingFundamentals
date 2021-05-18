import java.util.Random;

public class BasicQuestion extends Question
{
    private Type datatype;
    private String variableName;
    private String value;
    private String answer;
    private String question;
    static Random randomizer = new Random();
    

    public BasicQuestion()
    {
        super();
        datatype = Data.getRandomItem(Type.values()); // picks a random datatype from TYPES array
        variableName = Data.getRandomItem(Data.BASIC_VARIABLE_NAMES); // picks a random variable name from VARIABLE_NAMES array

        switch (datatype) // picks a random value for the variable based on the datatype
        {
            case STRING:
                value = Data.getRandomItem(Data.STRING_VALUES);
                break;
            case CHAR:
                value = Data.getRandomItem(Data.CHAR_VALUES);
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
        if (randomizer.nextInt(100) <= 33) // 33% chance the question has no value (e.g. int x;)
        {
            value = "";
        }
        else if (randomizer.nextInt(100) <= 50) // overall 33% chance of there being no type (e.g. x = 1;)
        {
            datatype = null;
        }
        answer = generateAnswer();
        question = generateQuestion();
        super.setQuestion(question, answer);
    }
    public String generateAnswer()
    {
        String assignAndDefineAnswer = String.format("%s %s = %s;", datatype, variableName, value);
        String assignText = String.format("%s = %s;", variableName, value);
        String defineText = String.format("%s %s;", datatype, variableName);
        // chooses which answer type based on whether the value or datatype exist
        if (value.isEmpty())
        {
            answer = defineText;
        }
        else if (datatype == null)
        {
            answer = assignText;
        }
        else
        {
            answer = assignAndDefineAnswer;
        }
        return answer;
    }
    public String generateQuestion()
    {
        final String[] VERBS = {"Declare", "Define", "Create"};
        final String[] NOUNS = {"a variable", "an identifier"};
        final String[] IDENTIFIER = {"called", "named", "with the name","that's called", "that's named", "that has the name"};
        final String[] ASSIGN = {"set it to", "assign it the value", "give it the value", "set it equal to", "initialize it to"};

        String verb = Data.getRandomItem(VERBS);
        String noun = Data.getRandomItem(NOUNS);
        String identifier = Data.getRandomItem(IDENTIFIER);
        String assign = Data.getRandomItem(ASSIGN);

        String assignAndDefineText = verb + " " + noun + " " + identifier + " " + variableName + " and " + assign + " " + value;
        String assignText = "Given a variable " + identifier + " " + variableName + ", " + assign + " " + value;
        String defineText = verb + " " + noun + " " + identifier + " " + variableName + ", to hold a" + (datatype == Type.INT ? "n " : " ")  + datatype;

        // chooses which question type to ask based on whether or not there is a type or value
        String question;
        if (value.isEmpty())
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
    public String[] formatAnswer(String answer)
    {
        // adds spaces around all important characters and returns the answer split into an array on spaces
        answer = answer.strip();
        String[] keySymbols = {"=", ";"};
        for (String symbol : keySymbols)
        {
            if (answer.contains(symbol))
            {
                String replacement = " " + symbol + " ";
                answer = answer.replace(symbol,replacement);
            }
        }
        return answer.split("\\s+");
    }
} // end of class