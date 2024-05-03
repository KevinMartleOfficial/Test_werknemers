package be.vdab;

import be.vdab.personeel.Bedrijf;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Zusterbedrijf {
    public static void main(String[] args) {
        Bedrijf zusterbedrijf = new Bedrijf();
        if(Files.exists(Path.of("personeel.dat"))){
            try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Path.of("personeel.dat")))){
                zusterbedrijf.printLijst((List) ois.readObject());
            }
            catch(IOException | ClassNotFoundException io){
                System.err.println(io.getMessage());
            }
        }

    }
}
