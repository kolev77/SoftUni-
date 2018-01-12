package StaticIdAndRate;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, BankAccount> accounts = new HashMap<>();

        String input = br.readLine();

        while (!input.equals("End"))

        {
            String[] commandArgs = input.split("\\s+");
            String commandType = commandArgs[0];
            switch (commandType) {
                case "Create":
                    create(accounts);
                    break;
                case "Deposit":
                    deposit(accounts, Integer.parseInt(commandArgs[1]), Double.parseDouble(commandArgs[2]));
                    break;
                case "GetInterest":
                    getInterest(accounts, Integer.parseInt(commandArgs[1]), Integer.parseInt(commandArgs[2]));
                    break;
                case "SetInterest":
                    setInterest(Double.parseDouble(commandArgs[1]));
            }
            input = br.readLine();
        }

    }

    static void create(HashMap<Integer, BankAccount> accounts) {
        BankAccount account = new BankAccount();
        accounts.put(account.getId(), account);
        System.out.printf("Account ID%s created\n", account.getId());
    }

    static void deposit(HashMap<Integer, BankAccount> accounts, int id, double amount) {
        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
        } else {
            try {
                accounts.get(id).deposit(amount);
                System.out.printf("Deposited %.0f to %s\n", amount, accounts.get(id));
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }

    static void getInterest(HashMap<Integer, BankAccount> accounts, int id, int years) {
        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
        } else {
            System.out.printf("%.2f\n",accounts.get(id).getInterestRate(years));
            ;
        }
    }

    static void setInterest(double rate) {
        BankAccount.setInterestRate(rate);
    }
}