package model;


import funkcije.AktivacionaFunkcija;
import util.Generator;

import java.util.List;

public class Sloj {

    private String id;
    private List<Neuron> list;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Neuron> getList() {
        return list;
    }

    public void setList(List<Neuron> list) {
        this.list = list;
    }

    public Sloj(String id, List<Neuron> list) {
        this.id = id;
        this.list = list;
    }



    public Sloj(List<Neuron> list) {
        this.list = list;
        id= Generator.getID();
    }


    public void setActivationFunction(AktivacionaFunkcija fja){
        for(Neuron n:list)n.setAktivacionaFunkcija(fja);
    }
}
