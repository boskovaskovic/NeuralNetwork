package model;

import main.Main;
import util.Generator;
import util.Parametri;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static main.Main.tezinskiFaktor;

public class NeuralnaMreza {

    private String id;
    private UlazniSloj ulazniSloj;
    private Sloj izlazniSloj;
    private List<Sloj> skriveniSlojevi;
    private TreningLista lista;
    private HashMap<TreningPar,String> rezultat;
    private final double momentum = 0.2f;


    public NeuralnaMreza(UlazniSloj ulazniSloj, Sloj izlazniSloj) {
        this.ulazniSloj = ulazniSloj;
        this.izlazniSloj = izlazniSloj;
        skriveniSlojevi=new ArrayList<>();
        id= Generator.getID();
        rezultat=new HashMap<>();


    }

    public Sloj getUlazniSloj() {
        return ulazniSloj;
    }

    public void setUlazniSloj(UlazniSloj ulazniSloj) {
        this.ulazniSloj = ulazniSloj;
    }

    public Sloj getIzlazniSloj() {
        return izlazniSloj;
    }

    public void setIzlazniSloj(Sloj izlazniSloj) {
        this.izlazniSloj = izlazniSloj;
    }

    public List<Sloj> getSkriveniSlojevi() {
        return skriveniSlojevi;
    }

    public void setSkriveniSlojevi(List<Sloj> skriveniSlojevi) {
        this.skriveniSlojevi = skriveniSlojevi;
    }

    public void addSkriveniSloj(Sloj sloj){

        skriveniSlojevi.add(sloj);

    }

    public TreningLista getLista() {
        return lista;
    }

    public void setLista(TreningLista lista) {
        this.lista = lista;
    }

    public void konektuj(){

        //konektujemo sve slojeve//

    KMenadzer.konektuj(ulazniSloj,skriveniSlojevi.get(0));
    for(int i=0;(i+1)<skriveniSlojevi.size();i++){
    System.out.print("bole");
    KMenadzer.konektuj(skriveniSlojevi.get(i),skriveniSlojevi.get(i+1));

    }
    KMenadzer.konektuj(skriveniSlojevi.get(skriveniSlojevi.size()-1),izlazniSloj);

    }



    private void propagacijaUnazad(TreningPar par){

        int i = 0;
        for (Neuron n:izlazniSloj.getList()) {
            List<Konekcija> connections = n.getKonekcije();
            for (Konekcija k : connections) {

                double greskaIzlaza=par.getOcekivaniIzlaz()[i]-n.getIzlaz();
                double deltaFaktor=greskaIzlaza*n.getAktivacionaFunkcija().izracunajVrednostIzvoda(n.getUlaz());
                k.setDeltaFaktor(deltaFaktor);
                double korekcijaFaktora= Main.tezinskiFaktor*deltaFaktor*k.getLink().getIzlaz();
                double novaVrednost=k.getTezina()+korekcijaFaktora;
                k.setTezina(novaVrednost+momentum*k.getPrethodniDeltaFaktor());


               /* double ak = n.getIzlaz();
                double ai = con.getLink().getIzlaz();
                double desiredOutput = par.getOcekivaniIzlaz()[i];

                double partialDerivative  = -ak * (1 - ak) * ai * (desiredOutput - ak);//-ak * (1 - ak) * ai * (desiredOutput - ak);
                double deltaWeight = -learningRate * partialDerivative;
                double newWeight = con.getTezina() + deltaWeight;
                con.setDeltaFaktor(deltaWeight);
                con.setTezina(newWeight + momentum * con.getPrethodniDeltaFaktor());*/
            }
            i++;
        }

        for(Sloj sloj:skriveniSlojevi)
        for (Neuron n : sloj.getList()) {
            List<Konekcija> connections =n.getKonekcije();
            for (Konekcija k : connections) {
                    double suma=0d;
                    for(Neuron izlazniNeuron:izlazniSloj.getList()){

                        Konekcija k1=izlazniNeuron.getKonekcija(n.getId());
                        suma+=(k1.getTezina()*k1.getDeltaFaktor());

                    }

                    double deltaFaktor=n.getAktivacionaFunkcija().izracunajVrednostIzvoda(n.getUlaz())*suma;
                    k.setDeltaFaktor(deltaFaktor);
                    double korekcijaFaktora = tezinskiFaktor*deltaFaktor*k.getLink().getIzlaz();
                    double novaVrednost=korekcijaFaktora+k.getTezina();
                     k.setTezina(novaVrednost+momentum*k.getPrethodniDeltaFaktor());










            /*    double aj = neuron.getIzlaz();
                double ai = con.getLink().getIzlaz();
                double sumKoutputs = 0;
              *//*  for(Neuron izlazniNeuron:izlazniSloj.getList()){

                    Konekcija k1=izlazniNeuron.getKonekcija(neuron.getId());
                    sumKoutputs+=(k1.getTezina()*k1.getDeltaFaktor());

                }*//*
                int j = 0;
                for (Neuron outputNeuron : izlazniSloj.getList()) {
                    double wjk = outputNeuron.getKonekcija(neuron.getId()).getTezina();
                    double desiredOutput = (double) par.getOcekivaniIzlaz()[j];
                    double ak = outputNeuron.getIzlaz();
                    j++;
                    sumKoutputs = sumKoutputs + (-(desiredOutput - ak) * ak * (1 - ak) * wjk);
                }

                double partialDerivative = aj * (1 - aj) * ai * sumKoutputs;
                double deltaWeight = -learningRate * partialDerivative;
                double newWeight = con.getTezina() + deltaWeight;
                con.setDeltaFaktor(deltaWeight);
                con.setTezina(newWeight + momentum * con.getPrethodniDeltaFaktor());*/
            }
        }
         /*//propagacija unazad za izlazni sloj i trenutni par//
        int i=0;
        for(Neuron n:izlazniSloj.getList()){
            System.out.println("Izlazni sloj: ");

            List<Konekcija> konekcije=n.getKonekcije();
            for(Konekcija k:konekcije){
                System.out.println("Konekcija: "+k.getId());

                double greskaIzlaza=par.getOcekivaniIzlaz()[i]-n.getIzlaz();
                System.out.println("Greska izlaza: "+greskaIzlaza);
                double deltaFaktor=greskaIzlaza*n.getAktivacionaFunkcija().izracunajVrednostIzvoda(n.getUlaz());
                k.setDeltaFaktor(deltaFaktor);
                System.out.println("Delta faktor: "+deltaFaktor);
                double korekcijaFaktora=Parametri.tezinskiFaktor*deltaFaktor*k.getLink().getIzlaz();
                System.out.println("korekcija faktor: "+korekcijaFaktora);
                double novaVrednost=k.getTezina()+korekcijaFaktora;
                System.out.println("Nova tezina: "+novaVrednost);
                k.setTezina(novaVrednost);



            }
        i++;

        }

        System.out.println("--------------------------------------------------------------");

        for(Sloj sloj:skriveniSlojevi){

            System.out.println("skriveni sloj: ");

                for(Neuron n:sloj.getList()){

                    System.out.println("Neuron: "+n.getId());

                    List<Konekcija> konekcije=n.getKonekcije();
                    for(Konekcija k:konekcije){
                        double suma=0d;
                        for(Neuron izlazniNeuron:izlazniSloj.getList()){

                            Konekcija k1=izlazniNeuron.getKonekcija(n.getId());
                            suma+=(k1.getTezina()*k1.getDeltaFaktor());

                        }

                        double deltaFaktor=n.getAktivacionaFunkcija().izracunajVrednostIzvoda(n.getUlaz())*suma;
                        System.out.println("Delta faktor: "+deltaFaktor);
                        k.setDeltaFaktor(deltaFaktor);
                        double korekcijaFaktora = Parametri.tezinskiFaktor*deltaFaktor*k.getLink().getIzlaz();
                        System.out.println("korekcija faktor: "+korekcijaFaktora);
                        double novaVrednost=korekcijaFaktora+k.getTezina();
                        k.setTezina(novaVrednost);
                        System.out.println("Nova tezina: "+novaVrednost);



                    }



                }


        }*/

    }

