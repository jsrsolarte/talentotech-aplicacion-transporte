package dominio;

import excepciones.CapacidadExcedidaException;

public class Viaje {
    private Usuario usuario;
    private Conductor conductor;
    private Vehiculo vehiculo;
    private int pasajeros;
    private int minutos;

    public Viaje(Usuario usuario, Conductor conductor, int pasajeros, int minutos) throws CapacidadExcedidaException {
        if (pasajeros > conductor.getVehiculo().capacidad) {
            throw new CapacidadExcedidaException("La capacidad del vehículo es excedida.");
        }
        this.usuario = usuario;
        this.conductor = conductor;
        this.vehiculo = conductor.getVehiculo();
        this.pasajeros = pasajeros;
        this.minutos = minutos;

        // Agregar el viaje al usuario y al conductor
        usuario.agregarViaje(this);
        conductor.agregarViaje(this);
    }

    public double obtenerTarifa() {
        return vehiculo.calcularTarifa(minutos);
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public Conductor getConductor() {
        return conductor;
    }
}
