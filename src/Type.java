public enum Type
{
    STRING("String"),
    INT("int"),
    BOOLEAN("boolean"),
    DOUBLE("double"),
    CHAR("char");

    private String stringValue;
    Type(String stringValue)
    {
        this.stringValue = stringValue;
    }
    public String toString()
    {
        return stringValue;
    }
}