    public void treniraj(int brojIteracija,double tacnost){





        for(int k=0;k<brojIteracija;k++){

            double E=0d; //kumulativna greska

            //obucavanje
            for(TreningPar trenutniPar:lista.getParovi()){
                double Ep=0d;
                ulazniSloj.setUlaz(trenutniPar);
                propagacijaUnapred();
                double suma=0d;
                for(int j=0;j<izlazniSloj.list.size();j++){

                    suma+=(Math.pow(trenutniPar.getOcekivaniIzlaz()[j]-izlazniSloj.getList().get(j).getIzlaz(),2));


                }

                Ep=(0.5)*suma;

                E=E+Ep;

                if(Ep> Main.Emax){


                   propagacijaUnazad(trenutniPar);


                }

                    rezultat.put(trenutniPar,izlazniSloj.getIzlaz());

               // System.out.println(izlazniSloj.getList().get(0).getIzlaz()+" - ocekivano: "+trenutniPar.getOcekivaniIzlaz()[0]);
               //  System.out.println(izlazniSloj.getList().get(1).getIzlaz()+" - ocekivano: "+trenutniPar.getOcekivaniIzlaz()[1]);


            }



        }

        printResult(lista);

    }


    private void propagacijaUnapred(){

        for(Sloj sloj:skriveniSlojevi)sloj.propagacijaUnapred();
        izlazniSloj.propagacijaUnapred();



    }


    private void printResult(TreningLista lista) {


        for(TreningPar par:lista.getParovi()){
            System.out.println(par+" Dobijeni izlaz:["+rezultat.get(par)+"]");

        }

       /* for (int p = 0; p < lista.size(); p++) {

            TreningPar par=lista.getParovi().get(p);
            System.out.print(par);

            StringBuffer buffer=new StringBuffer();
            buffer.append("[");
            for(int i=0;i<izlazniSloj.getList().size();i++){

            buffer.append(izlazniSloj.getList().get(i).getIzlaz()+",");



            }
            buffer.append("]");

            ; System.out.print(" Dobijeni izlaz: "+buffer.toString());

            System.out.println();

    }*/


}

public String calc(double[] data){

        TreningPar par=new TreningPar();
        par.setUlaz(data);
        ulazniSloj.setUlaz(par);
        propagacijaUnapred();
        return izlazniSloj.getIzlaz().replace(",","");



}


}

