import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.time.*;

public class QuizConsole
{
    public static void startQuiz(Quiz quiz)
    {
        Instant startTime = Instant.now(); // start timer
        ArrayList<Question> listOfQuestions = quiz.getListOfQuestions();
        Scanner scan = new Scanner(System.in);
        int score = 0;
        // print out questions in order and compare what the user inputted to the answer
        for (int i = 0; i < listOfQuestions.size(); i++)
        {
            Question question = listOfQuestions.get(i);
            System.out.printf(("%d) %s: "),i + 1, question);

            String attempt = scan.nextLine().trim();
            String message;
            if (isAnswerCorrect(question, attempt))
            {
                message = "Good job!";
                score++;
            }
            else
            {
                message = "Better luck next time!";
            }
            String answerResultText = String.format("   Your answer was: %s\nCorrect answer was: %s\t\t%s\n",
                                                    attempt, question.getAnswer(),message);
            System.out.println(answerResultText);
        }
        Instant endTime = Instant.now();
        Duration timeElapsed = Duration.between(startTime, endTime); // end timer and calculate time taken
        boolean areMinutesPlural = timeElapsed.toMinutesPart() != 1;
        boolean areSecondsPlural = timeElapsed.toSecondsPart() != 1;
        String quizResults = String.format("You took %s minute%s and %s second%s to complete the quiz\nYour final score was: " +
                                           "%s/%s\nPress enter to go back to the menu...", timeElapsed.toMinutesPart(), areMinutesPlural ? "s" : "",
                                            timeElapsed.toSecondsPart(), areSecondsPlural ? "s" : "", score, listOfQuestions.size());
        System.out.print(quizResults);
        scan.nextLine();
    }
    public static boolean isAnswerCorrect(Question question, String answerAttempt)
    {
        String[] answerAttemptArray = question.formatAnswer(answerAttempt);
        String[] correctAnswerArray = question.formatAnswer(question.getAnswer());

        return Arrays.equals(answerAttemptArray, correctAnswerArray);
    }
}
