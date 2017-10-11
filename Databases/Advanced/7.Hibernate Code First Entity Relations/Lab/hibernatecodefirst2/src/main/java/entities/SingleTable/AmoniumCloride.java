package entities.SingleTable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "Amonium Cloride")
public class AmoniumCloride extends BasicChemicalIngredient {
    public AmoniumCloride() {
        super("Amonium Cloride", BigDecimal.valueOf(0.60),"NH4CL");
    }
}
