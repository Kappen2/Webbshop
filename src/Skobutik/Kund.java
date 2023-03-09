package Skobutik;

public class Kund {
    protected int id;
    protected String förnamn;
    protected String efternamn;
    protected int personnummer;
    protected String ort;
    protected String lösenord;

    public Kund() {
    }

    public Kund(int id, String förnamn, String efternamn, int personnummer, String ort, String lösenord) {
        this.id = id;
        this.förnamn = förnamn;
        this.efternamn = efternamn;
        this.personnummer = personnummer;
        this.ort = ort;
        this.lösenord = lösenord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFörnamn() {
        return förnamn;
    }

    public void setFörnamn(String förnamn) {
        this.förnamn = förnamn;
    }

    public String getEfternamn() {
        return efternamn;
    }

    public void setEfternamn(String efternamn) {
        this.efternamn = efternamn;
    }

    public int getPersonnummer() {
        return personnummer;
    }

    public void setPersonnummer(int personnummer) {
        this.personnummer = personnummer;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
}
