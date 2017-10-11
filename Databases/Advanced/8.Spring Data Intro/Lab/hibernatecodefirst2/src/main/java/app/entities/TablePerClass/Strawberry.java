package app.entities.TablePerClass;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "strawberies")
public class Strawberry extends BasicIngredient {
    public Strawberry() {
        super("Strawberry", BigDecimal.valueOf(0.50));
    }
}
