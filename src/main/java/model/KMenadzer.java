package model;

import java.util.List;

public class KMenadzer {

    public static void konektuj(Sloj a, Sloj b){



    for(Neuron n1:a.getList())
        for(Neuron n2:b.getList())n2.addKonekcija(new Konekcija(n1));


       /* List<Konekcija> ije=b.getList().get(1).getKonekcije();
        ije.forEach(System.out::println);
*/



    }




}
