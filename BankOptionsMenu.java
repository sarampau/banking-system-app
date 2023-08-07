import java.util.Scanner;

public class BankOptionsMenu {

    private Scanner scanner = new Scanner(System.in);
    private BankAccount bankAccount = null;
    
    public void start() {
        
        while (true) {
            showMenuOptions();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    case 2:
                        case 3:
                            case 4:
                    processMenuSelection(choice);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private boolean isBankAccount() {
        if (bankAccount != null) {
            return true;
        } else { // TODO: Revisit this in future.
            System.out.println("No account found. Please open an account first");
        }
        return false;
    }
    private void showMenuOptions() {
        System.out.println("Menu:");
        System.out.println("1. Open an account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Check balance");
        System.out.println("0. Exit");
        System.out.print("Enter your choice");
    }

    private void processMenuSelection(int menuChoice) {
        BankOperationType bankOperationType = BankOperationType.getType(menuChoice);
        if (bankOperationType != BankOperationType.NEW_ACCOUNT && bankAccount == null) {
            System.out.println("Create new account");
        } else {
            switch (bankOperationType) {
                case NEW_ACCOUNT -> handleNewAccount();
                case DEPOSIT -> handleDeposit();
                case WITHDRAWAL -> handleWithdrawl();
                case CHECK -> handleCheck();
            }
        }

    }

    private void handleNewAccount() {
        System.out.println("Enter account number: ");
        int accountNumber = scanner.nextInt();
        System.out.println("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        bankAccount = new BankAccount(accountNumber, initialBalance);
        System.out.println("Account opened successfully.");
    }

    private void handleDeposit() {
        System.out.println("Enter deposit amount: ");
        double depositAmount = scanner.nextDouble();
        bankAccount.deposit(depositAmount);
    }

    private void handleWithdrawl() {
        System.out.println("Enter withdrawal amount");
        double withdrawalAmount = scanner.nextDouble();
        bankAccount.withdraw(withdrawalAmount);
    }

    private void handleCheck() {
        bankAccount.checkBalance();
    }
}


/*
 case 1: // Creates new account
                    handleNewAccount();
                    break;
                case 2: // Deposits money
                    if (isBankAccount()) {
                        handleDeposit();
                    }
                    break;
                case 3: // Withdraws money
                    if (isBankAccount()) {
                        handleWithdrawl();
                    }
                    break;
                case 4: // Checks account balance
                    if (isBankAccount()) {
                        handleCheck();
                    }
                    break;
 */