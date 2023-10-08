package example;

public abstract class Vehiculo implements IVehiculo{

    protected String marca;
    protected String modelo;
    protected int ano;
    protected int velocidad;


    public Vehiculo (String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public abstract int calcularVelocidad(int aceleracion);

    @Override
    public String toString() {
        return "Vehiculo {" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                '}';
    }

}
