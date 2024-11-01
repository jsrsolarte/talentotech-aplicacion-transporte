package dominio;

import interfaces.Conducible;

public class Carro extends Vehiculo implements Conducible {
    public Carro(int id, String marca, String modelo, int capacidad, String placa) {
        super(id, marca, modelo, capacidad, placa);
    }

    @Override
    public double calcularTarifa(int minutos) {
        return minutos * 1.5; // Tarifa por minuto
    }

    @Override
    public String obtenerTipo() {
        return "Carro";
    }

    @Override
    public void iniciarViaje() {
        System.out.println("Viaje en coche iniciado.");
    }

    @Override
    public void terminarViaje() {
        System.out.println("Viaje en coche terminado.");
    }
}
