package be.vdab.util;

public class WerknemersDatum extends Datum{
    private  final Datum oprichtingsdatum = new Datum(12,2,1977);
    private static final long serialVersionUID = 1L;

    public WerknemersDatum(int dag, int maand, int jaar) {
        super(dag, maand, jaar);

    }

    public boolean isGeldig(WerknemersDatum d){
        if(oprichtingsdatum.compareTo(d)<=0){
            return true;
        }return false;
    }





}
