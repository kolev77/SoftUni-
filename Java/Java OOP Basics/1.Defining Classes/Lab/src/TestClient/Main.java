package TestClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, BankAccount> accounts = new HashMap<>();

        String input = br.readLine();

        while (!input.equals("End")) {
            String[] commandArgs = input.split("\\s+");
            String commandType = commandArgs[0];
            switch (commandType) {
                case "Create":
                    create(accounts, Integer.parseInt(commandArgs[1]));
                    break;
                case "Deposit":
                    deposit(accounts, Integer.parseInt(commandArgs[1]), Double.parseDouble(commandArgs[2]));
                    break;
                case "Withdraw":
                    withdraw(accounts, Integer.parseInt(commandArgs[1]), Double.parseDouble(commandArgs[2]));
                    break;
                case "Print":
                    print(accounts, Integer.parseInt(commandArgs[1]));
                    break;
            }
            input = br.readLine();
        }

    }

    private static void create(HashMap<Integer, BankAccount> accounts, int id) {
        if (!accounts.containsKey(id)) {
            BankAccount account = new BankAccount();
            account.setId(id);
            accounts.put(id, account);
        } else {
            System.out.println("Account already exists");
        }
    }

    private static void deposit(HashMap<Integer, BankAccount> accounts, Integer id, Double amount) {
        if (accounts.containsKey(id)) {
            try {
                accounts.get(id).deposit(amount);
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
        } else {
            System.out.println("Account does not exist");
        }
    }


    private static void withdraw(HashMap<Integer, BankAccount> accounts, Integer id, Double amount) {
        if (accounts.containsKey(id)) {
            try {
                accounts.get(id).withdraw(amount);
            }catch (IllegalStateException ise){
                System.out.println(ise.getMessage());
            }
        } else {
            System.out.println("Account does not exist");

        }
    }

    private static void print(HashMap<Integer,BankAccount> accounts,Integer id){
        if (accounts.containsKey(id)){
            BankAccount account = accounts.get(id);
            System.out.printf("Account %s, balance %.2f\n",account,account.getBalance());
        }else {
            System.out.println("Account does not exist");
        }
    }
}

