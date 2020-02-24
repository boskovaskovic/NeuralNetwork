package main;

import factory.NeuronFactory;
import funkcije.LinearnaFunkcija;
import funkcije.SigmoidnaFunkcija;
import model.*;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.core.learning.LearningRule;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.BackPropagation;
import org.neuroph.util.TransferFunctionType;
import util.Generator;
import util.Parametri;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    private static HashMap<Tacka,Double> stvarniRezultat=new HashMap<>();
    private static List<Tacka> tacke=new ArrayList<>();
    private static Random r=new Random();
    public static final double tezinskiFaktor = 5;
    public static final double Emax=0.0001d;

    public static void main(String...args){


        DataSet trainingSet = new DataSet(3, 7);
        trainingSet.addRow(new DataSetRow(new double[] { 2,3,2019 }, new double[] { 19,22,8,7,32,34,13 }));
        trainingSet.addRow(new DataSetRow(new double[] { 3,3,201 }, new double[] { 38,37,5,6,18,21,16 }));
        trainingSet.addRow(new DataSetRow(new double[] { 4 ,3,201}, new double[] { 26,4,29,9,30,1,2 }));
        trainingSet.addRow(new DataSetRow(new double[] { 5,3,201 }, new double[] { 5,25,18,28,6,4,7 }));

        trainingSet.addRow(new DataSetRow(new double[] { 6,3,201 }, new double[] { 28,12,4,36,21,9,33 }));
        trainingSet.addRow(new DataSetRow(new double[] { 7,3,201 }, new double[] { 25,26,13,18,9,34,38 }));
        trainingSet.addRow(new DataSetRow(new double[] { 8,3,201 }, new double[] { 15,2,28,1,36,5,14 }));
        trainingSet.addRow(new DataSetRow(new double[] { 9,3,201}, new double[] { 36,28,39,24,5,1,12 }));

        MultiLayerPerceptron myMlPerceptron = new MultiLayerPerceptron(TransferFunctionType.SIGMOID, 3, 50, 7);
        BackPropagation p =new BackPropagation();
        p.setMaxIterations(100000);
        myMlPerceptron.setLearningRule(p);


        myMlPerceptron.learn(trainingSet);

        System.out.println("Testing trained neural network");
        testNeuralNetwork(myMlPerceptron, trainingSet);

























   /*     try {
            ucitajPodatke();


        } catch (IOException e) {
            e.printStackTrace();
        }
        UlazniSloj ulazni =new UlazniSloj(NeuronFactory.getNeuron(3));
        Sloj skriveni=new Sloj(NeuronFactory.getNeuron(20));
        Sloj izlazni=new Sloj(NeuronFactory.getNeuron(1));


        ulazni.setActivationFunction(new LinearnaFunkcija());
        skriveni.setActivationFunction(new SigmoidnaFunkcija());

        izlazni.setActivationFunction(new SigmoidnaFunkcija());

        NeuralnaMreza mreza=new NeuralnaMreza(ulazni,izlazni);
        mreza.addSkriveniSloj(skriveni);


        mreza.konektuj();
        TreningLista lista=new TreningLista();

     *//*   for (int i= 0;i<10;i++){

            Tacka t=new Tacka(Generator.getRandomDoubleNumber(-5,5),Generator.getRandomDoubleNumber(-5,5),Generator.getRandomDoubleNumber(-0.1,0.2));
            double data=t.getZ()-Parametri.vrednostFunckcije(t.getX(),t.getY());
            double a=0;
            if(data > 0)a=1;


            System.out.println("Generisana tacka: "+t);
            lista.addPar(new TreningPar(new double[]{t.getX(),t.getY(),t.getZ()},new double[]{a}));

        }*//*

        Tacka t1=new Tacka(1.7475896090150727,4.324043576613377,0.10999513375247075);//1
        Tacka t2=new Tacka(4.541552779058417,4.544980389743307,0.1723800615865637); //1
        Tacka t3=new Tacka(-2.2683783333827687,-0.05516160682099347,-0.08060408437258076);//1
        Tacka t4=new Tacka(-3.2877512971545597,-3.424412942085031,0.09547698989866693); //1
        Tacka t5=new Tacka(-1.748083202856563,-1.39965011485365,-0.08263555638238558); //0
        Tacka t6=new Tacka(-2.1942062083595815,1.5427533624152403,0.19885445452609588); //1
        Tacka t7=new Tacka(2.7851186433102484,-3.6835638646912683,0.023338051557742642); //1
        Tacka t8=new Tacka(-0.10955791778876645,2.709817627330943,0.1539833046048981);//1
        Tacka t9=new Tacka(-2.2683783333827687,-0.05516160682099347,-0.08060408437258076);//0
        Tacka t10=new Tacka(4.908609030439903,-2.773012889684645,-0.026374663724212655);//0
        Tacka t11=new Tacka(-2.6023511328171822,-0.03671847805903372,-0.03526654980310272); //0
        Tacka t12=new Tacka(-2.887517414172902,-2.046204882624123,-0.0816323156233367); //0
        Tacka t13=new Tacka(1.6180301103704577,-1.047324029821326,-0.07952100197526704); //0
        Tacka t14=new Tacka(3.3477005397501998,3.6433900006149926,-0.09620146608873181); //0
       // Tacka t15=new Tacka(1.6180301103704577,-1.047324029821326,-0.07952100197526704); //0
      //  Tacka t16=new Tacka(3.3477005397501998,3.6433900006149926,-0.09620146608873181); //0

     *//*   Ulaz: [-1.5004380918993143,3.8221782765186347,0.09119846789179534,] Ocekivani Izlaz: [1.0,] Dobijeni izlaz:[0.9860,]
        Ulaz: [2.2502102292429704,-1.8555048883036607,0.18678592394196966,] Ocekivani Izlaz: [1.0,] Dobijeni izlaz:[0.9859,]
        Ulaz: [-2.2683783333827687,-0.05516160682099347,-0.08060408437258076,] Ocekivani Izlaz: [0.0,] Dobijeni izlaz:[0.0038,]
        Ulaz: [4.908609030439903,-2.773012889684645,-0.026374663724212655,] Ocekivani Izlaz: [0.0,] Dobijeni izlaz:[0.0141,]
        Ulaz: [0.47751260588789624,0.21744588125688047,0.13746557793878925,] Ocekivani Izlaz: [1.0,] Dobijeni izlaz:[0.9999,]
        Ulaz: [-2.6023511328171822,-0.03671847805903372,-0.03526654980310272,] Ocekivani Izlaz: [0.0,] Dobijeni izlaz:[0.0085,]
        Ulaz: [-2.887517414172902,-2.046204882624123,-0.0816323156233367,] Ocekivani Izlaz: [0.0,] Dobijeni izlaz:[0.0002,]
        Ulaz: [0.6880975199991006,-1.3682970022733167,0.1679700681675306,] Ocekivani Izlaz: [1.0,] Dobijeni izlaz:[0.9993,]*




        Ulaz: [-4.485721365122277,-1.2594674148388698,-0.08629056037727327,] Ocekivani Izlaz: [0.0,] Dobijeni izlaz:[0.0141,]
Ulaz: [-3.541684617713109,2.0689772879964536,0.020410540969973384,] Ocekivani Izlaz: [1.0,] Dobijeni izlaz:[0.9859,]
Ulaz: [-1.5741020228742042,-3.7532073474470993,0.08026613196409715,] Ocekivani Izlaz: [1.0,] Dobijeni izlaz:[1.0000,]
Ulaz: [-0.5537204224993264,4.780084601001114,0.02929715535973934,] Ocekivani Izlaz: [1.0,] Dobijeni izlaz:[0.9902,]
Ulaz: [2.6660031306477823,2.2282217238079394,-0.0018841541649913668,] Ocekivani Izlaz: [1.0,] Dobijeni izlaz:[0.9864,]
Ulaz: [-2.8753016233942863,-3.002757740425568,0.05511046754158591,] Ocekivani Izlaz: [1.0,] Dobijeni izlaz:[1.0000,]
Ulaz: [3.3477005397501998,3.6433900006149926,-0.09620146608873181,] Ocekivani Izlaz: [0.0,] Dobijeni izlaz:[0.0141,]
Ulaz: [1.832532309247112,-1.2353086607766772,0.1569251591082346,] Ocekivani Izlaz: [1.0,] Dobijeni izlaz:[0.9859,]



Tacka t1=new Tacka(4.051582173703155,-3.7268478773070446,0.016831275128046982);//1
        Tacka t2=new Tacka(4.541552779058417,4.544980389743307,0.1723800615865637); //1
        Tacka t3=new Tacka(-2.2683783333827687,-0.05516160682099347,-0.08060408437258076);//1
        Tacka t4=new Tacka(-2.0206571875734136,-3.257069370265886,0.14229534765832036); //1
        Tacka t5=new Tacka(-1.748083202856563,-1.39965011485365,-0.08263555638238558); //0
        Tacka t6=new Tacka(-2.1942062083595815,1.5427533624152403,0.19885445452609588); //1
        Tacka t7=new Tacka(2.7851186433102484,-3.6835638646912683,0.023338051557742642); //1
        Tacka t8=new Tacka(-0.10955791778876645,2.709817627330943,0.1539833046048981);//1
        Tacka t9=new Tacka(-2.887517414172902,-2.046204882624123,-0.0816323156233367);//1
        Tacka t10=new Tacka(4.908609030439903,-2.773012889684645,-0.026374663724212655);//1
        Tacka t11=new Tacka(3.7953,1.5925,-0.0848);


        /*//*


        lista.addPar(new TreningPar(new double[]{t1.getX(),t1.getY(),t1.getZ()},new double[]{1}));
        lista.addPar(new TreningPar(new double[]{t9.getX(),t9.getY(),t9.getZ()},new double[]{0}));
        lista.addPar(new TreningPar(new double[]{t2.getX(),t2.getY(),t2.getZ()},new double[]{1}));
        lista.addPar(new TreningPar(new double[]{t3.getX(),t3.getY(),t3.getZ()},new double[]{1}));
        lista.addPar(new TreningPar(new double[]{t4.getX(),t4.getY(),t4.getZ()},new double[]{1}));
        lista.addPar(new TreningPar(new double[]{t5.getX(),t5.getY(),t5.getZ()},new double[]{0}));
        lista.addPar(new TreningPar(new double[]{t6.getX(),t6.getY(),t6.getZ()},new double[]{1}));
        lista.addPar(new TreningPar(new double[]{t7.getX(),t7.getY(),t7.getZ()},new double[]{1}));
        lista.addPar(new TreningPar(new double[]{t8.getX(),t8.getY(),t8.getZ()},new double[]{1}));
        lista.addPar(new TreningPar(new double[]{t10.getX(),t10.getY(),t10.getZ()},new double[]{0}));
        lista.addPar(new TreningPar(new double[]{t11.getX(),t11.getY(),t11.getZ()},new double[]{0}));
        lista.addPar(new TreningPar(new double[]{t12.getX(),t12.getY(),t12.getZ()},new double[]{0}));
        lista.addPar(new TreningPar(new double[]{t13.getX(),t13.getY(),t13.getZ()},new double[]{0}));
        lista.addPar(new TreningPar(new double[]{t14.getX(),t14.getY(),t14.getZ()},new double[]{0}));




        mreza.setLista(lista);

        mreza.treniraj(15000,Emax);


        System.out.println("Trening zavrsen!");
        int i=0;
        for(Tacka t:tacke){
            String rezultat=mreza.calc(new double[]{t.getX(),t.getY(),t.getZ()});
            if(Math.abs(stvarniRezultat.get(t)-Double.parseDouble(rezultat))<0.2d)i++;
            System.out.println("Tacka: "+t+" - Ocekivani rezultat:"+stvarniRezultat.get(t)+" Dobijeni izlaz: "+rezultat  );
        }

    //System.out.println("Broj pogodjenih tacaka: "+i);

*/




    }


    public static void testNeuralNetwork(NeuralNetwork<BackPropagation> nnet, DataSet testSet) {

        for (DataSetRow dataRow : testSet.getRows()) {
            nnet.setInput(dataRow.getInput());
            nnet.calculate();
            double[] networkOutput = nnet.getOutput();
            System.out.print("INPUT: " + Arrays.toString(dataRow.getInput()));
            System.out.println(" OUTPUT: " + Arrays.toString(networkOutput));
        }

    }




    private static void ucitajPodatke() throws IOException {


        List<String> lines=Files.readAllLines(Paths.get("."+ File.separator+"tacke1.txt"));

        for(int i=0;i<50;i++){

            Double x=Double.parseDouble(lines.get(i).replace("x","").replace("y","").replace("z","")
                    .replace("=","").replace("[","").replace("]","").trim());
            Double y=Double.parseDouble(lines.get(i+50).replace("x","").replace("y","").replace("z","")
                    .replace("=","").replace("[","").replace("]","").trim());
            Double z=Double.parseDouble(lines.get(i+100).replace("x","").replace("y","").replace("z","")
                    .replace("=","").replace("[","").replace("]","").trim());

            double value=0d;
            double rezultat=z-Parametri.vrednostFunckcije(x,y);
            if(rezultat>0)value=1d;
            else value=0d;
            stvarniRezultat.put(new Tacka(x,y,z),value);
            tacke.add(new Tacka(x,y,z));

        }




    }


}
