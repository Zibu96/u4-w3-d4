package giovannighirardelli.dao;

import giovannighirardelli.entities.Persona;
import giovannighirardelli.exeptions.NotFoundExceptionStr;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PersonaDAO {
    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Persona persona) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(persona);
        transaction.commit();
        System.out.println("La persona " + persona.getNome() + " è stato aggiunta con successo");
    }

    public Persona findById(String personaId) {
        Persona persona = em.find(Persona.class, UUID.fromString(personaId));
        if (persona == null) throw new NotFoundExceptionStr(personaId);
        return persona;
    }

    public void findByIdAndDelete(String personaId) {
        Persona found = this.findById(personaId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("La persona " + found.getNome() + "è stata eliminata DEFINITIVAMENTE");

    }
}
