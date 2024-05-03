package be.vdab.personeel.kader;

import be.vdab.personeel.Bediende;
import be.vdab.personeel.Geslacht;
import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.math.BigDecimal;

public class Kaderlid extends Bediende {

    private Functietitel functietitel;
    private static final long serialVersionUID = 1L;

    public Kaderlid(int personeelsnummer, WerknemersDatum datumInDienst, String naam, Geslacht geslacht, BigDecimal maandwedde, Functietitel functietitel) {
        super(personeelsnummer, datumInDienst, naam, geslacht, maandwedde);
        setFunctietitel(functietitel);
    }

    public Functietitel getFunctietitel() {
        return functietitel;
    }

    public void setFunctietitel(Functietitel functietitel) {
        if (functietitel!=null) {
            this.functietitel = functietitel;
        }
            throw new WerknemerException("Functietitel moet ingevuld worden");

    }

    @Override
    public String toString() {
        return super.toString()+ "\t" + getFunctietitel();
    }
}
