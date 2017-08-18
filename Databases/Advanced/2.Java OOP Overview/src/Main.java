import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by Rostislav Kolev on 03-Jul-17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, BankAccount> base = new HashMap<>();
        String input = br.readLine();

        while (!input.equals("End")) {
            String[] command = input.split(" ");
            String action = command[0];
            if (action.equals("Create")) {
                Integer acc_id = Integer.valueOf(command[1]);
                if (!base.containsKey(acc_id)) {
                    BankAccount current = new BankAccount();
                    current.setId(acc_id);
                    base.put(acc_id, current);
                } else {
                    System.out.println("Account already exists");
                }
            } else if (action.equals("Deposit")) {
                Integer acc_id = Integer.valueOf(command[1]);
                double sum = Double.valueOf(command[2]);
                if (base.containsKey(acc_id)) {
                    base.get(acc_id).deposit(sum);
                } else {
                    System.out.println("Account does not exist");
                }
            } else if (action.equals("Withdraw")) {
                Integer acc_id = Integer.valueOf(command[1]);
                double sum = Double.valueOf(command[2]);
                if (base.containsKey(acc_id)) {
                    BankAccount current = base.get(acc_id);
                    if (current.getBalance() >= sum) {
                        base.get(acc_id).withdraw(sum);
                    } else {
                        System.out.println("Insuffficient balance");
                    }
                } else {
                    System.out.println("Account does not exist");
                }
            } else if (action.equals("Print")) {
                Integer acc_id = Integer.valueOf(command[1]);
                if (base.containsKey(acc_id))
                    System.out.println(base.get(acc_id));
                else
                    System.out.println("Account does not exist");
            }
            input = br.readLine();
        }

    }

}
