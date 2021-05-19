import java.util.Random;

public class BooleanExpressionQuestion extends Question
{
    private String question;
    private String answer;
    private boolean isNegated = Math.random() > .66;
    private boolean boolean1;
    private boolean boolean2;
    private String expression;
    private String compoundOperator;

    public BooleanExpressionQuestion()
    {
        super();
        final String[] OPERATORS = {"==", "!=","||", "&&"};
        final Boolean[] BOOLEAN_VALUES = {true, false};
        boolean1 = Data.getRandomItem(BOOLEAN_VALUES);
        boolean2 = Data.getRandomItem(BOOLEAN_VALUES);
        compoundOperator = Data.getRandomItem(OPERATORS);


        question = generateQuestion();
        expression = question.split("[\\r\\n]+")[1];
        answer = generateAnswer();
        super.setQuestion(question, answer);

    }

    public String generateAnswer()
    {
        boolean answerValue;
        switch (compoundOperator)
        {
            case "==":
                answerValue = boolean1 == boolean2;
                break;
            case "!=":
                answerValue = boolean1 != boolean2;
                break;
            case "||":
                answerValue = boolean1 || boolean2;
                break;
            case "&&":
                answerValue = boolean1 && boolean2;
                break;
            default:
                return "Error";
        }
        return "" + (isNegated ? !answerValue : answerValue);
    }
    public String generateQuestion()
    {
        if (isNegated)
        {
            return String.format("What does the following expression evaluate to?\n!(%s %s %s)", boolean1, compoundOperator, boolean2);
        }
        return String.format("What does the following expression evaluate to?\n%s %s %s", boolean1, compoundOperator, boolean2);
    }
    public String getExpression()
    {
        return expression;
    }
    public String[] formatAnswer(String answer)
    {
        return new String[] {answer};
    }
}
