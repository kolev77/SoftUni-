package app.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "water")
@PrimaryKeyJoinColumn(name = "id")
public class Water extends BasicChemicalIngredient {
    public Water() {
        super("Water", BigDecimal.valueOf(0.07),"H2O");
    }
}
