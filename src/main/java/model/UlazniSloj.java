package model;

import java.util.List;

public class UlazniSloj extends Sloj {

    public UlazniSloj(List<Neuron> list) {
        super(list);
    }

    public void setUlaz(TreningPar par){

        for(int i=0;i<list.size();i++) {

            list.get(i).setUlaz(par.getUlaz()[i]);
        }

    }
}
