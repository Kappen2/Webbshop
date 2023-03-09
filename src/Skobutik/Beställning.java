package Skobutik;

public class Beställning {
    protected int id;
    protected String datum;
    protected double belopp;
    protected int kundId;

    public Beställning() {
    }

    public Beställning(int id, String datum, double belopp, int kundId) {
        this.id = id;
        this.datum = datum;
        this.belopp = belopp;
        this.kundId = kundId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public double getBelopp() {
        return belopp;
    }

    public void setBelopp(double belopp) {
        this.belopp = belopp;
    }

    public int getKundId() {
        return kundId;
    }

    public void setKundId(int kundId) {
        this.kundId = kundId;
    }
}
