package funkcije;

public class SigmoidnaFunkcija implements AktivacionaFunkcija {
    @Override
    public double izracunajVrednost(double suma) {
        return ( 1d / (1+Math.pow(Math.E,-suma)));
    }

    @Override
    public double izracunajVrednostIzvoda(double suma) {

        return (izracunajVrednost(suma)*(1-izracunajVrednost(suma)));   //Math.pow(Math.E,-suma))/(Math.pow((1+Math.pow(Math.E,-suma)),2))
    }

    public static void main(String...arsg){

        SigmoidnaFunkcija f=new SigmoidnaFunkcija();
        System.out.println(f.izracunajVrednostIzvoda(5));

    }


}
