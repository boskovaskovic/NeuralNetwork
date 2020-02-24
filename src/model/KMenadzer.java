package model;

public class KMenadzer {

    public static void konektuj(Sloj a, Sloj b){

    for(Neuron n1:a.getList()){

        for(Neuron n2:b.getList()){

            n1.addIzlaznaKonekcija(new Konekcija(n1,n2));
            n2.addUlaznaKonekcija(new Konekcija(n1,null));


        }


    }

    }




}
