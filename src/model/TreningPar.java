package model;

public class TreningPar {

    private double[] ulaz;
    private double[] ocekivaniIzlaz;

    public double[] getUlaz() {
        return ulaz;
    }

    public void setUlaz(double[] ulaz) {
        this.ulaz = ulaz;
    }

    public double[] getOcekivaniIzlaz() {
        return ocekivaniIzlaz;
    }

    public void setOcekivaniIzlaz(double[] ocekivaniIzlaz) {
        this.ocekivaniIzlaz = ocekivaniIzlaz;
    }

    public TreningPar(double[] ulaz, double[] ocekivaniIzlaz) {
        this.ulaz = ulaz;
        this.ocekivaniIzlaz = ocekivaniIzlaz;
    }

    public TreningPar() {
        super();
    }
}
