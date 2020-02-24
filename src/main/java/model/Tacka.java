package model;

import java.util.Objects;

public class Tacka {

    private double x;
    private double y;
    private double z;


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public Tacka(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tacka)) return false;
        Tacka tacka = (Tacka) o;
        return Double.compare(tacka.getX(), getX()) == 0 &&
                Double.compare(tacka.getY(), getY()) == 0 &&
                Double.compare(tacka.getZ(), getZ()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY(), getZ());
    }

    @Override
    public String toString() {
        return "["+String.format("%.4f",x)+","+String.format("%.4f",y)+","+String.format("%.4f",z)+"]";
    }
}
