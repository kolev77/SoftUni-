package entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "kittens")
public class Kitten {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    public String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private KittenBreed breed;

    public Kitten() {
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public KittenBreed getBreed() {
        return breed;
    }

    public void setBreed(KittenBreed breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"kitten col-md-4 justify-content-md-center\" style=\"text-align:center;\" >\n" +
                "                <img src=\"" + KittenBreed.getSimpleValue(this.breed) + ".jpg\" class=\"img-thumbnail\" style=\"\n" +
                "    height: 250pt; width: 230pt;\n" +
                "\">\n" +
                "                <h6 class=\"text-center\">Name: " + this.getName() + "</h6>\n" +
                "                <h6 class=\"text-center\">Age: " + this.getAge() + "</h6>\n" +
                "                <h6 class=\"text-center\">Breed: " + KittenBreed.getComplexValue(this.getBreed()) + "</h6>\n" +
                "            </div>");
        return sb.toString();
    }
}

