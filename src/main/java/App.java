import fr.digi.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {



        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        //Compte guillaume =new Compte("123456789",2000.3);
        //Set<Compte> compte = new HashSet<>();
        //compte.add(guillaume);
        //Client client1= new Client("Obiwan","Kenobi",LocalDate.of(1999,6,19),new Adresse(40,"rue jules verne",44000,"nantes"),compte);
        //Client client2 = new Client ("Luke","Skywalker",LocalDate.of(1990,12,25),new Adresse(10,"rue de la paix",44000,"nantes"),compte);
       //em.persist(client1);
        //em.persist(client2);
        Client client = new Client ("cousin","dimitri",LocalDate.of(1991,2,14),new Adresse(8,"rue columelle",44000,"nantes"));
        Compte compte = new Compte("1234567789",2000.3);
        Compte assuranceVie = new AssuranceVIe(LocalDate.of(2025,5,14),18.5);
        Compte livreA = new LivretA("4244455",300.3,1.2);
        Banque banque1 = new Banque("Bank of America");
        Operation op1 = new Virement("loyer",compte,"agence imo");
        Operation op2 = new Operation(LocalDateTime.now(),120.23,"debie musique",compte);

        client.getComptes().add(livreA);
        client.getComptes().add(compte);
        banque1.getClients().add(client);

        client.setBanque(banque1);
        client.getComptes().add(assuranceVie);
        compte.getOperations().add(op1);
        //op1.setCompte(compte);
        compte.getOperations().add(op2);
       // op2.setCompte(compte);
        em.persist(compte);
        em.persist(client);
        em.getTransaction().commit();


        em.close();
        emf.close();

    }
}
