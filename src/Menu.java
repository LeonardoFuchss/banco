import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Current current = new Current();
        Saving saving = new Saving();
        boolean close = false;

        while (!close) {
            System.out.println("===== Welcome ======");
            System.out.println("1: Created account");
            System.out.println("2: Withdraw");
            System.out.println("3: Deposit");
            System.out.println("4: Transfer");
            System.out.println("5: Show Account");
            System.out.println("6: Close");
            System.out.println("====================");
            int choice = scanner.nextInt();

                switch (choice) {

                    case 1:
                        System.out.println("==================");
                        System.out.println("1: Current account");
                        System.out.println("2: Saving account");
                        System.out.println("3: Back");
                        System.out.println("==================");
                        int choice2 = scanner.nextInt();
                        switch (choice2) {
                            case 1:
                                current.createdAccount();
                                break;
                            case 2:
                                saving.createdCountSaving();
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Invalid option");

                        }
                        break;
                    case 2:
                        System.out.println("==================");
                        System.out.println("1: Current account");
                        System.out.println("2: Saving account");
                        System.out.println("==================");
                        int choice3 = scanner.nextInt();
                        switch (choice3) {
                            case 1:
                                current.withdraw();
                                break;
                            case 2:
                                saving.withdraw();
                                break;
                            default:
                                System.out.println("Invalid option");
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("==================");
                        System.out.println("1: Current account");
                        System.out.println("2: Saving account");
                        System.out.println("==================");
                        int choice4 = scanner.nextInt();
                        switch (choice4) {
                            case 1:
                                current.deposit();
                                break;
                            case 2:
                                saving.deposit();
                                break;
                            default:
                                System.out.println("Invalid option");
                                break;
                        }
                        break;
                    case 4:
                        current.transfer();
                        break;
                    case 5:
                        current.showAccount();
                        break;
                    case 6:
                        close = true;
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
        }
    }
}
