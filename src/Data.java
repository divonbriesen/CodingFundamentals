import java.util.HashMap;
import java.util.Random;
public class Data
{
    public static final String[] BASIC_VARIABLE_NAMES = {"x", "y", "z", "a", "b", "c", "i", "j", "dog", "age", "height", "width", "length", "area",
                                                   "volume", "id", "aBoolean", "java", "aStudent", "gpa", "question", "quiz", "answer", "type",
                                                   "studentId", "myVar", "anInt", "aDouble", "aChar", "aString", "aLong", "aFloat", "aByte",};
    public static final String[] ARRAY_VARIABLE_NAMES = {"x", "y", "z", "a", "b", "c", "names", "ages", "questions", "answers", "usernames",
                                                         "booleanArray", "intArray", "doubleArray", "floatArray", "byteArray", "stringArray",
                                                         "sArray", "cats", "dogs", "charArray", "letters", "grades", "results", "primes"};
    public static final String[] STRING_VALUES = {"\"cat\"", "\"dog\"", "\"true\"", "\"false\"", "\"23\"", "\"Bob\"", "\"Jane\"", "\"Jane\", \"Jill\", \"Jone\""};
    public static final String[] CHAR_VALUES = {"'a'", "'b'", "'c'", "'d'", "'e'", "'f'", "'g'", "'h'", "'i'", "'j'", "'k'", "'l'", "'m'",
                                                "'n'", "'o'", "'p'", "'q'", "'r'", "'s'", "'t'", "'u'", "'v'", "'w'", "'x'", "'y'", "'z'",
                                                "'!'", "'@'", "'#'", "'$'", "'%'", "'^'", "'&'", "'*'", "'('", "')'", "'{'", "'}'", "'['",
                                                "']'", "'/'", "'.'", "','", "'<'", "'>'", "'?'", "'1'", "'2'", "'3'", "'4'", "'5'", "'6'",
                                                "'7'", "'8'", "'9'", "'0'", "'-'", "'_'", "'+'", "'='", "'~'", "'A'", "'B'", "'C'", "'D'",
                                                "'E'", "'F'", "'G'", "'H'", "'I'", "'J'", "'K'", "'L'", "'M'", "'N'", "'O'", "'P'", "'Q'",
                                                "'R'", "'S'", "'T'", "'U'", "'V'", "'W'", "'X'", "'Y'", "'Z'"};
    public static final String PAGE1 = "HOME\n1. Start quiz\n2. Print quiz to file\n3. Print all questions to screen\n4. Options\n5. Exit";
    public static final String PAGE14 = "OPTIONS\n1. Back to home\n2. Change number of questions\n3. Change difficulty\n4. Print answer key with quiz\n5. Change type of questions";
    public static final String PAGE145 = "QUESTION TYPE SETTINGS\n1. Back to options\n2. Include basic variable questions\n3. Include array questions";
    public static final HashMap<String, String> PAGES = new HashMap<>();
    static
    {
        PAGES.put("1",PAGE1);
        PAGES.put("14",PAGE14);
        PAGES.put("145",PAGE145);
    }
    public static final String[] ORDINAL_WORDS = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth",
                                                  "eleventh", "twelfth", "thirteenth", "fourteenth", "fifteenth", "sixteenth", "seventeenth",
                                                  "eighteenth", "nineteenth", "twentieth", "twenty-first", "twenty-second", "twenty-third",
                                                  "twenty-fourth", "twenty-fifth"};

    public static <T> T getRandomItem(T[] arrayOfStrings)
    {
        Random randomizer = new Random();
        int indexOfRandomItem = randomizer.nextInt(arrayOfStrings.length);
        return arrayOfStrings[indexOfRandomItem];
    }
}
