package app.entities.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Fresh")
public class FreshNuke extends BasicShampoo {
    public FreshNuke() {
    }

    public FreshNuke(ClassicLabel label) {
        super(label);
    }
}

