import java.util.Random;

public enum Type
{
    STRING("String"),
    INT("int"),
    BOOLEAN("boolean"),
    DOUBLE("double"),
    CHAR("char");
    private static Random randomizer = new Random();
    private String stringValue;
    Type(String stringValue)
    {
        this.stringValue = stringValue;
    }
    public static Type getRandomType()
    {
        Type[] randomType = Type.values();
        int randomTypeIndex = randomizer.nextInt(randomType.length);
        return randomType[randomTypeIndex];

    }
    public String toString()
    {
        return stringValue;
    }
}