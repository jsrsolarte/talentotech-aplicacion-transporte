package dominio;

import interfaces.Conducible;

public class Moto extends Vehiculo implements Conducible {

    public Moto(int id, String marca, String modelo, int capacidad, String placa, Conductor conductor) {
        super(id, marca, modelo, capacidad, placa, conductor);
    }

    @Override
    public double calcularTarifa(int minutos) {
        return minutos * 1.0; // Tarifa por minuto
    }

    @Override
    public String obtenerTipo() {
        return "Moto";
    }

    @Override
    public void iniciarViaje() {
        System.out.println("Viaje en moto iniciado.");
    }

    @Override
    public void terminarViaje() {
        System.out.println("Viaje en moto terminado.");
    }
}
