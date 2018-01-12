package theExpanse.entities;

public class GeneralPractitioner extends Medic {

    public GeneralPractitioner(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
   public int getPotential() {
        int potential = super.getTalent() + 2;
        if (super.getAge() > 15) {
            potential += 1;
        }
        if (super.getSign().equalsIgnoreCase("caring")) {
            potential += 1;
        } else if (super.getSign().equalsIgnoreCase("careless")) {
            potential -= 2;
        }
        return potential;
    }

    @Override
    public String getSign() {
        return null;
    }
}