package app.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "amonium_cloride")
@PrimaryKeyJoinColumn(name = "id")
public class AmoniumCloride extends BasicChemicalIngredient {
    public AmoniumCloride() {
        super("Amonium Cloride", BigDecimal.valueOf(0.60),"NH4CL");
    }
}
