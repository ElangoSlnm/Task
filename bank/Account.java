import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Account implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    int accountNumber, age;
    String name, phone, dob, accType;
    double balance;
    transient Scanner scanner;

    BankTransactions bObj;

    ArrayList<Integer> accountList;

    Account() {

        scanner = new Scanner(System.in);
        accountList = new ArrayList<Integer>();
        bObj = new BankTransactions();

    }

    public void setAccountNumber(int accountNumber) {

        this.accountNumber = accountNumber;

    }

    public void setName(String name) {

        this.name = name;

    }

    public void setPhone(String phone) {

        this.phone = phone;

    }

    public void setDob(String dob) {

        this.dob = dob;

    }

    public void setAge(int age) throws Exception {
        if(age < 19){
            throw new Exception("Invalid age");
        }
        this.age = age;

    }

    public void setAccType(String accType) {

        this.accType = accType;

    }

    public void setBalance(double balance) throws Exception {
        if(minBalance() > balance ){
            throw new Exception("Invalid minimum balance");
        }
        this.balance = balance;

    }

    public String getName() {

        return name;

    }

    public String getPhone() {

        return phone;

    }

    public String getDob() {

        return dob;

    }

    public double getBalance() {
        return balance;

    }

    public int getAccountNumber() {
        return accountNumber;

    }

    public int getAge() {
        return age;

    }

    double checkBalance() {
        return balance;

    }
    abstract double minBalance();

    abstract boolean transact(Account another, String type, double amount) throws Exception;

    public String getAccType() {

        return accType;

    }

    // Allows user to give input

    void takeAccountDetails() throws Exception {

        String userChoice = "no";

        do {
            System.out.println("Please enter the type of account");
            accType = scanner.nextLine();
            System.out.println("Please enter the account number");
            accountNumber = scanner.nextInt();
            scanner.nextLine();

            if (accountList.contains(accountNumber)) {
                System.out.println("Account already exists!!");

            }

            else {

                accountList.add(accountNumber);
                System.out.println("please enter name");
                name = scanner.nextLine();
                System.out.println("Please enter Date of Birth DD/MM/YYYY");
                dob = scanner.nextLine();
                System.out.println("Please enter Phone number");
                phone = scanner.nextLine();
                System.out.println("Please enter the Initial Amount for deposit");
                balance = scanner.nextFloat();
                scanner.nextLine();
                age = bObj.ageCalculation(dob);
                bObj.populateAccounts(accountNumber, accType, name, dob, phone, balance, age);
                System.out.println("Created");
            }

            System.out.println("Do u want to enter another yes/no??");
            userChoice = scanner.nextLine();
        } while (userChoice.equalsIgnoreCase("yes"));
        bObj.userOperation();
    }
}