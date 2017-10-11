package app.entities.TablePerClass;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "amonium_cloride")
public class AmoniumCloride extends BasicChemicalIngredient {
    public AmoniumCloride() {
        super("Amonium Cloride", BigDecimal.valueOf(0.60),"NH4CL");
    }
}
