package theExpanse.entities;

public class SoftwareEngineer extends Engineer {
    public SoftwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getPotential() {
        int potential = super.getTalent() + 3;
        if (super.getAge() > 30) {
            potential += 2;
        }
        potential += 2;
        return potential;
    }

}
