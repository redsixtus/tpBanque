package fr.digi;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;
@Entity
@DiscriminatorValue("V")
public class AssuranceVIe extends Compte implements Serializable {
    @Column(name = "DATE_FIN")
    private LocalDate date_fin;
    @Column(name = "TAUX")
    private Double taux;

    public AssuranceVIe() {
    }

    public AssuranceVIe(LocalDate date_fin, Double taux) {
        this.date_fin = date_fin;
        this.taux = taux;
    }

    public LocalDate getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(LocalDate date_fin) {
        this.date_fin = date_fin;
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "AssuranceVIe{" +
                "date_fin=" + date_fin +
                ", taux=" + taux +
                '}';
    }
}
