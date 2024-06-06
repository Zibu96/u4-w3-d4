package giovannighirardelli.entities;

import giovannighirardelli.enums.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "evento")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "main_evento")

@NamedQuery(name = "getPartiteVinteInCasa", query = "SELECT p FROM PartitaDiCalcio p Where p.SquadraDiCasa = p.SquadraVincente")
@NamedQuery(name = "getPartiteVinteInTrasferta", query = "SELECT p FROM PartitaDiCalcio p Where p.SquadraOspite = p.SquadraVincente")
public abstract class Evento {
    @Id
    @GeneratedValue
    protected long id;
    @Column(name = "titolo")
    protected String titolo;
    @Column(name = "data_evento")
    protected LocalDate dataEvento;
    @Column(name = "descrizione")
    protected String descrizione;
    @Column(name = "tipo_evento")
    @Enumerated(EnumType.STRING)
    protected TipoEvento tipoEvento;
    @Column(name = "numero_massimo_partecipanti")
    protected int numeroMassimoPartecipanti;
    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    protected Location location;

    @OneToMany(mappedBy = "evento")
    private List<Partecipazione> partecipazioneList;

    public Evento() {
    }

    public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.location = location;
    }

    public long getId() {
        return id;
    }


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Partecipazione> getPartecipazioneList() {
        return partecipazioneList;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                '}';
    }

}
