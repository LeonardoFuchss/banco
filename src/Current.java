import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Current extends BankAccount {
    ArrayList<BankAccount> countCurrent = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public Current(String name, int number, double cash) {
        super(name, number, cash);
    }

    public Current() {
    }

    public void createdAccount() {
        try {
            System.out.println("===== Welcome =====");
            System.out.println("Enter the account name: ");
            String name = scanner.nextLine();

            System.out.println("Enter the account number: ");
            int number = scanner.nextInt();

            System.out.println("Finally, enter the account balance: ");
            double balance = scanner.nextDouble();
            scanner.nextLine();

            countCurrent.add(new Current(name, number, balance));

        } catch (Exception i) {
            System.out.println("Input invalid");
        }
    }

    @Override
    public void withdraw() {
        try {
            System.out.println("Enter the number account: ");
            int number = scanner.nextInt();

            BankAccount account = countCurrent.stream() // Percorre a lista, verifica se os numeros batem e armazena o primeiro numero que bater
                    .filter(c -> c.getNumber() == number)
                    .findFirst()
                    .orElse(null);

            if (account != null) { // Se não for null
                System.out.println("Enter the amount you want to withdraw: ");
                double value = scanner.nextDouble();

                if (value > account.getCash()) {
                    System.out.println("Insufficient balance");
                } else {
                    double update = account.getCash() - value;
                    account.setCash(update);
                    System.out.println("Withdrawal successful!");
                    System.out.println("Balance: R$ " + account.getCash());
                    System.out.println(" ");
                }
            } else {
                System.out.println("Account not found...");
            }
        } catch (Exception i) {
            System.out.println("Input invalid");
        }
    }

    @Override
    public void deposit() {
        try {

            System.out.println("Enter the number account: ");
            int number = scanner.nextInt();

            BankAccount account = countCurrent.stream()
                    .filter(c -> c.getNumber() == number)
                    .findFirst()
                    .orElse(null);

            if (account != null) {
                System.out.println("Enter the amount you want to deposit: ");
                double value = scanner.nextDouble();

                double update = account.getCash() + value;
                account.setCash(update);
                System.out.println("Deposit made successfully!");
                System.out.println("Balance: $ " + account.getCash());
                System.out.println(" ");
            } else {
                System.out.println("Account not found...");
            }
        } catch (Exception i) {
            System.out.println("Invalid Input");
        }
    }

    @Override
    public void transfer() {
        try {
            if (!countCurrent.isEmpty()) {

                System.out.println("Enter the number account: ");
                int number = scanner.nextInt();

                BankAccount account = countCurrent.stream().filter(c -> c.getNumber() == number).findFirst().orElse(null);

                if (account != null) {

                    System.out.println("Enter the amount you want to transfer: ");
                    double value = scanner.nextDouble();

                    double update1 = account.getCash() - value;
                    account.setCash(update1);

                    System.out.println("Enter the destination account number:");
                    int number2 = scanner.nextInt();

                    BankAccount account2 = countCurrent.stream()
                            .filter(c2 -> c2.getNumber() == number2)
                            .findFirst()
                            .orElse(null);

                    if (account2 != null) {
                        double update2 = account2.getCash() + value;
                        account2.setCash(update2);
                        System.out.println("Transfer completed successfully!");
                        System.out.println("Balance: " + account2.getCash());
                        System.out.println(" ");
                    } else {
                        System.out.println("Account not found...");
                    }
                }
            }
        } catch (Exception i) {
            System.out.println("Invalid input");
        }
    }

    @Override
    public void showAccount() {
        try {
            System.out.println("=================");
            System.out.println("Enter the your number account: ");
            int number = scanner.nextInt();

            for (BankAccount c : countCurrent) {
                if (c.getNumber() == number) {
                    System.out.println("===== ACCOUNT =====");
                    System.out.println("Name: " + c.getName());
                    System.out.println("Number: " + c.getNumber());
                    System.out.println("Cash: " + c.getCash());
                    System.out.println("===================");
                    System.out.println("Press enter to back: ");
                    scanner.nextLine();
                    scanner.nextLine();
                } else {
                    System.out.println("Account not found...");
                }
            }
        } catch (Exception i) {
            System.out.println("Invalid input");
        }
    }
}
