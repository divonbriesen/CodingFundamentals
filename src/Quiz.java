import java.util.ArrayList;

public class Quiz
{
    private ArrayList<Question> listOfQuestions;

    public Quiz(int numOfQuestions)
    {
        listOfQuestions = new ArrayList<>();
        generateQuestionList(numOfQuestions);
    }
    public void generateQuestionList(int numOfQuestions)
    {
        for (int i = 0; i < numOfQuestions; i++)
        {
            listOfQuestions.add(new Question());
        }
    }
    public ArrayList<Question> getListOfQuestions()
    {
        return listOfQuestions;
    }
}
