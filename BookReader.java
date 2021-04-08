// copied directly from the lab PDF

/*
OVERVIEW In this lab, you will load book chapters from a file and write book chapters to a file. 
You will read information from a file 
to create a new BookChapter object, 
and you will write new files with the same format based on an existingBookChapter object.

1)Part A: Create classes 
2)Part B: Load book chapter from file
3)Part C: Write Book chapter to file

Preamble:There are two sample book chapter files on Canvas called 
    slaughterhouse_five_chapter_1.txt and game_of_thrones_chapter_1.txt. 
    Download these and place them in your project folder (not in ‘src’ with your java files).
    The format of these files is the following: *Title* *Author* *Lines per page* *Line 1* *Line 2* ... *Line n* 
    The first line in a book chapter file is the title. The second line is the author. 
    The third line is the number of lines on each page. Each line after the third line is a line 
    from the book’s first chapter.

    Part A: Create classes. (3 points) 
        1)Create a project named Lab7. 
        2)Create a BookChapterclass. This class should have the following fields:

        */
        public class BookChapter 
        {
            private int linesPerPage;
            private ArrayList<Page> pages;
            private String title;
            private String author; 
        }
/*
        •private int linesPerPage •private ArrayList<Page> pages •private String title •private String author 
        3)Create getter and setter methods for each variable. 
            The class should have three constructors:
            •public BookChapter(int l)
                - this constructor should set linesPerPage to l.
            •public BookChapter(int l, ArrayList<Page> p)
                - this constructor should set linesPerPage to l a nd pages to p. 
            •public BookChapter(int l, ArrayList<Page> p, String t, String a)
                - this constructor should set linesPerPage to l, pages to p, title to t, and author to a. 
        4)Create a toString() method for the BookChapter class. 
            This public method should return a String that prints the book information in the format:
            Title: *the title variable* Author: *the author variable* Pages: *sizeof the pages array variable* 
            Lines per page: *the linesPerPage variable” 
        5)Create a Page class. This class should have a private String[] field named ‘lines’. 
        */
        public class Page
        {
            private String[] lines;

            public Page(int numLines)
            {
                lines = new String[numLines];
            }
            public Page(String[] l)
            {
                this.lines = l;
            }

            public void setLines(String[] _lines)
            {
                lines = _lines;
            }
            public String[] getLines()
            {
                returns lines;
            }
        }
 

        /*
            Create getter and setter methods for this member. The class should have two constructors:
                •public Page(int numLines)- this constructor should instantiate the linesarray with size numLines
                •public Page(String[] l)- this constructor should set the lines array equal to the parameter.

        6)Create a BookChapterReadWrite class. This class will only have static methods. 
            Create two public static methods:
            •public static BookChapter loadBookChapterFromFile(String filename) 
            •public static void writeBookChapterToFile (BookChapter book, String filename) 
    Part B: Load book chapter from file. (5 points) 
        1)Implement the BookChapterReadWrite.LoadBookChapterFromFile(String filename) method. 
        Add the text “ throws FileNotFoundException, IOException” after the method parameters. 
        The whole method declaration should be: 
        */   
        public static BookChapter loadBookChapterFromFile(String filename) throws FileNotFoundException, IOException 
        /*
        2)First, open the file at the filename passed in as a parameter. Read the first 3 lines of the file, 
        and save the information. Then, create the getPage() method (below). This method should create and 
        return a new Page object, and the Page object’s array field ‘String[] lines’ should be filled up with 
        lines read from the file.
        */
        private static Page getPage(Scanner scanner, int numLines)
        
        /*
        3)Repeatedly create Page objects using the getPage() method until you have read all the lines in the file. 
        Then put all of your Page objects into a BookChapter object’s pages field and return the BookChapterobject.
        4)In the main method, create a Book object by calling BookChapterReadWrite.
        loadBookChapterFromFile with the sample book files. For each book file, print out the result of the object’s 
        toString() method. 

        Add “throws FileNotFoundException, IOException” to the end of the main method declaration.
        Don’t forget to close your file stream when you’re done with it!

    Part C: Write book chapter to file. (3 points) 
        1)Implement the BookChapterReadWrite.writeBookChapterToFile(BookChapterbook, String filename) method. 
        This method should create or overwrite the file at the filename passed as a parameter. It should then 
        write the book chapter to that file. The book chapter should be written in the same format seen in the
         sample chapters.
       Part B: Load book chapter from file. (5 points) 
       1)Implement the BookChapterReadWrite.LoadBookChapterFromFile(String filename) method. 
       Add the text “ throws FileNotFoundException, IOException” after the method parameters. 
       The whole method declaration should be:    
       public static BookChapter loadBookChapterFromFile(String filename) throws FileNotFoundException, IOException 
        2)First, open the file at the filename passed in as a parameter. Read the first 3 lines of the file, 
       and save the information. Then, create the getPage() method (below). This method should create and return 
       a new Page object, and the Page object’s array field ‘String[] lines’ should be filled up with lines read 
       from the file.
        private static Page getPage(Scanner scanner, int numLines)
        3)Repeatedly create Page objects using the getPage() method until you have read all the lines in the file.
        Then put all of your Page objects into a BookChapter object’s pages field and return the BookChapterobject.
        4)In the main method, create a Book object by calling BookChapterReadWrite.loadBookChapterFromFile with 
        the sample book files. For each book file, print out the result of the object’s toString() method. 
        Add “throws FileNotFoundException, IOException” to the end of the main method declaration.
        Don’t forget to close your file stream when you’re done with it!
    Part C: Write book chapter to file. (3 points) 
        1)Implement the BookChapterReadWrite.writeBookChapterToFile(BookChapterbook, String filename) method. 
        This method should create or overwrite the file at the filename passed as a parameter. It should then
         write the book chapter to that file. The book chapter should be written in the same format seen in the 
         sample chapters.
        2)Add the text “ throws FileNotFoundException, IOException” after the method parameters like you did for the 
        loadBookChapterFromFile method. If you use a PrintWriter object, then you should call the flush() method 
        after each call to write or writeln().Don’t forget to close your file stream when you’re done with it!
        3)Test this method by loading a book chapter from a file and then writing the BookChapter object to a 
        different file. The two files should look the same. It is okay if your file has a trailing line after
        the last line of text.
        4)For each of the sample chapters, load them in using the loadBookChapterFromFilemethod and write them 
        to a different file using writeBookChapterToFile. You’re done! 
     Part D: Turn in your activities
        1.Submit the following file:
            a.Your properly exported project Lab7.zipfile.