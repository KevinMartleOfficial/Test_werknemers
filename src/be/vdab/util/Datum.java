package be.vdab.util;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Datum implements IDatum, Serializable,  Comparable<Datum> {
    private  int dag;
    private  int maand;
    private  int jaar;
    private static final long serialVersionUID = 1L;


    public Datum(int dag, int maand, int jaar){
        setDag(dag);
        setMaand(maand);
        setJaar(jaar);
    }


    private void setDag(int dag) {
        if (dag < 1 || dag > 31) {
            throw new DatumException("Dag moet tussen 1 en 31 liggen.");
        }
        if ((maand == 4 || maand == 6 || maand == 9 || maand == 11) && dag > 30) {
            throw new DatumException("Maand kan maar 30 dagen hebben");
        }
        if (maand == 2 && !isSchrikkeljaar() && dag > 28) {
            throw new DatumException("Het is geen schrikkeljaar, maand kan maar 28 dagen hebben");
        }
        if (maand == 2 && isSchrikkeljaar() && dag > 29) {
            throw new DatumException("Het is een schrikkeljaar, maand is maximum 29 dagen");
        }
        this.dag = dag;
    }




        private void setMaand(int maand){
        if(maand>=1 && maand<=12){
            this.maand = maand;
        } throw new DatumException("Deze dag bestaat niet ");

    }

    private void setJaar(int jaar){
        if(jaar>=1584 && jaar<=4099){
            this.jaar = jaar;
        } throw new DatumException("Ongeldig jaar");

    }

    public boolean isSchrikkeljaar(){
        return (jaar % 4 == 0) && ((jaar % 100 != 0) || (jaar % 400 == 0));
        }

    @Override
    public int getDag() {
        return dag;
    }

    @Override
    public int getMaand() {
        return maand;
    }

    @Override
    public int getJaar() {
        return jaar;
    }

    @Override
    public String toString() {
        return getDag() + "/"+getMaand()+"/"+getJaar();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Datum datum)) return false;
        return dag == datum.dag && maand == datum.maand && jaar == datum.jaar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dag, maand, jaar);
    }

    @Override
    public int compareTo(Datum d){
        return(this.jaar*10000+this.maand*100+this.dag)-(d.getJaar()*10000+d.getMaand()*100+d.getDag());
    }









}
