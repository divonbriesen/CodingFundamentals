import java.util.HashMap;
public class Data
{
    public static final String[] VERBS = {"Declare", "Define", "Create"};
    public static final String[] NOUNS = {"a variable", "an identifier"};
    public static final String[] IDENTIFIER = {"called", "named", "with the name","that's called", "that's named", "that has the name"};
    public static final String[] ASSIGN = {"set it to", "assign it the value", "give it the value", "make it equal", "initialize it to"};
    public static final String[] TYPES = {"String", "int", "boolean", "double", "char"};
    public static final String[] VARIABLE_NAMES = {"x", "y", "z", "a", "b", "c"};
    public static final String[] STRING_VALUES = {"\"cat\"", "\"dog\"", "\"true\"", "\"false\"", "\"23\"", "\"Bob\"", "\"Jane\""};
    public static final String[] CHAR_VALUES = {"'a'", "'b'", "'c'", "'d'", "'e'", "'f'", "'g'", "'h'", "'i'", "'j'", "'k'", "'l'", "'m'",
                                                "'n'", "'o'", "'p'", "'q'", "'r'", "'s'", "'t'", "'u'", "'v'", "'w'", "'x'", "'y'", "'z'",
                                                "'!'", "'@'", "'#'", "'$'", "'%'", "'^'", "'&'", "'*'", "'('", "')'", "'{'", "'}'", "'['",
                                                "']'", "'/'", "'.'", "','", "'<'", "'>'", "'?'", "'1'", "'2'", "'3'", "'4'", "'5'", "'6'",
                                                "'7'", "'8'", "'9'", "'0'", "'-'", "'_'", "'+'", "'='", "'~'", "'A'", "'B'", "'C'", "'D'",
                                                "'E'", "'F'", "'G'", "'H'", "'I'", "'J'", "'K'", "'L'", "'M'", "'N'", "'O'", "'P'", "'Q'",
                                                "'R'", "'S'", "'T'", "'U'", "'V'", "'W'", "'X'", "'Y'", "'Z'"};
    public static final String PAGE1 = "HOME\n1. Start quiz\n2. Print quiz to file\n3. Options\n4. Exit";
    public static String PAGE13 = "OPTIONS\n1. Back to home\n2. Change number of questions\n3. Change difficulty\n4. Print answer key with quiz";
    public static final HashMap<String, String> PAGES = new HashMap<>();
    static
    {
        PAGES.put("1",PAGE1);
        PAGES.put("13",PAGE13);
    }

}
