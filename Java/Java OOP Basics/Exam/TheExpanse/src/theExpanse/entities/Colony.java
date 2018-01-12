package theExpanse.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Colony {
    private int maxFamilyCount;
    private int maxFamilyCapacity;
    private List<Family> families;

    public Colony(int maxFamilyCount, int maxFamilyCapacity) {
        this.maxFamilyCount = maxFamilyCount;
        this.maxFamilyCapacity = maxFamilyCapacity;
        this.families = new ArrayList<>();
    }

    public List<Colonist> getColonistsByFamilyId(String familyId) {
        Family family = this.getFamilies().stream().filter(f -> f.getId().equals(familyId)).collect(Collectors.toList()).get(0);

        return Collections.unmodifiableList(family.getMembers());
    }
    public void addColonist(Colonist colonist) {
        if (families.stream().filter(f -> f.getId().equalsIgnoreCase(colonist.getFamilyId())).count() > 0) { // if this family exist
            Family family = families.stream().filter(f -> f.getId().equalsIgnoreCase(colonist.getFamilyId())).collect(Collectors.toList()).get(0);
            if (family.getMembers().size() < this.maxFamilyCapacity) {
                family.getMembers().add(colonist);
            } else {
                System.out.println("family is full");
            }

        } else {
            if (families.size() == maxFamilyCount) {
                System.out.println("colony is full");
            } else {
                Family family = new Family(colonist.getFamilyId());
                family.getMembers().add(colonist);
                families.add(family);
            }
        }
    }

    public void removeColonist(String familyId, String memberId) {
        Family family = families.stream().filter(f -> f.getId().equals(familyId)).collect(Collectors.toList()).get(0);
        family.getMembers().removeIf(m-> m.getId().equalsIgnoreCase(memberId));
        if (family.getMembers().size()==0){
            families.remove(family);
        }
    }

    public void removeFamily(String id) {
        families.removeIf(f -> f.getId().equalsIgnoreCase(id));
    }

    public void grow(int years) {
        families.stream().forEach(f -> f.getMembers().stream().forEach(m -> m.grow(years)));
    }

    public int getPotential() {
        int potential = 0;
        for (Family family : families) {
            for (Colonist colonist : family.getMembers()) {
                potential += colonist.getPotential();
            }
        }
        return potential;
    }

    public String getCapacity() {
        StringBuilder capacity = new StringBuilder();
        this.families.sort(Comparator.comparing(Family::getId));
        capacity.append("families: ").append(families.size()).append("/"+this.maxFamilyCount+"\n");
        for (Family family : families) {
            capacity.append("-");
            capacity.append(family.getId()+": ");
            capacity.append(family.getMembers().size()).append("/"+this.maxFamilyCapacity+"\n");
        }
        return capacity.toString();
    }

    public List<Family> getFamilies() {
        return Collections.unmodifiableList(families);
    }
}
