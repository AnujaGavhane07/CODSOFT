import java.util.Scanner;

// Bank Account class
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
        } else {
            return false; 
        }
    }
}


public class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void displayOptions() {
        System.out.println("ATM Options for Usrs :");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void performTransaction(int option, double amount) {
        switch (option) {
            case 1:
                // Withdraw
                boolean withdrawalSuccess = userAccount.withdraw(amount);
                if (withdrawalSuccess) {
                    System.out.println("Withdrawal successful. Remaining balance: $" + userAccount.getBalance());
                } else {
                    System.out.println("Insufficient balance for withdrawal. Please try again.");
                }
                break;

            case 2:
                // Deposit
                userAccount.deposit(amount);
                System.out.println("Deposit successful. Updated balance: $" + userAccount.getBalance());
                break;

            case 3:
                // Check Balance
                System.out.println("Your current balance: $" + userAccount.getBalance());
                break;

            case 4:
                // Exit
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayOptions();

            System.out.print("Enter option (1-4): ");
            int option = scanner.nextInt();

            if (option == 4) {
                
                break;
            }

            System.out.print("Enter amount: $");
            double amount = scanner.nextDouble();

            if (amount < 0) {
                System.out.println("Invalid amount. Please enter a non-negative amount.");
                continue;
            }

            atm.performTransaction(option, amount);
        }

        scanner.close();
    }
}
