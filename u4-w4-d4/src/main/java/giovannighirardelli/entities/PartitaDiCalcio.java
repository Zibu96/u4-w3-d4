package giovannighirardelli.entities;

import giovannighirardelli.enums.TipoEvento;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("partita_di_calcio")

public class PartitaDiCalcio extends Evento {
    @Column(name = "squadra_di_casa")
    private String SquadraDiCasa;
    @Column(name = "squadra_ospite")
    private String SquadraOspite;
    @Column(name = "squadra_vincente")
    private String SquadraVincente;
    @Column(name = "gol_squadra_casa")
    private int GolSquadraCasa;
    @Column(name = "gol_squadra_ospiti")
    private int GolSquadraOspite;

    public PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, String squadraDiCasa, String squadraOspite, String squadraVincente, int golSquadraCasa, int golSquadraOspite) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.SquadraDiCasa = squadraDiCasa;
        this.SquadraOspite = squadraOspite;
        this.SquadraVincente = squadraVincente;
        this.GolSquadraCasa = golSquadraCasa;
        this.GolSquadraOspite = golSquadraOspite;
    }

    public String getSquadraDiCasa() {
        return SquadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        SquadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return SquadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        SquadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return SquadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        SquadraVincente = squadraVincente;
    }

    public int getGolSquadraCasa() {
        return GolSquadraCasa;
    }

    public void setGolSquadraCasa(int golSquadraCasa) {
        GolSquadraCasa = golSquadraCasa;
    }

    public int getGolSquadraOspite() {
        return GolSquadraOspite;
    }

    public void setGolSquadraOspite(int golSquadraOspite) {
        GolSquadraOspite = golSquadraOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "SquadraDiCasa='" + SquadraDiCasa + '\'' +
                ", SquadraOspite='" + SquadraOspite + '\'' +
                ", SquadraVincente='" + SquadraVincente + '\'' +
                ", GolSquadraCasa=" + GolSquadraCasa +
                ", GolSquadraOspite=" + GolSquadraOspite +
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
