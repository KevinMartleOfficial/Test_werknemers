package be.vdab.personeel;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bedrijf implements Serializable {


    List<Werknemer>bedrijfslijst = new ArrayList<>();



    public List<Werknemer> getBedrijfslijst() {
        return bedrijfslijst;
    }

    public void voegWerknemerToe(Werknemer werknemer){
        if(!bedrijfslijst.contains(werknemer)){
            bedrijfslijst.add(werknemer);
        }

    }

    public void printLijst(List lijst){
        if(!lijst.isEmpty()){
            lijst.forEach(System.out::println);
        }
    }

    public List gesorteerdeLijst(){
        List<Werknemer> gesorteerdelijst = bedrijfslijst.stream().sorted().toList();
        return gesorteerdelijst;
    }

    public List lijstVanArbeiders(){
        return bedrijfslijst.stream().filter(werknemer -> werknemer instanceof Arbeider).collect(Collectors.toList());
        }


    public double percentageMannelijkeWerknemers(){
        double aantalMannen = bedrijfslijst.stream().filter(werknemer->werknemer.getGeslacht() == Geslacht.M).count();
        return (aantalMannen/ bedrijfslijst.size())*100;
    }

    public void bewaarLijst(){
        try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Path.of("personeel.dat")))){
            oos.writeObject(bedrijfslijst);
        }
        catch(IOException io){
            System.err.println(io.getMessage());
        }
    }


}

