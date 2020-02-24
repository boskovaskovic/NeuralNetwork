package model;

import java.util.ArrayList;
import java.util.List;

public class TreningLista {

    List<TreningPar> parovi;

    public TreningLista(){

        parovi=new ArrayList<>();


    }

    public List<TreningPar> getParovi() {
        return parovi;
    }

    public void setParovi(List<TreningPar> parovi) {
        this.parovi = parovi;
    }

    public void addPar(TreningPar par){
        parovi.add(par);


    }
}
