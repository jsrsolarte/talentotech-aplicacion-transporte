package dominio;

import java.util.ArrayList;

public class Conductor extends Persona {
    private ArrayList<Viaje> viajes;
    private Vehiculo vehiculo;

    public Conductor(int id, String nombre, String telefono) {
        super(id, nombre, telefono);
        this.viajes = new ArrayList<>();
    }

    public void agregarViaje(Viaje viaje) {
        viajes.add(viaje);
    }

    public double obtenerCalificacion() {
        int suma = 0;
        for (Viaje viaje : viajes) {
            suma += viaje.getCalificacion();
        }
        return suma / viajes.size();
    }

    public ArrayList<Viaje> getViajes() {
        return viajes;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
}
