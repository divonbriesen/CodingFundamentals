import java.util.*;

public class PaymentDriver
{
    public static void main(String[] args)
    {
        System.out.println("STARTING======================");
        
        System.out.println(PaymentTypes.CREDIT);      
        Scanner input = new Scanner(System.in);
        System.out.println("What's your payment type?");
        String paymentType = input.nextLine();

        switch(paymentType)
        {
            case CASH:
                result += "\nCash Monday:";
                break;
            case DEBIT_CARD:
                result += "\nDebit (no fees):";
                break;
            case CREDIT_CARD:
                result += "\nCredit:";
                break;
            case CHECK:
                result += "\nCheck:";
                break;

        System.out.println("ENDED======================");
    }
}