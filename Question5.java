import java.util.Scanner;

class BankAccount {
    private final int accountNumber;
    private final String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder,
                       double initialBalance) {
        if (accountHolder == null || accountHolder.trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be empty.");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }

        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be greater than zero.");
        }
        balance += amount;
        System.out.println("Deposit successful.");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be greater than zero.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance.");
        }
        balance -= amount;
        System.out.println("Withdrawal successful.");
    }

    public void showBalance() {
        System.out.printf("Current balance: Rs. %.2f%n", balance);
    }

    public void showDetails() {
        System.out.println("\\n----- ACCOUNT DETAILS -----");
        System.out.println("Account number: " + accountNumber);
        System.out.println("Account holder: " + accountHolder);
        showBalance();
    }
}

public class Question5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = null;
        boolean running = true;

        while (running) {
            System.out.println("\\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Balance enquiry");
            System.out.println("5. Display account details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String input = sc.nextLine().trim();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Enter a number from 1 to 6.");
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        if (account != null) {
                            System.out.println("An account has already been created.");
                            break;
                        }

                        System.out.print("Enter account number: ");
                        int number = Integer.parseInt(sc.nextLine().trim());

                        System.out.print("Enter account holder name: ");
                        String name = sc.nextLine().trim();

                        System.out.print("Enter initial balance: ");
                        double initialBalance =
                                Double.parseDouble(sc.nextLine().trim());

                        account = new BankAccount(number, name, initialBalance);
                        System.out.println("Account created successfully.");
                        break;

                    case 2:
                        if (account == null) {
                            System.out.println("Please create an account first.");
                            break;
                        }
                        System.out.print("Enter deposit amount: ");
                        double deposit =
                                Double.parseDouble(sc.nextLine().trim());
                        account.deposit(deposit);
                        account.showBalance();
                        break;

                    case 3:
                        if (account == null) {
                            System.out.println("Please create an account first.");
                            break;
                        }
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawal =
                                Double.parseDouble(sc.nextLine().trim());
                        account.withdraw(withdrawal);
                        account.showBalance();
                        break;

                    case 4:
                        if (account == null) {
                            System.out.println("Please create an account first.");
                        } else {
                            account.showBalance();
                        }
                        break;

                    case 5:
                        if (account == null) {
                            System.out.println("Please create an account first.");
                        } else {
                            account.showDetails();
                        }
                        break;

                    case 6:
                        System.out.println("Thank you for using the Bank Management System.");
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid choice. Choose 1 to 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid numeric input. Please try again.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }
}
