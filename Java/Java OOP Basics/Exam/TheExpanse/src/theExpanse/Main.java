package theExpanse;

import theExpanse.entities.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");

        int maxFamilyCount = Integer.valueOf(input[0]);
        int maxFamilyCapacity = Integer.valueOf(input[1]);
        Colony colony = new Colony(maxFamilyCount, maxFamilyCapacity);

        while (true) {
            input = br.readLine().split("\\s+");
            String command = input[0];
            if (command.equalsIgnoreCase("end")) {
                break;
            }
            switch (command.toLowerCase()) {
                case "insert":
                    colony.addColonist(createColonist(input));
                    break;
                case "remove":
                    String modificator = input[1];
                    String familyId = input[2];
                    if (modificator.equalsIgnoreCase("family")) {
                        colony.removeFamily(familyId);
                    } else if (modificator.equalsIgnoreCase("colonist")) {
                        colony.removeColonist(familyId, input[3]);
                    }
                    break;
                case "grow":
                    int years = Integer.valueOf(input[1]);
                    colony.grow(years);
                    break;
                case "potential":
                    System.out.printf("potential: %d\n", colony.getPotential());
                    break;
                case "capacity":
                    System.out.print(colony.getCapacity());
                    break;
                case "family":
                    String fId = input[1];
                    if (colony.getFamilies().stream().filter(f -> f.getId().equals(fId)).count() < 1) {
                        System.out.println("family does not exist\n");
                    } else
                        System.out.println(colony.getFamilies().stream().filter(f -> f.getId().equalsIgnoreCase(fId)).collect(Collectors.toList()).get(0).toString().trim());
                    break;
            }

        }

    }

    private static Colonist createColonist(String[] input) {
        String colClass = input[1];
        String colId = input[2];
        String colFamilyId = input[3];
        int colTalent = Integer.valueOf(input[4]);
        int colAge = Integer.valueOf(input[5]);
        switch (colClass.toLowerCase()) {
            case "softwareengineer":
                return new SoftwareEngineer(colId, colFamilyId, colTalent, colAge);
            case "hardwareengineer":
                return new HardwareEngineer(colId, colFamilyId, colTalent, colAge);
            case "soldier":
                return new Soldier(colId, colFamilyId, colTalent, colAge);
            case "generalpractitioner":
                return new GeneralPractitioner(colId, colFamilyId, colTalent, colAge, input[6]);
            case "surgeon":
                return new Surgeon(colId, colFamilyId, colTalent, colAge, input[6]);
            default:
                return null;
        }
    }
}
