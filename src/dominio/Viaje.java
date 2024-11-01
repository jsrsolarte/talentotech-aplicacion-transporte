package dominio;

import excepciones.CapacidadExcedidaException;

public class Viaje {
    private Usuario usuario;
    private Vehiculo vehiculo;
    private int pasajeros;
    private int minutos;
    private int calificacion;

    public Viaje(Usuario usuario, Vehiculo vehiculo, int pasajeros, int minutos) throws CapacidadExcedidaException {
        if (pasajeros > vehiculo.getCapacidad()) {
            throw new CapacidadExcedidaException("La capacidad del vehículo es excedida.");
        }
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.pasajeros = pasajeros;
        this.minutos = minutos;

        // Agregar el viaje al usuario y al conductor
        usuario.agregarViaje(this);
        vehiculo.getConductor().agregarViaje(this);
    }

    public double obtenerTarifa() {
        return vehiculo.calcularTarifa(minutos);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String obtenerDescripcion() {
        return "Usuario: " + usuario.getNombre() + ", Vehículo: " + vehiculo.obtenerDescripcion() + ", Pasajeros: "
                + pasajeros + ", Minutos: " + minutos + ", Tarifa: " + obtenerTarifa();
    }

    public void calificar(int calificacion) {
        this.calificacion = calificacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

}
