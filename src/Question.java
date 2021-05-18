public class Question
{
   private String question;
   private String answer;
   public void setQuestion(String question, String answer)
   {
      this.answer = answer;
      this.question = question;
   }
   String generateAnswer()
   {
      return "ERROR";
   }
   String generateQuestion()
   {
      return "ERROR";
   }
   String[] formatAnswer(String answer)
   {
      return new String[] {};
   }
   public String getAnswer()
   {
      return answer;
   }
   public String toString()
   {
      return question;
   }
}
   
