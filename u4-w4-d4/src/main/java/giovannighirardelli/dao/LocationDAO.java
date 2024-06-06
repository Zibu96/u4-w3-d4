package giovannighirardelli.dao;

import giovannighirardelli.entities.Location;
import giovannighirardelli.exeptions.NotFoundExceptionStr;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
        System.out.println("La location " + location.getNome() + " è stato aggiunta con successo");
    }

    public Location findById(String locationId) {
        Location location = em.find(Location.class, UUID.fromString(locationId));
        if (location == null) throw new NotFoundExceptionStr(locationId);
        return location;
    }

    public void findByIdAndDelete(String locationId) {
        Location found = this.findById(locationId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("La location " + found.getNome() + "è stata eliminata DEFINITIVAMENTE");

    }
}
