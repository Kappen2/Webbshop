package Skobutik;

public class Produkt {
    protected int id;
   protected int pris;
   protected int storlek;
   protected int antal;
   protected String märke;
   protected String färg;

    public Produkt() {
    }

    public Produkt(int id, int pris, int storlek, int antal, String märke, String färg) {
        this.id = id;
        this.pris = pris;
        this.storlek = storlek;
        this.antal = antal;
        this.märke = märke;
        this.färg = färg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public int getStorlek() {
        return storlek;
    }

    public void setStorlek(int storlek) {
        this.storlek = storlek;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public String getMärke() {
        return märke;
    }

    public void setMärke(String märke) {
        this.märke = märke;
    }

    public String getFärg() {
        return färg;
    }

    public void setFärg(String färg) {
        this.färg = färg;
    }
}
