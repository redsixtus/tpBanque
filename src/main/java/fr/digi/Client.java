package fr.digi;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CLIENT")

public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="NOM")
    private String nom;
    @Column(name = "PRENOM")
    private String prenom;
    @Column(name = "DATE_NAISSANCE")
    private LocalDate date_naissance;
    @Embedded
    private Adresse adresse;

    @ManyToMany(cascade={CascadeType.REMOVE,CascadeType.PERSIST})
    @JoinTable(name = "ClIENT_COMPTE",
            joinColumns = @JoinColumn(name = "ID_CLIE",referencedColumnName = "ID"),
            inverseJoinColumns= @JoinColumn(name = "ID_COMPT",referencedColumnName = "ID"))
    private Set<Compte> Comptes;


    @ManyToOne(cascade={CascadeType.REMOVE,CascadeType.PERSIST})
    @JoinColumn(name="ID_BANQUE")
    private Banque banque;

    {
        this.Comptes= new HashSet<>();


    }


    public Client(String nom, String prenom, LocalDate date_naissance, Adresse adresse, Set<Compte> comptes) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.adresse = adresse;
        Comptes = comptes;
    }

    public Client(String nom, String prenom, LocalDate date_naissance, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.adresse = adresse;
    }

    public Client(String nom, String prenom, LocalDate date_naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
    }

    public Client() {

    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(LocalDate date_naissance) {
        this.date_naissance = date_naissance;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Set<Compte> getComptes() {
        return Comptes;
    }

    public void setComptes(Set<Compte> comptes) {
        Comptes = comptes;
    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", date_naissance=" + date_naissance +
                ", adresse=" + adresse +
                ", Comptes=" + Comptes +
                ", banque=" + banque +
                '}';
    }
}
