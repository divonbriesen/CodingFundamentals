# CodingFundamentals
 For building foundational code testing/evaluation

Initial evaluation.
Establish whether a learner can consistently and reliably code in response to basic questions about declaring/defining variables:

For example:
Declare a variable to hold an integer called x and assign it the value of 7;
or
Define an identifier called x and assign it the value of 7;

Both of these would be written in java as int x = 7; but the wording is different. 
The goal is to create a "tester" with random wording changes to instill the CONCEPTS without letting the student fall into a pattern the MVP will cover defining variables, initializing them, and doing both at the same time, and cover a smattering of possible verbiage. 

Design should allow for growth in the future to cover if/else statements and for loops, and perhaps other languages.

=========================================




Consider this statement:

"Declare a variable called x;""Define a variable called x;""Create a variable called x;""Make a variable called x;""You need a variable called x;"
Now redo all those phrases replacing "variable" with "identifier".
Now redo all those phrases replacing x with y, or z, or any letter in the alphabet. 
So basically you want to randomize a challenge/interview/quiz question which randomizes the words declare/define/make/create/you need (and any other variations that might mean that) and then randomize the variable name from any letter in the alphabet (but in the future will include a long list of words like variable name lastName, firstName, name, account, accountNumber, num acctNum, blargh, zyx, etc....  so think array of possible variable names with random selector). 
So now you have a question generator for making variables. But oh, look, i forgot to include the data type, so you fill out the sentence by putting a word in front of or after each "variable" to say things likeDeclare an int variable called x.Declar a variable called x to hold an int.Declare a variable for an int called x. 
There are probably about five ways to do this, maybe even more. 
Then you double the options by adding " and instantiage it " or "and initialize it" or "set it equal to..." and so on.
The idea being that you can present literally THOUSANDS of permutations of how to define and/or initialize a variable. If a student can get 20 random questions exactly right, then it's probably fair to say they've mastered that.
For this initial step, it's about declaring/defining variables (both primitives and classes), about assigning values to them (both initializing and replacing) and about doing both in one line (since all three are acceptable, but sometimes need to be split).
My feeling is that these need to be sets of arrays of possible words, and that the question can be an object you instantiate with random values that combine - while generating the question you need also to generate the solution, so for example if I ask

