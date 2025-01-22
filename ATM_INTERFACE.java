import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\nWelcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void startTransaction() {
        int choice;
        double amount;

        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            try {
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Your balance is: Rs. " + account.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter the deposit amount: Rs. ");
                        amount = sc.nextDouble();
                        if (amount > 0) {
                            account.deposit(amount);
                            System.out.println("Deposit successful.");
                        } else {
                            System.out.println("Invalid deposit amount.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter the withdrawal amount: Rs. ");
                        amount = sc.nextDouble();
                        if (account.withdraw(amount)) {
                            System.out.println("Withdrawal successful.");
                        } else {
                            System.out.println("Invalid withdrawal amount or insufficient balance.");
                        }
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // Clear invalid input
            }
        }
    }
}

public class ATM_INTERFACE {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(100000); 
        ATM atm = new ATM(userAccount);
        atm.startTransaction();
    }
}
