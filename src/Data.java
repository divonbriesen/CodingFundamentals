import java.util.HashMap;
public class Data
{
//    public static final String[] VERBS = {"Declare", "Define", "Create"};
//    public static final String[] NOUNS = {"a variable", "an identifier"};
//    public static final String[] IDENTIFIER = {"called", "named", "with the name","that's called", "that's named", "that has the name"};
//    public static final String[] ASSIGN = {"set it to", "assign it the value", "give it the value", "make it equal", "initialize it to"};
    public static final String[] VARIABLE_NAMES = {"x", "y", "z", "a", "b", "c"};
    public static final String[] CLASS_NAMES = {"Student", "Random", "Dog", "Person", "Question"};
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
}
