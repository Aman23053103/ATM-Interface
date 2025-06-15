import java.util.*;

class BankAccount {
    private double bal;
    public BankAccount(double initialBal) {
        this.bal = initialBal;
    }
    public boolean withdraw(double amt) {
        if (amt <= 0 || amt > bal) {
            return false;
        }
        bal -= amt;
        return true;
    }
    public void deposit(double amt) {
        if (amt > 0) {
            bal += amt;
        }
    }
    public double getBalance() {
        return bal;
    }
}
class ATM {
    private BankAccount acct;
    public ATM(BankAccount account) {
        this.acct = account;
    }
    public void begin() {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("Welcome to the ATM!");
        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Check Your Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter Your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Your current balance is ₹" + acct.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmt = sc.nextDouble();
                    acct.deposit(depositAmt);
                    System.out.println("₹" + depositAmt + " deposited successfully.");
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmt = sc.nextDouble();
                    if (acct.withdraw(withdrawAmt)) {
                        System.out.println("₹" + withdrawAmt + " withdrawn successfully.");
                    } else {
                        System.out.println("Withdrawal failed. Insufficient funds or invalid amount.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);
    }
}
public class Atminterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(70000);
        ATM atm = new ATM(userAccount);
        atm.begin();
    }
}
