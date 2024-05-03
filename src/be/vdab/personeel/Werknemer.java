package be.vdab.personeel;

import be.vdab.util.Datum;
import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public abstract class Werknemer implements Serializable, Comparable<Werknemer> {
    private final int PERSONEELSNUMMER;
    private WerknemersDatum datumInDienst;
    private String naam;
    private Geslacht geslacht;
    private static final long serialVersionUID = 1L;





    public Werknemer(int personeelsnummer, WerknemersDatum datumInDienst, String naam, Geslacht geslacht) {
        if (personeelsnummer < 1) {
            throw new WerknemerException("Ongeldig personeelsnummer");
        }
        PERSONEELSNUMMER = personeelsnummer;
        setDatumInDienst(datumInDienst);
        setNaam(naam);
        setGeslacht(geslacht);
    }



    public Datum getDatumInDienst() {
        return datumInDienst;
    }

    public void setDatumInDienst(WerknemersDatum datumInDienst) {
        this.datumInDienst = datumInDienst;

}

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        if(!naam.isBlank()) {
            this.naam = naam;
        }
            throw new WerknemerException("Naam moet ingevuld worden");
    }

    public Geslacht getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(Geslacht geslacht) {
        if(!(geslacht ==null)) {
            this.geslacht = geslacht;
        }
            throw new WerknemerException("Kies een geslacht");

    }

    public int getPERSONEELSNUMMER() {
        return PERSONEELSNUMMER;
    }

    public abstract BigDecimal getVerloning();

    @Override
    public int compareTo(Werknemer o) {
      return this.getPERSONEELSNUMMER()-o.getPERSONEELSNUMMER();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Werknemer werknemer)) return false;
        return PERSONEELSNUMMER == werknemer.PERSONEELSNUMMER;
    }



    @Override
    public int hashCode() {
        return Objects.hashCode(PERSONEELSNUMMER);
    }




    @Override
    public String toString(){
        return getPERSONEELSNUMMER() + "\t" +getDatumInDienst() + "\t"+ getNaam() + "\t" + getGeslacht() + "\t" + getVerloning();
    }
}
