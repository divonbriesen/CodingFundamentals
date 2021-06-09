//import java.util.Random;
//
//public class CompoundExpressionQuestion extends Question
//{
//    private String question;
//    private String answer;
//    BooleanExpressionQuestion expressionQuestion1;
//    BooleanExpressionQuestion expressionQuestion2;
//    private boolean expression1Value;
//    private boolean expression2Value;
//    private boolean isNegated;
//    private String expression1;
//    private String expression2;
//    private String compoundOperator;
//
//    public CompoundExpressionQuestion()
//    {
//        super();
//        final String[] COMPOUND_OPERATORS = {"||", "&&"};
//        compoundOperator = Data.getRandomItem(COMPOUND_OPERATORS);
//        expressionQuestion1 = new BooleanExpressionQuestion();
//        expressionQuestion2 = new BooleanExpressionQuestion();
//        expression1 = expressionQuestion1.getExpression();
//        expression2 = expressionQuestion2.getExpression();
//        expression1Value = Boolean.parseBoolean(expressionQuestion1.getAnswer());
//        expression2Value = Boolean.parseBoolean(expressionQuestion2.getAnswer());
//        question = generateQuestion();
//        answer = generateAnswer();
//        super.setQuestion(question, answer);
//    }
//
//    public String generateAnswer()
//    {
//        boolean answerValue;
//        switch (compoundOperator)
//        {
//            case "||":
//                answerValue = expression1Value || expression2Value;
//                break;
//            case "&&":
//                answerValue = expression1Value && expression2Value;
//                break;
//            default:
//                return "Error";
//        }
//        return "" + (isNegated ? !answerValue : answerValue);
//    }
//    public String generateQuestion()
//    {
//        if (isNegated)
//        {
//            return String.format("What does the following expression evaluate to?\n!((%s) %s (%s))", expression1, compoundOperator, expression2);
//        }
//        return String.format("What does the following expression evaluate to?\n(%s) %s (%s)", expression1, compoundOperator, expression2);
//    }
//
//    public String[] formatAnswer(String answer)
//    {
//        return new String[] {answer};
//    }
//}
