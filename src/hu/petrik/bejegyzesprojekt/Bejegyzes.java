package hu.petrik.bejegyzesprojekt;

import java.time.LocalDateTime;

public class Bejegyzes {

    private String szerzo;
    private String tartalom;
    private int likeok;
    private LocalDateTime letrejott;
    private LocalDateTime szerkesztve;

    public Bejegyzes(String szerzo, String tartalom) {
        this.szerzo = szerzo;
        this.tartalom = tartalom;
        this.likeok = 0;
        this.letrejott = letrejott;
        this.szerkesztve = szerkesztve;
    }

    public String getSzerzo() {
        return szerzo;
    }

    public String getTartalom() {
        return tartalom;
    }

    public int getLikeok() {
        return likeok;
    }

    public LocalDateTime getLetrejott() {
        return letrejott;
    }

    public LocalDateTime getSzerkesztve() {
        return szerkesztve;
    }

    public void setTartalom(String tartalom) {
        this.tartalom = tartalom;
    }

    public void like() {
        likeok += 1;
    }

    @Override
    public String toString() {
        return "Bejegyzes{" +
                "szerzo='" + szerzo + '\'' +
                ", tartalom='" + tartalom + '\'' +
                ", likeok=" + likeok +
                ", letrejott=" + letrejott +
                ", szerkesztve=" + szerkesztve +
                '}';
    }



}
