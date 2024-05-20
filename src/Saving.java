
import java.util.ArrayList;
import java.util.Scanner;

public class Saving extends BankAccount {

    ArrayList<BankAccount> countSaving = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public Saving(String name, int number, double cash) {
        super(name, number, cash);
    }

    public Saving() {
    }

    public void createdCountSaving() {

        System.out.println("====== Welcome ======");
        System.out.println("Enter the account name: ");
        String name = scanner.nextLine();

        System.out.println("Enter the account number: ");
        int number = scanner.nextInt();

        System.out.println("Finally, enter the account balance: ");
        double balance = scanner.nextDouble();

        countSaving.add(new Saving(name, number, balance));
    }

    @Override
    public void withdraw() {
        try {
            System.out.println("Enter the number account: ");
            int number = scanner.nextInt();

            BankAccount account = countSaving.stream() // Percorre a lista, verifica se os numeros batem e armazena o primeiro numero que bater
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

            BankAccount account = countSaving.stream()
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

    }

    @Override
    public void showAccount() {
        try {
            System.out.println("=================");
            System.out.println("Enter the your number account: ");
            int number = scanner.nextInt();

            for (BankAccount c : countSaving) {
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

