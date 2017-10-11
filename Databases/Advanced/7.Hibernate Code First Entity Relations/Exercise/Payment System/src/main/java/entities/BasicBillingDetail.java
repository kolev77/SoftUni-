package entities;

import javax.persistence.*;
import java.security.acl.Owner;

@Entity
@Table(name = "billing_details")


//Table per subclass
@Inheritance(strategy = InheritanceType.JOINED)


//    Table per  concrete class strategy
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)


// Single table strategy
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "type",discriminatorType = DiscriminatorType.STRING)

public abstract class BasicBillingDetail implements BillingDetail{
    private Long id;

    private String number;

    private User owner;

    public BasicBillingDetail() {
    }

    @Id
//    Table per  class strategy //    Table per  concrete class strategy
    @GeneratedValue(strategy = GenerationType.TABLE)

 // Single table strategy
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
