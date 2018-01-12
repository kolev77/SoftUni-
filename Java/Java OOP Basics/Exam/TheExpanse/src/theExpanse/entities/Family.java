package theExpanse.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Family {
    private String id;
    List<Colonist> members;

    public Family(String id) {
        this.id = id;
        members = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<Colonist> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getId() + ":\n");
        this.members.sort(Comparator.comparing(Colonist::getId));
        for (Colonist member : members) {
            sb.append("-").append(member.getId()).append(": ").append(member.getPotential());
        }
        return sb.toString();
    }
}
