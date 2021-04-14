/* Magic square pasted 
Assignment 4 – Magic Square
See assignment date in course, see also successful submission requirements in General Info section in course
The goal of this assignment is to determine if a 2D array is a magic square.
Requirements
Write a program that will read in numbers from a text file, convert them to a 2D array, and detect if those numbers are a “magic square”. See https://en.wikipedia.org/wiki/Magic_square (Links to an external site.) for related information.
This program consists of three main tasks:
1) Read in the set of numbers from a text file.
The text file will contain n lines containing n integers, and each number is separated by a blank space. For example:
2 7 6
9 5 1
4 3 8
2. Detect if a set of integers is a magic square.

A magic square of order n is an arrangement of n2 numbers in a square with the following properties:

The n numbers in all rows, all columns, and on both diagonals sum to the same constant.

Each number should only occur once in the magic square.
2 7 6
9 5 1
4 3 8
In the square above, each number appears only once, and each row, column, and diagonal sums to 15:
Rows: 2 + 7 + 6 = 15
9 + 5 + 1 = 15
4 + 3 + 8 = 15
Columns: 2 + 9 + 4 = 15
7 + 5 + 3 = 15
6 + 1 + 8 = 15
Diagonals: 2 + 5 + 8 = 15
4 + 5 + 6 = 15

Store the set of integers in a 2D array. Your program should pass the array (or parts of the array) to various methods that check one of the rules to determine if it is a magic number.

If your program detects that a 2D array of integers is a magic square, then your program should output the list of numbers, the order of the magic square, and the magic constant.

For example,  given the 2D array of integers:
2 7 6
9 5 1
4 3 8

Your program should print:

The combination of numbers 2 7 6 9 5 1 4 3 8 is a magic square of order 3.
The magic constant is 15.
 
You do not need to print the numbers in a square format, though that would be better.

If your program detects that a 2D array of integers is NOT a magic square, then your program should output the list of numbers and a statement that the array is not a magic square.
For example, given the following 2D array of integers:
8 4
9 1
2 3
Your program should print
The combination of numbers 8 4 9 1 2 3 is not a magic square.
3. Your program should not crash.

You must check for and handle every possible problem with the input. That means you should be checking for possible exceptions that can occur in the code. When an exception is thrown, you should print a clear and concise description of the problem, and end the program. You should not catch “Exception” in the code - you should catch specific derived classes of the Exception class
Required classes:
Main - holds the main method, prompts the user for filename, reads in numbers from a file, creates objects of other classes, and prints out final results back to the user
MagicSquareDetector - determines if a 2D array of integers is a magic square
MagicSquare - holds a set of numbers that have been verified as a magic square, has fields that hold the magic constant, order of the magic square, etc., and has a toString method that prints out all the information
Coding Style
This grade is awarded for proper coding style. This includes:
Your name in comments at the top of every Java file
Appropriate method, variable, field, object, and class names
Proper indentation
Good Javadoc and within method commenting (explains what the code is doing)
Well-organized, elegant solutions for each part
Files to submit:
A ZIP file of your NetBeans project.
Your project must compile to receive credit