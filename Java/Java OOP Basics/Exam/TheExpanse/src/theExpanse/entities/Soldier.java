package theExpanse.entities;

public class Soldier extends Colonist {
    public Soldier(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
   public int getPotential() {
        int potential = super.getTalent() + 3 + 3;
        return potential;
    }
}
