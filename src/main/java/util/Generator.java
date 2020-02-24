package util;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {



    public static double getRandomDoubleNumber(double min, double max){

        return ThreadLocalRandom.current().nextDouble(min,max);}





    public static String getID(){

        return UUID.randomUUID().toString().substring(0,9);


    }



}
