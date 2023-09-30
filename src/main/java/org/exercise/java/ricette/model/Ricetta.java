package org.exercise.java.ricette.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
@Table(name = "ricette")
public class Ricetta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String ingredients;
    private String prepTime;
    private String recepe;
    @Column(length = 500)
    private String fotoLink;
    @NotNull
    private int portions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    public String getRecepe() {
        return recepe;
    }

    public void setRecepe(String recepe) {
        this.recepe = recepe;
    }

    public int getPortions() {
        return portions;
    }

    public void setPortions(int portions) {
        this.portions = portions;
    }

    public String getFotoLink() {
        return fotoLink;
    }

    public void setFotoLink(String fotoLink) {
        this.fotoLink = fotoLink;
    }
}
