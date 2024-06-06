package giovannighirardelli;

import giovannighirardelli.dao.EventoDAO;
import giovannighirardelli.dao.LocationDAO;
import giovannighirardelli.dao.PartecipazioneDAO;
import giovannighirardelli.dao.PersonaDAO;
import giovannighirardelli.entities.Concerto;
import giovannighirardelli.entities.Location;
import giovannighirardelli.entities.PartitaDiCalcio;
import giovannighirardelli.enums.Genere;
import giovannighirardelli.enums.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        System.out.println("Hello World!");
        EntityManager em = emf.createEntityManager();
        EventoDAO ed = new EventoDAO(em);
        PersonaDAO pd = new PersonaDAO(em);
        PartecipazioneDAO ptd = new PartecipazioneDAO(em);
        LocationDAO ld = new LocationDAO(em);


        Location locFromDb = ld.findById("a8a4ebb5-ead0-412f-a186-84ec78c792dc");

        PartitaDiCalcio partita = new PartitaDiCalcio("derby di ritorno", LocalDate.now().plusMonths(1), "derby della Mole di ritorno", TipoEvento.PUBBLICO, 42000, locFromDb, "Torino", "Juventus", "Juventus", 0, 1);
        Concerto concerto = new Concerto("Concertone", LocalDate.now(), "concerto", TipoEvento.PUBBLICO, 400, locFromDb, Genere.POP, false);

//        ed.save(partita);
        ed.getConcertiInStreaming(true).forEach(System.out::println);
        ed.getConcertiInStreaming(false).forEach(System.out::println);

        ed.getConcertiPerGenere("rock").forEach(System.out::println);
        ed.getConcertiPerGenere("pop").forEach(System.out::println);

        ed.getPartiteVinteInCasa().forEach(System.out::println);
        System.out.println("partite vinte in trasferta");
        ed.getPartiteVinteInTrasferta().forEach(System.out::println);
    }


}
