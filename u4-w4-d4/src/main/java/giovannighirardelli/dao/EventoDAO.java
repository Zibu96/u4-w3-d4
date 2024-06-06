package giovannighirardelli.dao;

import giovannighirardelli.entities.Concerto;
import giovannighirardelli.entities.Evento;
import giovannighirardelli.entities.PartitaDiCalcio;
import giovannighirardelli.exeptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EventoDAO {


    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("L'evento " + evento.getTitolo() + " è stato aggiunto con successo");
    }

    public Evento findById(long eventoId) {
        Evento evento = em.find(Evento.class, eventoId);
        if (evento == null) throw new NotFoundException(eventoId);
        return evento;
    }

    public void findByIdAndDelete(long eventoId) {
        Evento found = this.findById(eventoId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("L'evento " + found.getTitolo() + "è stato eliminato DEFINITIVAMENTE");

    }

    public List<Concerto> getConcertiInStreaming(boolean bol) {
        TypedQuery<Concerto> query = em.createQuery("SELECT c From Concerto c Where c.inStreaming = :bol", Concerto.class);
        query.setParameter("bol", bol);
        return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(String gen) {
        TypedQuery<Concerto> query = em.createQuery("SELECT c From Concerto c Where c.genere = UPPER(:gen)", Concerto.class);
        query.setParameter("gen", gen);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa() {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("getPartiteVinteInCasa", PartitaDiCalcio.class);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("getPartiteVinteInTrasferta", PartitaDiCalcio.class);
        return query.getResultList();
    }
}
