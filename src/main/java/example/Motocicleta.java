package example;

public class Motocicleta extends Vehiculo {

    private static int MAX_VELOCIDAD=15000;

    public Motocicleta(String marca, String modelo, int ano) {
        super(marca, modelo, ano);
    }

    @Override
    public int calcularVelocidad(int aceleracion) {
        int velocidad = 0;
        while (velocidad != MAX_VELOCIDAD) {
            if (aceleracion > 0 ) {
                velocidad = aceleracion + velocidad;
            } else {
                velocidad = aceleracion - velocidad;
            }
        }
        return velocidad;
    }

    @Override
    public void acelerar() {

    }

    @Override
    public void frenar() {

    }


}
