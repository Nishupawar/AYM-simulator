import java.util.ArrayList;
import java.util.Scanner;

// Define a class to represent an ATM
class ATM {
    private double balance; // Account balance
    private String pin;     // PIN for the account
    private ArrayList<String> transactionHistory; // Transaction history
    
    // Constructor to initialize the ATM
    public ATM(double initialBalance, String pin) {
        this.balance = initialBalance;
        this.pin = pin;
        this.transactionHistory = new ArrayList<>();
    }
    
    // Method to check account balance
    public double checkBalance() {
        return balance;
    }
    
    // Method to withdraw cash
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawal: $" + amount);
            System.out.println("Successfully withdrawn $" + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }
    
    // Method to deposit cash
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposit: $" + amount);
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }
    
    // Method to change PIN
    public void changePin(String newPin) {
        this.pin = newPin;
        System.out.println("PIN changed successfully.");
    }
    
    // Method to display transaction history
    public void showTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

// Main class to run the ATM simulation
public class ATMProgram {
    public static void main(String[] args) {
        // Initialize an ATM instance
        ATM atm = new ATM(1000.0, "1234"); // Starting balance $1000, PIN "1234"
        
        // Example usage of ATM methods
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Change PIN");
            System.out.println("5. Transaction History");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            
            switch (option) {
                case 1:
                    System.out.println("Current Balance: $" + atm.checkBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter new PIN: ");
                    String newPin = scanner.next();
                    atm.changePin(newPin);
                    break;
                case 5:
                    atm.showTransactionHistory();
                    break;
                case 0:
                    System.out.println("Exiting ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
            
        } while (option != 0);
        
        scanner.close();
    }
}
