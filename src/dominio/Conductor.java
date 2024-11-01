package dominio;

import java.util.ArrayList;

public class Conductor extends Persona {
    private Vehiculo vehiculo;
    private ArrayList<Viaje> viajes; // Relación: un conductor puede tener múltiples viajes

    public Conductor(String nombre, String telefono, Vehiculo vehiculo) {
        super(nombre, telefono);
        this.vehiculo = vehiculo;
        this.viajes = new ArrayList<>();
    }

    public void agregarViaje(Viaje viaje) {
        viajes.add(viaje);
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public ArrayList<Viaje> getViajes() {
        return viajes;
    }
}
