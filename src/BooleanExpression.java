import java.util.Random;

public class BooleanExpression
{
    private boolean isNegated = Math.random() > .66;
    private boolean boolean1;
    private boolean boolean2;
    private String expression;
    private String evaluation;
    private String compoundOperator;

    public BooleanExpression()
    {
        final String[] OPERATORS = {"==", "!=","||", "&&"};
        final Boolean[] BOOLEAN_VALUES = {true, false};
        boolean1 = Data.getRandomItem(BOOLEAN_VALUES);
        boolean2 = Data.getRandomItem(BOOLEAN_VALUES);
        compoundOperator = Data.getRandomItem(OPERATORS);
        expression = generateExpression();
        evaluation = generateEvaluation();
    }

    public String generateEvaluation()
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
    public String generateExpression()
    {
        if (isNegated)
        {
            return String.format("!(%s %s %s)", boolean1, compoundOperator, boolean2);
        }
        return String.format("%s %s %s", boolean1, compoundOperator, boolean2);
    }
    public String getExpression()
    {
        return expression;
    }
    public String toString()
    {
        return expression;
    }
    public String getEvaluation()
    {
       return evaluation;
    }
}
