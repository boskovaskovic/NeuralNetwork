package model;

import funkcije.AktivacionaFunkcija;
import util.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class Neuron {

    private String id;
    private List<Konekcija> konekcije;
    private double ulaz=0d;


    private AktivacionaFunkcija aktivacionaFunkcija;


    public Neuron(){

        id=Generator.getID();
        konekcije =new ArrayList<>();

    }

    public List<Konekcija> getKonekcije() {
        return konekcije;
    }

    public void setKonekcije(List<Konekcija> konekcije) {
        this.konekcije = konekcije;
    }


    public AktivacionaFunkcija getAktivacionaFunkcija() {
        return aktivacionaFunkcija;
    }

    public void setAktivacionaFunkcija(AktivacionaFunkcija aktivacionaFunkcija) {
        this.aktivacionaFunkcija = aktivacionaFunkcija;
    }



    public void addKonekcija(Konekcija konekcija){
        konekcije.add(konekcija);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Neuron)) return false;
        Neuron neuron = (Neuron) o;
        return Objects.equals(id, neuron.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setUlaz(double ulaz) {
        this.ulaz=ulaz;

    }
}
