package theExpanse.entities;

abstract class Engineer extends Colonist {
    protected Engineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    abstract int getPotential();
}
