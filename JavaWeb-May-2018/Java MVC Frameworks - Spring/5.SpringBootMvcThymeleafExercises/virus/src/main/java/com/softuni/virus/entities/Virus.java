package com.softuni.virus.entities;

import com.softuni.virus.entities.enums.VirusMagnitude;
import com.softuni.virus.entities.enums.VirusMutation;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "viruses")
public class Virus {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String sideEffects;

    @Column(nullable = false)
    private String creator;

    @Column(nullable = false)
    private Boolean isDeadly;

    @Column(nullable = false)
    private Boolean isCurable;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VirusMutation mutation;

    @Column(nullable = false)
    private Integer turnoverRate;

    @Column(nullable = false)
    private Integer hoursUntilTurn;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VirusMagnitude magnitude;

    @Column(nullable = false)
    private LocalDate releaseDate;

    @ManyToMany
    @JoinTable(name = "viruses_capitals")
    private List<Capital> capitals;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Boolean getDeadly() {
        return isDeadly;
    }

    public void setDeadly(Boolean deadly) {
        isDeadly = deadly;
    }

    public Boolean getCurable() {
        return isCurable;
    }

    public void setCurable(Boolean curable) {
        isCurable = curable;
    }

    public VirusMutation getMutation() {
        return mutation;
    }

    public void setMutation(VirusMutation mutation) {
        this.mutation = mutation;
    }

    public Integer getTurnoverRate() {
        return turnoverRate;
    }

    public void setTurnoverRate(Integer turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    public Integer getHoursUntilTurn() {
        return hoursUntilTurn;
    }

    public void setHoursUntilTurn(Integer hoursUntilTurn) {
        this.hoursUntilTurn = hoursUntilTurn;
    }

    public VirusMagnitude getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(VirusMagnitude magnitude) {
        this.magnitude = magnitude;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Capital> getCapitals() {
        return capitals;
    }

    public void setCapitals(List<Capital> capitals) {
        this.capitals = capitals;
    }
}
