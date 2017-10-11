package entities.TablePerClass;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "mints")
public class Mint extends BasicIngredient {
    public Mint() {
        super("Mint", BigDecimal.valueOf(0.40));
    }
}
