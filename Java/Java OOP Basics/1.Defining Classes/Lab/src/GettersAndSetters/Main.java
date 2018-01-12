package GettersAndSetters;

public class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();

        acc.setId(1);
        acc.deposit(400d);
        acc.withdraw(200d);

        System.out.printf("Account %s, balance %.2f",
                acc,
                acc.getBalance());
    }
}
