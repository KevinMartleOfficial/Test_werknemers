package be.vdab.personeel;

import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.math.BigDecimal;

public class Bediende extends Werknemer{
    private BigDecimal maandwedde;
    private final BigDecimal minMaandwedde = BigDecimal.valueOf(1129.47);
    private static final long serialVersionUID = 1L;


    public Bediende(int personeelsnummer, WerknemersDatum datumInDienst, String naam, Geslacht geslacht, BigDecimal maandwedde) {
        super(personeelsnummer, datumInDienst, naam, geslacht);
        setMaandwedde(maandwedde);
    }

    public BigDecimal getMaandwedde() {
        return maandwedde;
    }

    public void setMaandwedde(BigDecimal maandwedde) {
        if(maandwedde.compareTo(minMaandwedde)>0) {
            this.maandwedde = maandwedde;
        }
            throw new WerknemerException("Dit is minder dan het minimum maandloon!!");

    }

    @Override
    public BigDecimal getVerloning() {
        return getMaandwedde();
    }

    @Override
    public String toString(){
        return super.toString() + "\t" + getMaandwedde();
    }
}
