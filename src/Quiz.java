import java.util.ArrayList;
import java.util.Random;
public class Quiz
{
    private ArrayList<Question> listOfQuestions;
    private enum QuestionType
    {
        PRIMITIVE,
        ARRAY;

        public static QuestionType getRandomQuestionType()
        {
            Random randomizer = new Random();
            ArrayList<QuestionType> questionTypes = new ArrayList<>();
            if (Menu.isBasicQuestionsIncluded())
            {
                questionTypes.add(PRIMITIVE);
            }
            if (Menu.isArrayQuestionsIncluded())
            {
                questionTypes.add(ARRAY);
            }
            int questionTypeIndex = randomizer.nextInt(questionTypes.size());
            return questionTypes.get(questionTypeIndex);

        }
    }
    public Quiz(int numOfQuestions)
    {
        listOfQuestions = new ArrayList<>();
        generateQuestionList(numOfQuestions);
    }
    public void generateQuestionList(int numOfQuestions)
    {
        Question question;
        QuestionType questionType;
        for (int i = 0; i < numOfQuestions; i++)
        {
            questionType = QuestionType.getRandomQuestionType();
            switch (questionType)
            {
                case PRIMITIVE:
                    question = new PrimitiveQuestion();
                    break;
                case ARRAY:
                    question = new ArrayQuestion();
                    break;
                default:
                    question = new PrimitiveQuestion();
                    System.out.println("Error");
                    break;
            }
            listOfQuestions.add(question);
        }
    }
    public ArrayList<Question> getListOfQuestions()
    {
        return listOfQuestions;
    }
}
