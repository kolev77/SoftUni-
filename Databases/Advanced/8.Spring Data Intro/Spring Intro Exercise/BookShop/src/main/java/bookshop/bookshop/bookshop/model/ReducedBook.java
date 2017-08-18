package bookshop.bookshop.bookshop.model;

import java.math.BigDecimal;

public interface ReducedBook {

    String getTitle();

    void setTitle(String title);

    EditionType getEditionType();

    void setEditionType(EditionType editionType);

    AgeRestriction getAgeRestriction();

    void setAgeRestriction(AgeRestriction ageRestriction);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);


}