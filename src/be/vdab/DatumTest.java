package be.vdab.util;

public class DatumTest {
    public static void main(String[] args) {
        try{
            Datum d1 = new Datum(31,9,2000);
        }
        catch (DatumException de){
            System.err.println(de.getMessage());
        }
//
//        try{
//            Datum d2 = new Datum(12, 13, 1998);
//        }
//        catch(DatumException de){
//            System.err.println(de.getMessage());
//        }
//        try{
//            Datum d3 = new Datum(32, 4, 1995);
//        }
//        catch(DatumException de){
//            System.err.println(de.getMessage());
//        }
//
//        try{
//            Datum d4 = new Datum(0, 11, 1586);
//        }
//        catch(DatumException de){
//            System.err.println(de.getMessage());
//        }
//
        try{
            Datum d5 = new Datum(12, 6, 1583);
        }
        catch(DatumException de){
            System.err.println(de.getMessage());
        }
        try{
            Datum d6 = new Datum(29, 2, 1999);
            System.err.println(d6.isDagVanMaand(d6.getDag(), d6.getMaand()));
        }
        catch(DatumException de){
            System.err.println(de.getMessage());
        }
        try{
            Datum d7 = new Datum(29, 2, 2000);
            System.out.println(d7);
        }
        catch(DatumException de){
            System.err.println(de.getMessage());

        }

    }
}
