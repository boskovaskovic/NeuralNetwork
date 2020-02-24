package model;


import funkcije.AktivacionaFunkcija;
import util.Generator;

import java.util.List;

public class Sloj {

    protected String id;
    protected List<Neuron> list;



    public Sloj(List<Neuron> list) {
        this.list = list;
        id= Generator.getID();
    }


   public void setActivationFunction(AktivacionaFunkcija fja){
        for(Neuron n:list)n.setAktivacionaFunkcija(fja);
    }

   /* public void propagacijaUnapred(){
        for(Neuron n:list)n.izracunajUlaz();
    }*/

    public List<Neuron> getList() {
        return list;
    }

    public void setList(List<Neuron> list) {
        this.list = list;
    }


    public void propagacijaUnapred(){
        list.forEach(s->s.izracunajIzlaz());
    }

    public String getIzlaz(){

        StringBuffer buffer=new StringBuffer();
        for(Neuron n:list)buffer.append(String.format("%.4f",n.getIzlaz())+",");
        return buffer.toString();

    }
}
