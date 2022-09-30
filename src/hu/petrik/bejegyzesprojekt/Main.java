package hu.petrik.bejegyzesprojekt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Bejegyzes> bejegyzesek = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        bejegyzesekHozzaadasa();
        try {
            bejegyzesekFelveteleKonzolrol();
        } catch (NumberFormatException e) {
            System.out.println("A darabszám csak természetes szám lehet.");
        }
        String fajlNev = "bejegyzesek.csv";
        try {
            bejegyzesekFelveteleSzovegesAllomanybol(fajlNev);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR! This file does not exists: " + fajlNev);
        } catch (IOException e) {
            System.out.println("Unknown error");
            System.out.println(e.getMessage());
        }


    }

    private static void bejegyzesekFelveteleSzovegesAllomanybol(String fajlNev) throws IOException {
        FileReader fr = new FileReader(fajlNev);
        BufferedReader br = new BufferedReader(fr);
        String sor = br.readLine();
        while (sor != null && !sor.isEmpty()) {
            String[] adatok = sor.split(";");
            Bejegyzes bejegyzes = new Bejegyzes(adatok[0], adatok[1]);
            bejegyzesek.add(bejegyzes);
            sor = br.readLine();
        }
        br.close();
        fr.close();
    }

    private  static void bejegyzesekFelveteleKonzolrol(){
        System.out.print("Add meg légyszí, hány bejegyzést szeretnél felvenni: ");
        int db = Integer.parseInt(sc.nextLine());
        if (db < 0){
            throw new RuntimeException();
        }
        for (int i = 0; i < db; i++) {
            System.out.printf("Légyszí add meg a(z) %d. bejegyzés szerzőjét:\n", (i + 1));
            String szerzo = sc.nextLine();
            System.out.printf("Légyszí add meg a(z) %d. bejegyzés tartalmát:\n", (i + 1));
            String tartalom = sc.nextLine();
            Bejegyzes bejegyzes = new Bejegyzes(szerzo, tartalom);
            bejegyzesek.add(bejegyzes);
        }
    }


    private static void bejegyzesekHozzaadasa() {
        Bejegyzes bejegyzes1 = new Bejegyzes("Új bejegyzés", "Titkos");
        Bejegyzes bejegyzesek2 = new Bejegyzes("Még egy bejegyzés", "Titkos");
        bejegyzesek.add(bejegyzes1);
        bejegyzesek.add(bejegyzesek2);// write your code here
    }

}

