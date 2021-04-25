import java.util.ArrayList;
import java.util.Random;
public class Quiz
{
    private ArrayList<Question> listOfQuestions;
    private enum QuestionType
    {
        BASIC,
        ARRAY,
        BOOLEAN;

        public static QuestionType getRandomQuestionType()
        {
            // returns a random QuestionType but checks first to see which types are enabled
            Random randomizer = new Random();
            ArrayList<QuestionType> questionTypes = new ArrayList<>();

            if (Menu.isBasicQuestionsIncluded()) questionTypes.add(BASIC);
            if (Menu.isArrayQuestionsIncluded()) questionTypes.add(ARRAY);
            questionTypes.add(BOOLEAN);

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
                case BASIC:
                    question = new BasicQuestion();
                    break;
                case ARRAY:
                    question = new ArrayQuestion();
                    break;
                case BOOLEAN:
                    question = new BooleanQuestion();
                    break;
                default:
                    question = new BasicQuestion();
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
