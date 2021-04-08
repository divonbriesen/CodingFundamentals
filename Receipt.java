public class Receipt {
    
    private final Transaction transaction;
    
    public Receipt(Transaction t)
    {
        transaction = t;
    }
    
    public Transaction getTransaction()
    {
        return transaction;
    }
    
 
    public String getReceiptString()
    {
        String result = "";
        for(int i=0;i<transaction.getItems().size();i++)
        {
            result += "\n"+transaction.getItems().get(i).toString();
        }
        
        result += "\n------------------------------------------------";
        
        result += "\nSubtotal:\t"+transaction.computeSubtotal();
        result += "\nTax: \t\t"+transaction.computeTax(transaction.computeSubtotal());
        result += "\nTotal: \t\t"+transaction.computeTotal();
        
        for(int i=0;i<transaction.getPayments().size();i++)
        {
            switch(transaction.getPayments().get(i).getType())
            {
                case CASH:
                    result += "\nCash:";
                    break;
                case DEBIT_CARD:
                    result += "\nDebit:";
                    break;
                case CREDIT_CARD:
                    result += "\nCredit:";
                    break;
                case CHECK:
                    result += "\nCheck:";
                    break;
            }
            
            result += "\t\t"+transaction.getPayments().get(i).getAmount();
        }
        
        result += "\nChange:\t\t"+transaction.getChange();
        
        return result;
    }
}