package model;

import util.Generator;

import static util.Parametri.tezinskiFaktor;

public class Konekcija {

    private String id;
    private Neuron od;
    private Neuron ka;
    private double tezina;

    public Konekcija(Neuron od,Neuron ka){
        id= Generator.getID();
        tezina= Generator.getRandomDoubleNumber(-tezinskiFaktor/10,tezinskiFaktor/10);
        this.od=od;
        this.ka=ka;

    }


    public Neuron getOd() {
        return od;
    }

    public void setOd(Neuron od) {
        this.od = od;
    }

    public Neuron getKa() {
        return ka;
    }

    public void setKa(Neuron ka) {
        this.ka = ka;
    }

    public double getTezina() {
        return tezina;
    }

    public void setTezina(double tezina) {
        this.tezina = tezina;
    }


}
