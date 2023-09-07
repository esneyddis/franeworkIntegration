package example;

public class Main {
    public static void main(String[] args) {
        Vehiculo mercedes = new Automovil("mercedes", "gl", 2020);
        int velocidad = mercedes.calcularVelocidad(10);
         velocidad = mercedes.calcularVelocidad(-20);
         velocidad = mercedes.calcularVelocidad(-20);
         velocidad = mercedes.calcularVelocidad(-20);
         velocidad = mercedes.calcularVelocidad(1000000000);
        System.out.println("velocidad = " + velocidad);
        assert velocidad == 20;
    }

}
