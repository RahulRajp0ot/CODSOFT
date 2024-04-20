import java.util.Scanner;

// Bank Account class to represent user's account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

// ATM class representing ATM machine
class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void withdraw() {
        System.out.println("Enter amount to withdraw:");
        double amount = scanner.nextDouble();
        if (bankAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. Current balance: " + bankAccount.getBalance());
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void deposit() {
        System.out.println("Enter amount to deposit:");
        double amount = scanner.nextDouble();
        bankAccount.deposit(amount);
        System.out.println("Deposit successful. Current balance: " + bankAccount.getBalance());
    }

    public void checkBalance() {
        System.out.println("Current balance: " + bankAccount.getBalance());
    }

    public void run() {
        int choice;
        do {
            displayMenu();
            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }
}

public class ATMM {
    public static void main(String[] args) {
        // Create a bank account with initial balance
        BankAccount account = new BankAccount(1000.0);
        // Create an ATM instance with the bank account
        ATM atm = new ATM(account);
        // Run the ATM
        atm.run();
    }
}