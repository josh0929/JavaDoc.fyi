/**
   This program tests the BankAccount class and
   their subclasses.
*/
 public class AccountTest
{
   public static void main(String[] args)
   {
      SavingsAccount momsSavings
         = new SavingsAccount(0.5);

      CheckingAccount harrysChecking
         = new CheckingAccount(100);

      momsSavings.deposit(10000);

      momsSavings.transfer(harrysChecking, 2000);
      harrysChecking.withdraw(1500);
      harrysChecking.withdraw(80);

      momsSavings.transfer(harrysChecking, 1000);
      harrysChecking.withdraw(400);

      // simulate end of month
      momsSavings.addInterest();
      harrysChecking.deductFees();

      System.out.println("Mom's savings balance = $"
         + momsSavings.getBalance());

      System.out.println("Harry's checking balance = $"
         + harrysChecking.getBalance());
   }
}

/* program output:

Mom's savings balance = $7035.0
Harry's checking balance = $1116.0

*/
