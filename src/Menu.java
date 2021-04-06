import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu
{
    private int numOfQuestions = 10;
    private int difficultyLevel;
    private boolean printAnswers = false;

    public void displayMenu(String pageID)
    {
        clearConsole();
    // STEP 1: check for special cases
        checkIfPageIsMethod(pageID);
        // If the page does not exist the user will be brought back to the screen they entered it from
        if (Data.PAGES.get(pageID) == null)
        {
            System.out.println("Invalid option");
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                System.out.println("Whoops");
            }
            displayMenu(pageID.substring(0, pageID.length() - 1));
        }
    // STEP 2: display page
        System.out.println(Data.PAGES.get(pageID));
    //STEP 3: get user input
        Scanner scan = new Scanner(System.in);
        System.out.print("Choose a menu option: ");
        String input = scan.nextLine().trim();
        // if the user selects 1 it will send them to the previous page
        if (input.equals("1"))
        {
            displayMenu(pageID.substring(0,pageID.length() - 1));
        }
        // otherwise the user will get sent to the page they selected
        else
        {
            displayMenu(pageID + input);
        }
    }

    private void checkIfPageIsMethod(String pageID) {
        // This case only occurs if the user inputs 1 on the home menu, which is the option to start the quiz
        if (pageID.isEmpty())
        {
            Quiz quiz = new Quiz(numOfQuestions);
            QuizConsole.startQuiz(quiz);
            displayMenu("1");
        }
        // This ID corresponds to the menu option to change the number of questions
        if (pageID.equals("132"))
        {
            promptForNumOfQuestions();
            displayMenu(pageID.substring(0, pageID.length() - 1));
        }
        if (pageID.equals("12"))
        {
            printQuizToFile(new Quiz(numOfQuestions));
            displayMenu("1");
        }
        if (pageID.equals("14"))
        {
            System.exit(0);
        }
        if (pageID.equals("134"))
        {
            printAnswers = !printAnswers;
            System.out.printf("An answer key will %sbe printed at the bottom of your quiz", printAnswers ? "" : "not ");
            try {Thread.sleep(1000);}
            catch (InterruptedException e) {}
            displayMenu(pageID.substring(0,pageID.length() - 1));
        }
    }
    public void printQuizToFile(Quiz quiz)
    {
        String filename = "quiz.txt";
        Quiz quizToPrint = new Quiz(numOfQuestions);
        ArrayList<Question> listOfQuestions = quiz.getListOfQuestions();
        try
        {
            File file = new File(filename);
            if (file.createNewFile())
            {
                System.out.println("File successfully created!");
                Thread.sleep(500);
            }
            else
            {
                int i = 1;
                while (!file.createNewFile())
                {
                    filename = "quiz" + i + ".txt";
                    file = new File(filename);
                    i++;
                }
                System.out.println("File successfully created!");
                Thread.sleep(500);


            }
            FileWriter fileWriter = new FileWriter(filename);
            System.out.print("Writing");
            for(int i = 0; i < 3; i++)
            {
                System.out.print(".");
                Thread.sleep(1000);
            }

            for (int i = 0; i < listOfQuestions.size(); i++)
            {
                Question question = listOfQuestions.get(i);
                fileWriter.write(String.format(("%d) %s\n\n"),i + 1, question));
            }
            if (printAnswers)
            {
                fileWriter.write("\nAnswer Key:\n");
                for (int i = 0; i < listOfQuestions.size(); i++)
                {
                    Question question = listOfQuestions.get(i);
                    fileWriter.write(String.format(("%d) %s\n"),i + 1, question.getAnswer()));
                }
            }
            fileWriter.close();
            System.out.println("Done!");
            Thread.sleep(1000);
        }
        catch (IOException | InterruptedException e)
        {
            System.out.println("Whoops looks like something went wrong!");
        }
    }

    public void promptForNumOfQuestions()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("How many questions would you like?: ");
        // A little messy looking but this makes sure that the error message
        // only prints after the user has input something not expected
        boolean isInvalid = false;
        do {
            if (isInvalid)
            {
                System.out.print("Please enter a positive number between 1 and 100: ");
            }
            while (!scan.hasNextInt()) {
                System.out.print("Please enter a positive number between 1 and 100: ");
                scan.next();
            }
            numOfQuestions = scan.nextInt();
            isInvalid = true;
        } while (numOfQuestions < 0 || numOfQuestions > 100);
    }
    public void clearConsole()
    {
        // Clears console (have not tested on macOS or Linux but the code
        // in the else block should just run the clear command in those cases
        try
        {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows"))
            {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (Exception e)
        {
            System.out.println("Whoops looks like something went wrong!");
        }
    }
}

