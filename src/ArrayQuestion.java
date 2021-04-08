public class ArrayQuestion implements Question
{
   private ArrayType datatype;
   private String variableName;
   private String value;
   private int numberOfElements
   private String answer;
   private String question;
   
   public enum ArrayType
    {
        STRING("String[]"),
        INT("int[]"),
        BOOLEAN("boolean[]"),
        DOUBLE("double[]"),
        CHAR("char[]");

        private String stringValue;
        private ArrayType(String stringValue)
        {
            this.stringValue = stringValue;
        }
        public static ArrayType getRandomArrayType()
        {
            PrimitiveType[] arrayTypes = ArrayType.values();
            int arrayTypeIndex = randomizer.nextInt(arrayTypes.length);
            return arrayTypes[arrayTypeIndex];
            
        }
        public String toString()
        {
            return stringValue;
        }
    }
   public ArrayQuestion()
   {
        datatype = ArrayType.getRandomArrayType(); // picks a random datatype from TYPES array
        variableName = getRandomItem(Data.VARIABLE_NAMES); // picks a random variable name from VARIABLE_NAMES array
      // picks a random value for the variable based on the datatype
        switch (datatype)
        {
            case STRING:
                value = getRandomItem(Data.STRING_VALUES);
                break;
            case CHAR:
                value = getRandomItem(Data.CHAR_VALUES);
                break;
            case INT:
                value = String.valueOf(randomizer.nextInt(1998) - 999);
                break;
            case DOUBLE:
                value = String.valueOf((randomizer.nextInt(198) - 99) 
                        + ((int)(randomizer.nextDouble() * 1000) / 1000.0));
                break;
            case BOOLEAN:
                value = String.valueOf(randomizer.nextBoolean());
                break;
        }
        if (randomizer.nextInt(100) <= 33) // 10% chance you will just declare the variable with no value
        {
            value = "";
        }
        else if (randomizer.nextInt(100) <= 33) // if there is a value, 10% chance of there being no type (means you assign a value to an existing variable)
        {
            datatype = null;
        }
        answer = generateAnswer();
        question = generateQuestion();
   }
   public String[] getRandomElements(String[] _stringArray, int numberOfElements)
   {
        String[] randomElements = new String[numberOfElements];
        for (int i = 0; i < numberOfElements; i++);
        {
            int indexOfRandomElement = randomizer.nextInt(_stringArray.length);
            String randomElement = _stringArray;
        }
        
        return randomElements;
   }
}