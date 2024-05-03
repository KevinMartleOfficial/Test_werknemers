package be.vdab.personeel;

import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Arbeider extends Werknemer{
    private BigDecimal uurloon;
    private final static BigDecimal minUurloon = BigDecimal.valueOf(9.76);
    private static final long serialVersionUID = 1L;


    public Arbeider(int personeelsnummer, WerknemersDatum datumInDienst, String naam, Geslacht geslacht, BigDecimal uurloon) {
        super(personeelsnummer, datumInDienst, naam, geslacht);
        setUurloon(uurloon);
    }

    public BigDecimal getUurloon() {
        return uurloon;
    }

    public void setUurloon(BigDecimal uurloon) {
        if(uurloon.compareTo(minUurloon)>0){
        this.uurloon = uurloon;
        }
            throw new WerknemerException("Uurloon is te laag");
    }

    @Override
    public BigDecimal getVerloning() {
        return (getUurloon().multiply(BigDecimal.valueOf((7.6 * 65) / 3))).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + getUurloon();
    }
}
