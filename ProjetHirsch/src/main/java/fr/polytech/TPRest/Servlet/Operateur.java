package fr.polytech.TPRest.Servlet;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="operateur")

public class Operateur implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String nom;
    @OneToMany
    @JoinColumn(name = "warframe", referencedColumnName = "id")
    private List<Warframe> warframes;

    public Operateur() {
    }

    public Operateur(int id) {
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
