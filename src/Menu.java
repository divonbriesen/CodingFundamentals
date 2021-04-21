import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu
{
    private int numOfQuestions = 10;
    private boolean printAnswers = false;
    private static boolean basicQuestionsIncluded = true;
    private static boolean arrayQuestionsIncluded = true;
    public void displayMenu(String pageID)
    {
        clearConsole();
    // STEP 1: check for special cases
        checkIfPageIsMethod(pageID);
        // If the page doesn't exist the user will be brought back to the screen they entered it from
        if (Data.PAGES.get(pageID) == null)
        {
            System.out.println("Invalid option");
            sleep(1000);
            previousPage(pageID);
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
            previousPage(pageID);
        }
        // otherwise the user will get sent to the page they selected
        else
        {
            displayMenu(pageID + input);
        }
    }
    private void checkIfPageIsMethod(String pageID)
    {
        // This case only occurs if the user inputs 1 on the home menu, which is the option to start the quiz
        if (pageID.isEmpty())
        {
            Quiz quiz = new Quiz(numOfQuestions);
            QuizConsole.startQuiz(quiz);
            displayMenu("1");
        }
        // This ID corresponds to the menu option to change the number of questions
        if (pageID.equals("142"))
        {
            promptForNumOfQuestions();
            previousPage(pageID);
        }
        if (pageID.equals("12"))
        {
            printQuizToFile();
            displayMenu("1");
        }
        if (pageID.equals("15"))
        {
            System.exit(0);
        }
        if (pageID.equals("144"))
        {
            printAnswerKey();
            previousPage(pageID);
        }
        if (pageID.equals("1452"))
        {
            toggleBasicQuestions();
            previousPage(pageID);
        }
        if (pageID.equals("1453"))
        {
            toggleArrayQuestions();
            previousPage(pageID);
        }
        if (pageID.equals("13"))
        {
            printQuestionsToScreen();
            previousPage(pageID);
        }
    }

    private void toggleArrayQuestions() {
        if (!arrayQuestionsIncluded || basicQuestionsIncluded)
        {
            arrayQuestionsIncluded = !arrayQuestionsIncluded;
            System.out.printf("Array questions will %sbe included in your quiz", arrayQuestionsIncluded ? "" : "not ");
        }
        else
        {
            System.out.println("You must included at least one type of question in your quiz");
        }

        sleep(2000);
    }

    private void toggleBasicQuestions() {
        if (arrayQuestionsIncluded || !basicQuestionsIncluded)
        {
            basicQuestionsIncluded = !basicQuestionsIncluded;
            System.out.printf("Basic questions will %sbe included in your quiz", basicQuestionsIncluded ? "" : "not ");
        }
        else
        {
            System.out.println("You must included at least one type of questions in your quiz");
        }
        sleep(2000);
    }

    private void printAnswerKey()
    {
        printAnswers = !printAnswers;
        System.out.printf("An answer key will %sbe printed at the bottom of your quiz", printAnswers ? "" : "not ");
        sleep(1000);
    }

    private void printQuestionsToScreen()
    {
        Quiz quiz = new Quiz(numOfQuestions);
        ArrayList<Question> listOfQuestions = quiz.getListOfQuestions();
        for (int i = 0; i < listOfQuestions.size(); i++)
        {
            Question question = listOfQuestions.get(i);
            System.out.printf("%d) %s\n\n",i + 1, question);
        }
        if (printAnswers)
        {
            System.out.println("Answer Key:");
            for (int i = 0; i < listOfQuestions.size(); i++)
            {
                Question question = listOfQuestions.get(i);
                System.out.printf("%d) %s\n",i + 1, question.getAnswer());
            }
        }
        System.out.println("Press enter to return to menu...");
        new Scanner(System.in).nextLine();
    }
    private void printQuizToFile()
    {
        String filename = "quiz.txt";
        Quiz quiz = new Quiz(numOfQuestions);
        ArrayList<Question> listOfQuestions = quiz.getListOfQuestions();
        try
        {
            File file = new File(filename);
            if (!file.createNewFile()) {
                int i = 1;
                while (!file.createNewFile()) {
                    filename = "quiz" + i + ".txt";
                    file = new File(filename);
                    i++;
                }
            }
            System.out.println("File successfully created!");
            sleep(500);

            FileWriter fileWriter = new FileWriter(filename);
            System.out.print("Writing");
            for(int i = 0; i < 3; i++)
            {
                System.out.print(".");
                sleep(1000);
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
            sleep(1000);
        }
        catch (IOException e)
        {
            System.out.println("Whoops looks like something went wrong!");
        }
    }
    private void promptForNumOfQuestions()
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
                System.out.print("\033\143");
            }
        }
        catch (Exception e)
        {
            System.out.println("Whoops looks like something went wrong!");
        }
    }
    public void previousPage(String pageID)
    {
        displayMenu(pageID.substring(0,pageID.length() - 1));
    }

    public void sleep (int duration)
    {
        try {Thread.sleep(duration);}
        catch (InterruptedException e) {System.out.println("Whoops something went wrong");}
    }
    public static boolean isBasicQuestionsIncluded() {
        return basicQuestionsIncluded;
    }

    public static boolean isArrayQuestionsIncluded() {
        return arrayQuestionsIncluded;
    }
}

