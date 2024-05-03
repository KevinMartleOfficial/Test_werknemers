package be.vdab;

import be.vdab.personeel.Arbeider;
import be.vdab.personeel.Bediende;
import be.vdab.personeel.Bedrijf;
import be.vdab.personeel.Geslacht;
import be.vdab.personeel.kader.Functietitel;
import be.vdab.personeel.kader.Kaderlid;
import be.vdab.util.DatumException;
import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.math.BigDecimal;
import java.rmi.ServerError;

public class BedrijfApp {
    public static void main(String[] args) {
        Bedrijf vdab = new Bedrijf();
        try {
            vdab.voegWerknemerToe(new Arbeider(10, new WerknemersDatum(29, 2, 2022), "Dieter", Geslacht.M, BigDecimal.valueOf(17.5)));
        }
        catch(DatumException| WerknemerException e){
            System.err.println(e.getMessage());
        }
        try {
            vdab.voegWerknemerToe(new Kaderlid(45, new WerknemersDatum(29, 2, 2000), "Anne-Marie", Geslacht.V, BigDecimal.valueOf(4500), Functietitel.CEO));
        }
        catch(DatumException| WerknemerException e){
            System.err.println(e.getMessage());
        }
        try {
            vdab.voegWerknemerToe(new Arbeider(12, new WerknemersDatum(31, 4, 1977), "Josephine", Geslacht.V, BigDecimal.valueOf(19.2)));
        }
        catch(DatumException| WerknemerException e){
            System.err.println(e.getMessage());
        }
        try {
            vdab.voegWerknemerToe(new Bediende(53, new WerknemersDatum(12, 11, 1975), "Adam", Geslacht.M, BigDecimal.valueOf(2850)));
        }
        catch(DatumException| WerknemerException e){
            System.err.println(e.getMessage());
        }
        try {
            vdab.voegWerknemerToe(new Kaderlid(259, new WerknemersDatum(1, 1, 2001), "Piet", Geslacht.M, BigDecimal.valueOf(100), Functietitel.MANAGER));
        }
        catch(DatumException| WerknemerException e){
            System.err.println(e.getMessage());
        }
        try {
            vdab.voegWerknemerToe(new Bediende(75, new WerknemersDatum(12, 12, 2012), "Karen", Geslacht.V, BigDecimal.valueOf(2400)));
        }
        catch(DatumException| WerknemerException e){
            System.err.println(e.getMessage());
        }
        System.out.println("Lijst van werknemers:");
        vdab.printLijst(vdab.getBedrijfslijst());
        System.out.println("Percentage mannelijke werknemers:");
        System.out.println(vdab.percentageMannelijkeWerknemers());
        System.out.println("Gesorteerde lijst:");
        vdab.printLijst(vdab.gesorteerdeLijst());
        System.out.println("Lijst van arbeiders:");
        vdab.printLijst(vdab.lijstVanArbeiders());

        vdab.bewaarLijst();


    }




}
