package model;

import funkcije.AktivacionaFunkcija;
import util.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class Neuron {

    private String id;
    private List<Konekcija> konekcije;
    private List<Konekcija> izlazneKonekcije;
    private double ulaz=0d;
    private double izlaz=0d;




    private AktivacionaFunkcija aktivacionaFunkcija;


    public Neuron(){

        id=Generator.getID();
        konekcije =new ArrayList<>();
        izlazneKonekcije=new ArrayList<>();

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
        izlaz=aktivacionaFunkcija.izracunajVrednost(ulaz);


    }

    /*public void izracunajUlaz(){
    double suma=0d;
    for(Konekcija k:konekcije)suma+=(k.getLink().getIzlaz()*k.getTezina());
     ulaz=suma;
    izlaz=aktivacionaFunkcija.izracunajVrednost(ulaz);


    }*/

    public double getIzlaz() {
        return izlaz;
    }

    public double getUlaz() {
        return ulaz;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Neuron ID: "+id;

    }

    public Konekcija getKonekcija(String id){
    return konekcije.stream().filter(s->s.getLink().getId().equals(id)).findFirst().get();
    }


    public List<Konekcija> getIzlazneKonekcije() {
        return izlazneKonekcije;
    }



    public void izracunajIzlaz() {
        double suma = 0;
        for (Konekcija k : konekcije) {
            double tezina = k.getTezina();
            double izlazNeuronaPrethodnogSloja = k.getLink().getIzlaz();

            suma = suma + (tezina * izlazNeuronaPrethodnogSloja);
        }

        ulaz=suma;
        izlaz = aktivacionaFunkcija.izracunajVrednost(suma);
    }
}
