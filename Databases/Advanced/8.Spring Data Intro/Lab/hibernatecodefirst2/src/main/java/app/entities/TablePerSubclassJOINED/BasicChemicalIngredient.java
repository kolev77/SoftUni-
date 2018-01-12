package app.entities.TablePerSubclassJOINED;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "chemical_ingredient")
@PrimaryKeyJoinColumn(name = "id")
public abstract class BasicChemicalIngredient extends BasicIngredient {
    @Column(name = "chemical_formula")
    private String checmicalFormula;

    public BasicChemicalIngredient(String name, BigDecimal price, String checmicalFormula) {
        super(name, price);
        this.checmicalFormula = checmicalFormula;
    }

    protected BasicChemicalIngredient(String checmicalFormula) {
        this.checmicalFormula = checmicalFormula;
    }

    protected BasicChemicalIngredient() {
    }

    public String getChecmicalFormula() {
        return checmicalFormula;
    }

    public void setChecmicalFormula(String checmicalFormula) {
        this.checmicalFormula = checmicalFormula;
    }
}