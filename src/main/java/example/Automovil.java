package example;

public class Automovil extends Vehiculo {

    private static int MAX_VELOCIDAD=10000;

    public Automovil(String marca, String modelo, int ano) {
        super(marca, modelo, ano);
    }

    @Override
    public int calcularVelocidad(int aceleracion) {
        int velocidadResult = velocidad + aceleracion;
        velocidadResult = Math.min(velocidadResult, MAX_VELOCIDAD);
        velocidad = Math.max(0, velocidadResult);
        return velocidad;
    }

    @Override
    public void acelerar() {

    }

    @Override
    public void frenar() {

    }



}
