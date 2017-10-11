package app.entities;

import javax.persistence.*;

@Entity
@Table(name = "labels")
public class ClassicLabel {
    @Id
    @Column(name = "label_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private String name;

    @OneToOne
    private BasicShampoo basicShampoo;

    public ClassicLabel() {
    }

    public ClassicLabel(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClassicLabel{" +
                "name='" + name + '\'' +
                '}';
    }
}
