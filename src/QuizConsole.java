import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class QuizConsole
{
    public static void startQuiz(Quiz quiz)
    {
        ArrayList<Question> listOfQuestions = quiz.getListOfQuestions();
        Scanner scan = new Scanner(System.in);
        int score = 0;
        // print out questions in order and compare what the user inputted to the answer
        for (int i = 0; i < listOfQuestions.size(); i++)
        {
            Question question = listOfQuestions.get(i);
            System.out.printf(("%d) %s: "),i + 1, question);

            String attempt = scan.nextLine();

            if (compareAnswer(question, attempt))
            {
                System.out.println("Your answer was:    " + attempt);
                System.out.print(  "Correct answer was: " + question.getAnswer());
                System.out.println("        Good job!\n");
                score++;
            }
            else {
                System.out.println("   Your answer was: " + attempt);
                System.out.print("Correct answer was: " + question.getAnswer());
                System.out.println("        Better luck next time!\n");
            }
        }
        System.out.println("Your final score was: " + score + "/" + listOfQuestions.size());
        System.out.print("Press enter to go back to the menu...");
        scan.nextLine();
    }
    public static boolean compareAnswer(Question question, String answerAttempt)
    {
        String[] answerAttemptArray = formatAnswer(question, answerAttempt);
        String[] correctAnswerArray = formatAnswer(question, question.getAnswer());

        return Arrays.equals(answerAttemptArray, correctAnswerArray);
    }
    public static String[] formatAnswer(Question question, String answer)
    {
        // if the question doesn't require a type then the answer will be compared with all spaces removed
        // if the question does require a type, then the answer will be compared  in the format of {type, restOfAnswer}
        // to ensure that there is at least one space between the type and the variable name
        String[] answerSplitAtSpaces = answer.split(" ");
        StringBuilder answerWithNoSpaces = new StringBuilder();
        for (int i = 1; i < answerSplitAtSpaces.length; i++)
        {
            answerWithNoSpaces.append(answerSplitAtSpaces[i]);
        }

        if (question.getType().isEmpty())
        {
            return new String[] {answerSplitAtSpaces[0] + answerWithNoSpaces};
        }
        return new String[] {answerSplitAtSpaces[0], answerWithNoSpaces.toString()};
    }
}
