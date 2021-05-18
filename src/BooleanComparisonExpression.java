import java.util.Random;

public class BooleanComparisonExpression extends Question
{

    private String question;
    private String answer;
    int value1;
    int value2;
    private String comparison;
    private Random randomizer = new Random();

    public BooleanComparisonExpression()
    {
        super();
        final String[] COMPARISON_OPERATORS = {"==", "!=", "<", ">", "<=", ">="};
        value1 = randomizer.nextInt(500);
        value2 = value1 + (randomizer.nextInt(20) - 10);
        comparison = Data.getRandomItem(COMPARISON_OPERATORS);

        question = generateQuestion();
        answer = generateAnswer();
        super.setQuestion(question, answer);

    }

    public String generateAnswer()
    {
        boolean answerValue;
        switch (comparison)
        {
            case "==":
                answerValue = value1 == value2;
                break;
            case "!=":
                answerValue = value1 != value2;
                break;
            case "<":
                answerValue = value1 < value2;
                break;
            case ">":
                answerValue = value1 > value2;
                break;
            case "<=":
                answerValue = value1 <= value2;
                break;
            case ">=":
                answerValue = value1 >= value2;
                break;
            default:
               return "Error";
        }
        return "" + answerValue;
    }
    public String generateQuestion()
    {
        String question = String.format("What does the following expression evaluate to?\n%s %s %s", value1, comparison, value2);
        return question;
    }

    public String[] formatAnswer(String answer)
    {
        return new String[] {answer};
    }
}

