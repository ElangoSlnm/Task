public class SavingsAccount extends Account {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override

    boolean transact(Account another, String type, double amount) throws Exception {

        if(amount < 1){
            throw new Exception("Invalid Amount. Amount should be positive Number");
        }
        if (type.equalsIgnoreCase("1"))

        {

            if((another.checkBalance() - amount) < 5000.00){
                throw new Exception("Withdraw not possible. Insuff. Balance");
            }

            another.setBalance(another.checkBalance() - amount);
            System.out.println("Withdrawal successfull.\nThe available balance is " + another.checkBalance());
        }

        else if (type.equalsIgnoreCase("2"))

        {

            another.setBalance(amount + another.checkBalance());

            System.out.println("Deposit success...!!!\nThe available balance is " + another.checkBalance());

        } else

            System.out.println("Incorrect choice");

        return true;
    }

    @Override
    double minBalance() {
        return 10000;
    }

}