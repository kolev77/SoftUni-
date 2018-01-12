package theExpanse.entities;

public abstract class Colonist {
    private String id;
    private String familyId;
    private int talent;
    private int age;

    protected Colonist(String id, String familyId, int talent, int age) {
        this.id = id;
        this.familyId = familyId;
        this.talent = talent;
        this.age = age;
    }

    protected void setAge(int age) {
        this.age = age;
    }

    protected String getId() {
        return id;
    }

    protected String getFamilyId() {
        return familyId;
    }

    protected int getTalent() {
        return talent;
    }

    protected int getAge() {
        return age;
    }

    protected void grow(int years) {
        this.setAge(this.getAge() + years);
    }

    abstract int getPotential();
}
