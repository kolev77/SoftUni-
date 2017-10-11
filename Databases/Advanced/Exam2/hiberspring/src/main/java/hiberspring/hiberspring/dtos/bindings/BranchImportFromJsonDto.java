package hiberspring.hiberspring.dtos.bindings;

import com.google.gson.annotations.Expose;
import hiberspring.hiberspring.entities.Town;

public class BranchImportFromJsonDto {
    @Expose
    private String name;
    @Expose
    private Town town;

    public BranchImportFromJsonDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
