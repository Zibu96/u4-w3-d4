package giovannighirardelli.dao;

import giovannighirardelli.entities.Partecipazione;
import giovannighirardelli.exeptions.NotFoundExceptionStr;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PartecipazioneDAO {
    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Partecipazione partecipazione) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(partecipazione);
        transaction.commit();
        System.out.println("La partecipazione " + partecipazione.getPersona() + " è stato aggiunta con successo");
    }

    public Partecipazione findById(String partecipazioneId) {
        Partecipazione partecipazione = em.find(Partecipazione.class, UUID.fromString(partecipazioneId));
        if (partecipazione == null) throw new NotFoundExceptionStr(partecipazioneId);
        return partecipazione;
    }

    public void findByIdAndDelete(String partecipazioneId) {
        Partecipazione found = this.findById(partecipazioneId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("La partecipazione " + found.getPersona() + "è stata eliminata DEFINITIVAMENTE");

    }
}
