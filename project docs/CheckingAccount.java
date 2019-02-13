/**
   A checking account that charges transaction fees.
*/
public class CheckingAccount extends BankAccount
{
   // instance var's and class constants
   private int transactionCount ;

   private static final int FREE_TRANSACTIONS = 3 ;
   private static final double TRANSACTION_FEE = 2.0 ;

   /**
      Constructs a checking account with a given balance
      @param initialBalance the initial balance
   */
   public CheckingAccount(int initialBalance)
   {
      // construct superclass
      super(initialBalance);

      // initialize transaction count
      transactionCount = 0;
   }

   public void deposit(double amount)
   {
      transactionCount++;
      // now add amount to balance
      super.deposit(amount);
   }

   public void withdraw(double amount)
   {
      transactionCount++;
      // now subtract amount from balance
      super.withdraw(amount);
   }

   /**
      Deducts the accumulated fees and resets the
      transaction count.
   */
   public void deductFees()
   {
      if (transactionCount > FREE_TRANSACTIONS)
      {
         double fees = TRANSACTION_FEE *
            (transactionCount - FREE_TRANSACTIONS);
         super.withdraw(fees);
      }
      transactionCount = 0;
   }
}
