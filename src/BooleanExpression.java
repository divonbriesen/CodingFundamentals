import java.util.Random;

public class BooleanExpression extends Question
{
    private String question;
    private String answer;
    boolean boolean1;
    boolean boolean2;
    private String compoundOperator;
    private Random randomizer = new Random();

    public BooleanExpression()
    {
        super();
        final String[] COMPOUND_OPERATORS = {"||", "&&","!"};
        final Boolean[] BOOLEAN_VALUES = {true, false};
        boolean1 = Data.getRandomItem(BOOLEAN_VALUES);
        boolean2 = Data.getRandomItem(BOOLEAN_VALUES);
        compoundOperator = Data.getRandomItem(COMPOUND_OPERATORS);

        question = generateQuestion();
        answer = generateAnswer();
        super.setQuestion(question, answer);

    }

    public String generateAnswer()
    {
        boolean answerValue;
        switch (compoundOperator)
        {
            case "||":
                answerValue = boolean1 || boolean2;
                break;
            case "&&":
                answerValue = boolean1 && boolean2;
                break;
            case "!":
                answerValue = !boolean1;
                break;
            default:
                return "Error";
        }
        return "" + answerValue;
    }
    public String generateQuestion()
    {
        if (compoundOperator.equals("!"))
        {
            return "!" + boolean1;
        }
        String question = String.format("%s %s %s", boolean1, compoundOperator, boolean2);
        return question;
    }

    public String[] formatAnswer(String answer)
    {
        return new String[] {answer};
    }
}
