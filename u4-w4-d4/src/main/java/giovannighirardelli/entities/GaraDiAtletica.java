package giovannighirardelli.entities;

import giovannighirardelli.enums.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@DiscriminatorValue("gara_di_atletica")
public class GaraDiAtletica extends Evento {
    @ManyToMany
    @JoinTable(name = "atletica_persone",
            joinColumns = @JoinColumn(name = "gara_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "persona_id", nullable = false)
    )
    private Set<Persona> atleti;
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona vincitore;

    public GaraDiAtletica() {
    }

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, Set<Persona> atleti, Persona vincitore) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "atleti=" + atleti +
                ", vincitore=" + vincitore +
                ", id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                ", location=" + location +
                '}';
    }
}
