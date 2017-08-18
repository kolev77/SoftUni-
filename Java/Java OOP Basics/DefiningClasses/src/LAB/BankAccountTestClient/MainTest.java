package LAB.BankAccountTestClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by Rostislav Kolev on 07-Mar-17.
 */
public class MainTest {

    public static void main(String[] args) throws IOException {
        HashMap<Integer, BankAccountTest> accounts = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();

        while (!command.equals("End")) {
            String[] commandArgs = command.split("\\s+");
            String commandType = commandArgs[0];

            switch (commandType) {
                case "Create":
                    executeCreateCommand(accounts, commandArgs[1]);
                    break;
                case "Deposit":
                    executeDepositCommand(accounts, commandArgs);
                    break;
                case "Withdraw":
                    executeWithdrawCommand(accounts, commandArgs);
                    break;
                case "Print":
                    executePrintCommand(accounts, commandArgs);
                    break;
            }

            command = br.readLine();
        }

    }

    private static void executePrintCommand(HashMap<Integer, BankAccountTest> accounts, String[] commandArgs) {
        Integer id = Integer.valueOf(commandArgs[1]);
        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
            return;
        }
        BankAccountTest account = accounts.get(id);
        System.out.printf("Account %s, balance %.2f\n",account,account.getBalance());
    }


    private static void executeWithdrawCommand(HashMap<Integer, BankAccountTest> accounts, String[] commandArgs) {
        Integer id = Integer.valueOf(commandArgs[1]);
        Double amount = Double.valueOf(commandArgs[2]);

        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
            return;
        }
        try {
            accounts.get(id).withdraw(amount);
        } catch (IllegalStateException ise) {
            System.out.println(ise.getMessage());
        }
    }

    private static void executeDepositCommand(HashMap<Integer, BankAccountTest> accounts, String[] commandArgs) {
        Integer id = Integer.valueOf(commandArgs[1]);
        Double amount = Double.valueOf(commandArgs[2]);

        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
            return;
        }
        try {
            accounts.get(id).deposit(amount);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static void executeCreateCommand(HashMap<Integer, BankAccountTest> accounts, String commandArg) {
        int id = Integer.valueOf(commandArg);
        if (accounts.containsKey(id))
            System.out.println("Account already exists");
        else {
            BankAccountTest account = new BankAccountTest();
            account.setId(id);
            accounts.put(id, account);
        }
    }
}
