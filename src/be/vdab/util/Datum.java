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
        if(isDagVanMaand(dag, maand)){
            this.dag = dag;
        }
        else{
            throw new DatumException("Deze dag bestaat niet");
        }
        setMaand(maand);
        setJaar(jaar);
    }

    public boolean isDagVanMaand(int dag, int maand) {
        if (dag >= 1 && dag <= 31) {
            if(maand ==2|| maand==4||maand==6||maand==9||maand==11){
                if(maand == 2) {
                    if (isSchrikkeljaar(jaar)) {
                        return dag <= 29;

                    }
                    else{
                        return dag <= 28;

                    }
                }
                else{
                    return dag <= 30;
                }
            }
            else {
                return true;
            }
        }return false;
    }

    private void setMaand(int maand){
        if(maand<1 || maand>12){
            this.maand = maand;
        }throw new DatumException("Deze dag bestaat niet");
    }

    private void setJaar(int jaar){
        if(jaar>=1584 && jaar<=4099){
            this.jaar = jaar;
        }
        else{
            throw new DatumException("Ongeldig jaar");
        }
    }





    public boolean isSchrikkeljaar(int jaar){
        if(jaar%400 ==0){
            return true;
        }
        else if (jaar%100==0) {
            return false;
        }
        else if(jaar%4==0){
            return true;

        }return false;
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
        return(this.jaar*10000+this.maand*100+this.dag)-(d.getJaar()*1000+d.getMaand()*100+d.getDag());
    }


//    @Override
//    public int compareTo(Datum d) {
//        if (this.jaar > d.getJaar()) {
//            return 1;
//        } else if (this.jaar < d.getJaar()) {
//            return -1;
//        } else if (this.maand > d.getMaand()) {
//            return 1;
//        } else if (this.maand < d.getMaand()) {
//            return -1;
//        } else if (this.dag > d.getDag()) {
//            return 1;
//        } else if (this.dag < d.getDag()) {
//            return -1;
//        } else {
//            return 0;
//        }
//    }






}
