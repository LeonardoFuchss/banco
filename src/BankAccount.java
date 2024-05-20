public abstract class BankAccount {
    private  String name;
    private  int number;

    private double cash;


    public BankAccount(String name, int number, double cash) {
        this.name = name;
        this.number = number;
        this.cash = cash;
    }

    public BankAccount() {
    }

    public abstract void withdraw();
    public abstract void deposit();
    public abstract void transfer();
    public abstract void showAccount();

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
}
