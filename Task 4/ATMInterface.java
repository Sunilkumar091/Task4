import java.util.Scanner;

public class ATMInterface {
    private double balance;
    private String accountNumber;
    private String pin;

    public ATMInterface(String accountNumber, String pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = initialBalance;
    }

    public boolean authenticate(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public double checkBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: $" + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void exit() {
        System.out.println("Thank you for using this ATM. Goodbye!");
        System.exit(0);
    }

    public static void main(String[] args) {
        ATMInterface atm = new ATMInterface("123456789", "1234", 1000.0);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your account number: ");
        String enteredAccountNumber = scanner.nextLine();

        System.out.print("Enter your PIN: ");
        String enteredPin = scanner.nextLine();

        if (atm.authenticate(enteredPin) && enteredAccountNumber.equals(atm.accountNumber)) {
            System.out.println("Welcome to the ATM.");
            while (true) {
                System.out.println("Choose an option:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Balance: $" + atm.checkBalance());
                        break;
                    case 2:
                        System.out.print("Enter the deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter the withdrawal amount: $");
                        double withdrawalAmount = scanner.nextDouble();
                        atm.withdraw(withdrawalAmount);
                        break;
                    case 4:
                        atm.exit();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Authentication failed. Please check your account number and PIN.");
        }
    }
}