package theExpanse.entities;

public class Surgeon extends Medic {
    public Surgeon(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    public int getPotential() {
        int potential = super.getTalent() + 2;
        if (super.getAge() > 25 && super.getAge() < 35) {
            potential += 2;
        }

        if (super.getSign().equalsIgnoreCase("precise")) {
            potential += 3;
        } else if (super.getSign().equalsIgnoreCase("butcher")) {
            potential -= 3;
        }
        return potential;
    }
}
