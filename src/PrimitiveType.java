import java.util.Random;

public enum PrimitiveType
{
    STRING("String"),
    INT("int"),
    BOOLEAN("boolean"),
    DOUBLE("double"),
    CHAR("char");
    private static Random randomizer = new Random();
    private String stringValue;
    PrimitiveType(String stringValue)
    {
        this.stringValue = stringValue;
    }
    public static PrimitiveType getRandomPrimitiveType()
    {
        PrimitiveType[] primitiveTypes = PrimitiveType.values();
        int primitiveTypeIndex = randomizer.nextInt(primitiveTypes.length);
        return primitiveTypes[primitiveTypeIndex];

    }
    public String toString()
    {
        return stringValue;
    }
}