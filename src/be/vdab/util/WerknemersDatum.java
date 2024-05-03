package be.vdab.util;

public class WerknemersDatum extends Datum{
    private  final Datum oprichtingsdatum = new Datum(12,2,1977);
    private static final long serialVersionUID = 1L;

    public WerknemersDatum(int dag, int maand, int jaar) {
        super(dag, maand, jaar);
        testDatum(dag, maand, jaar);

    }

    public void testDatum(int dag, int maand, int jaar){
        if(oprichtingsdatum.compareTo(new Datum(dag, maand, jaar))<0){
            throw new WerknemerException("Kan niet starten voor oprichtingsdatum");
        }

    }







}
