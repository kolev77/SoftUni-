package entities.positions;

import entities.institutions.Administration;
import enums.EmployeePosition;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Chief extends BaseEmployee {
    private Administration managedAdministration;

    public Chief() {
        this.setPosition(EmployeePosition.DIRECTOR_OF_DEPARTMENT);
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "managed_administration_id")
    public Administration getManagedAdministration() {
        return managedAdministration;
    }

    public void setManagedAdministration(Administration managedAdministration) {
        this.managedAdministration = managedAdministration;
    }
}