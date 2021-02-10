package fr.polytech.TPRest.Servlet;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="element")

public class Element implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

private int id;
private String nom;

    public Element() {
    }

    public Element(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
