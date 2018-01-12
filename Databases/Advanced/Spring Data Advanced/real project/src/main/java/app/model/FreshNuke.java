package app.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by Guest Lector on 17-Jul-17.
 */
@Entity
@DiscriminatorValue(value = "FN")
public class FreshNuke extends BasicShampoos {
    public FreshNuke() {
        this.setPrice(BigDecimal.valueOf(5.40));
        this.setSize(2);
    }
}
