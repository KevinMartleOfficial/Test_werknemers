package be.vdab.util;

public class DatumException extends RuntimeException{

    private String omschrijving;

    public DatumException(){};

    public DatumException(String omschrijving){
        super(omschrijving);
    }

}
