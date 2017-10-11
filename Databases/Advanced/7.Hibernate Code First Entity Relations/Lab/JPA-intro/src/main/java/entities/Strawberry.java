package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "Strawberry")
public class Strawberry extends BasicIngredient {
    public Strawberry() {
        super("Strawberry", BigDecimal.valueOf(0.50));
    }
}
