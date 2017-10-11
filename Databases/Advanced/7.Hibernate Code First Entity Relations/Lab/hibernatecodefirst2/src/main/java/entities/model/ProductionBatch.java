package entities.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "production_batch")
public class ProductionBatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "batch_id")
    private Set<BasicShampoo> shampoos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<BasicShampoo> getShampoos() {
        return shampoos;
    }

    public void setShampoos(Set<BasicShampoo> shampoos) {
        this.shampoos = shampoos;
    }

    @Override
    public String toString() {
        return "ProductionBatch{" +
                "id=" + id +
                ", shampoos=" + shampoos +
                '}';
    }
}
