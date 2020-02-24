package factory;

import model.Neuron;
import model.Sloj;

import java.util.ArrayList;

public class NeuronFactory {

    public static Neuron getNeuron(){
        return new Neuron();
    }

    public static ArrayList<Neuron> getNeuron(int broj){
        ArrayList<Neuron> lista=new ArrayList<>();
        for(int i=0;i<broj;i++)lista.add(new Neuron());
        return lista;
    }

}
