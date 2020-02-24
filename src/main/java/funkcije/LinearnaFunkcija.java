package funkcije;

public class LinearnaFunkcija implements AktivacionaFunkcija {
    @Override
    public double izracunajVrednost(double suma) {
        return suma;
    }

    @Override
    public double izracunajVrednostIzvoda(double input) {
        return 0;
    }


}
