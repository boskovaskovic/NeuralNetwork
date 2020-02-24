package model;

import util.Generator;

import static main.Main.tezinskiFaktor;

public class Konekcija {

    private String id;
    private Neuron link;
    private double tezina = 0;
    private double deltaFaktor = 0;
    private double prethodniDeltaFaktor = 0;

    public String getId() {
        return id;
    }

    public Konekcija(Neuron link){
        id= Generator.getID();
        tezina= Generator.getRandomDoubleNumber(-tezinskiFaktor/10,tezinskiFaktor/10);
        this.link=link;

    }

    public double getDeltaFaktor() {
        return deltaFaktor;
    }

    public double getPrethodniDeltaFaktor() {
        return prethodniDeltaFaktor;
    }

    public void setPrethodniDeltaFaktor(double prethodniDeltaFaktor) {
        this.prethodniDeltaFaktor = prethodniDeltaFaktor;
    }

    public void setDeltaFaktor(double deltaFaktor) {
        prethodniDeltaFaktor=deltaFaktor;
        this.deltaFaktor = deltaFaktor;
    }


    public Neuron getLink() {
        return link;
    }

    public void setLink(Neuron link) {
        this.link = link;
    }

    public double getTezina() {
        return tezina;
    }

    public void setTezina(double tezina) {
    //    System.out.println("stara tezina "+this.tezina+" a nova je: "+tezina);
        this.tezina = tezina;

    }


}
