package fr.polytech.TPRest.Servlet;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "warframe")

public class Warframe implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int id;
	String nom;
    int lvl;
    int atk;
    int def;
    @OneToOne
    @JoinColumn(name = "element", referencedColumnName = "id")
    private Element element;
    @ManyToOne
    @JoinColumn(name = "operateur", referencedColumnName = "id")
    private Operateur operateur;

    public Warframe(){}

    public Warframe(int id, String nom, int lvl, int atk, int def) {
        this.id = id;
        this.nom = nom;
        this.lvl = lvl;
        this.atk = atk;
        this.def = def;
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

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getAtk() {
    	return atk;
    }
    
    public void setAtk(int atk) {
        this.atk = atk;
    }
    
    public int getDef() { return def; }
    
    public void setDef(int def) {
        this.def = def;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Operateur getGeneration() {
        return operateur;
    }

    public void setGeneration(Operateur operateur) {
        this.operateur = operateur;
    }

    @Override
    public String toString() {
        return "Warframe : [nom=" + nom + ", lvl=" + lvl + ", atk =" + atk + ", def =" + def + ']';
    }


}

