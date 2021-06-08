package fr.digi;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("B")
public class Virement extends Operation implements Serializable {

    @Column(name = "BENEF")
    private String beficiaire;





    public Virement(int id, LocalDateTime date, Double montant, String motif, Compte compte, String beficiaire) {
        super(id, date, montant, motif, compte);
        this.beficiaire = beficiaire;
    }

    public Virement(LocalDateTime date, Double montant, String motif, String beficiaire) {
        super(date, montant, motif);
        this.beficiaire = beficiaire;
    }

    public Virement(String motif, Compte compte, String beficiaire) {
        super(motif, compte);
        this.beficiaire = beficiaire;
    }

    public Virement() {

    }


    public String getBeficiaire() {
        return beficiaire;
    }

    public void setBeficiaire(String beficiaire) {
        this.beficiaire = beficiaire;
    }

    @Override
    public String toString() {
        return "Virement{" +
                "beficiaire='" + beficiaire + '\'' +
                '}';
    }
}
