package model;

import java.util.Arrays;

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

    @Override
    public String toString() {
        StringBuffer buffer=new StringBuffer();
        buffer.append("Ulaz: [");
        for(double d:ulaz)buffer.append(d+",");
        buffer.append("] Ocekivani Izlaz: [");
        for(double d:ocekivaniIzlaz)buffer.append(d+",");
        buffer.append("]");
        return buffer.toString();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreningPar)) return false;
        TreningPar par = (TreningPar) o;
        return Arrays.equals(getUlaz(), par.getUlaz()) &&
                Arrays.equals(getOcekivaniIzlaz(), par.getOcekivaniIzlaz());
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(getUlaz());
        result = 31 * result + Arrays.hashCode(getOcekivaniIzlaz());
        return result;
    }
}
