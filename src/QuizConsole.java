import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.time.*;

public class QuizConsole
{
    public static void startQuiz(Quiz quiz)
    {
        Instant startTime = Instant.now();
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
                System.out.println("   Your answer was: " + attempt);
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
        Instant endTime = Instant.now();
        Duration timeElapsed = Duration.between(startTime, endTime);
        System.out.println("You took " + timeElapsed.toMinutesPart() + " minutes and " + timeElapsed.toSecondsPart() +" seconds to complete the quiz");
        System.out.println("Your final score was: " + score + "/" + listOfQuestions.size());
        System.out.print("Press enter to go back to the menu...");
        scan.nextLine();
    }
    public static boolean compareAnswer(Question question, String answerAttempt)
    {
        String[] answerAttemptArray = question.formatAnswer(answerAttempt);
        String[] correctAnswerArray = question.formatAnswer(question.getAnswer());

        return Arrays.equals(answerAttemptArray, correctAnswerArray);
    }
}
