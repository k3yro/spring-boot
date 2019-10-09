package de.k3yro.mavenDemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "abteilungen")
public class Abteilung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Boolean deleted;

    public Abteilung() {

    }

    public Abteilung(String name) {
        this.name = name;
        this.deleted = deleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
