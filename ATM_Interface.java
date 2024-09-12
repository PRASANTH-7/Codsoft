import java.util.Scanner;

// BankAccount class to represent a user's bank account
class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Method to deposit money into the account
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    // Method to withdraw money from the account
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    // Method to check the current balance
    public double checkBalance() {
        return balance;
    }
}

// ATM class to simulate the ATM interface and interaction with BankAccount
class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    // Method to display ATM menu options
    public void showOptions() {
        System.out.println("\n=== ATM Menu ===");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    // Method to handle withdrawals
    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (bankAccount.withdraw(amount)) {
            System.out.println("Withdrawal of " + amount + " successful! Your new balance is: " + bankAccount.checkBalance());
        } else {
            System.out.println("Failed to withdraw " + amount + ". Insufficient balance or invalid amount.");
        }
    }

    // Method to handle deposits
    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();

        if (bankAccount.deposit(amount)) {
            System.out.println("Deposit of " + amount + " successful! Your new balance is: " + bankAccount.checkBalance());
        } else {
            System.out.println("Failed to deposit " + amount + ". Please enter a valid amount.");
        }
    }

    // Method to check the balance
    public void checkBalance() {
        System.out.println("Your current balance is: " + bankAccount.checkBalance());
    }

    // Main loop to start ATM operations
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showOptions();
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    return;
                default:
                    System.out.println("Invalid option. Please select a valid one.");
            }
        }
    }
}

// Main class to simulate the interaction with the ATM and the user's bank account
public class ATMSystem {
    public static void main(String[] args) {
        // Create a BankAccount object with an initial balance of 1000
        BankAccount account = new BankAccount("123456789", "John Doe", 1000.0);
        
        // Create an ATM object and link it with the BankAccount
        ATM atm = new ATM(account);

        // Start the ATM interface
        atm.start();
    }
}
