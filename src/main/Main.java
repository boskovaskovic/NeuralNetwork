package main;

import factory.NeuronFactory;
import funkcije.LinearnaFunkcija;
import funkcije.SigmoidnaFunkcija;
import model.*;

public class Main {

    public static void main(String...args){

        Sloj ulazni =new Sloj(NeuronFactory.getNeuron(2));
        Sloj skriveni=new Sloj(NeuronFactory.getNeuron(4));
        Sloj izlazni=new Sloj(NeuronFactory.getNeuron(2));

        ulazni.setActivationFunction(new LinearnaFunkcija());
        skriveni.setActivationFunction(new SigmoidnaFunkcija());

        KMenadzer menadzer=new KMenadzer();
        menadzer.konektuj(ulazni,skriveni);


        TreningPar par1=new TreningPar(new double[]{1,1},new double[]{1,0});
        TreningPar par2=new TreningPar(new double[]{0.1,1},new double[]{0,1});

        TreningLista lista=new TreningLista();
        lista.addPar(par1);
        lista.addPar(par2);


    }


}
