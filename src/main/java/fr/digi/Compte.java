package fr.digi;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COMPTE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
public class Compte  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="NUMERO" )
    private String numero;
    @Column(name = "SOLDE")
    private Double Solde;

    @ManyToMany(cascade={CascadeType.REMOVE,CascadeType.PERSIST})
    @JoinTable(name = "ClIENT_COMPTE",
            joinColumns = @JoinColumn(name = "ID_COMPT",referencedColumnName = "ID"),
            inverseJoinColumns= @JoinColumn(name = "ID_CLIE",referencedColumnName = "ID"))
    private Set<Client> Clients;

    @OneToMany(mappedBy = "compte",cascade ={CascadeType.REMOVE,CascadeType.PERSIST}
    )
    private Set<Operation> operations;

    {
        this.Clients = new HashSet<>();
        this.operations= new HashSet<>();
    }
    public Compte() {
    }

    public Compte(int id, String numero, Double solde, Set<Client> clients, Set<Operation> operations) {
        this.id = id;
        this.numero = numero;
        Solde = solde;
        Clients = clients;
        this.operations = operations;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    public Compte(String numero, Double solde) {
        this.numero = numero;
        Solde = solde;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getSolde() {
        return Solde;
    }

    public void setSolde(Double solde) {
        Solde = solde;
    }

    public Set<Client> getClients() {
        return Clients;
    }

    public void setClients(Set<Client> clients) {
        Clients = clients;
    }


}