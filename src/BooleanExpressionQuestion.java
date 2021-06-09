import java.util.Random;

public class BooleanExpressionQuestion extends Question
{
    private String question;
    private String answer;
    private BooleanExpression booleanExpression;

    public BooleanExpressionQuestion()
    {
        super();
        booleanExpression = new BooleanExpression();
        question = generateQuestion();
        answer = generateAnswer();
        super.setQuestion(question, answer);
    }
    public String generateAnswer()
    {
        return booleanExpression.getEvaluation();
    }
    public String generateQuestion()
    {
        return String.format("What does the following expression evaluate to?\n%s", booleanExpression);
    }
    public BooleanExpression getBooleanExpression()
    {
        return booleanExpression;
    }
    public String[] formatAnswer(String answer)
    {
        return new String[] {answer};
    }
}
