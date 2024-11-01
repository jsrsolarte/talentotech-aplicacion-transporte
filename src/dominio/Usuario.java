package dominio;

import java.util.ArrayList;

public class Usuario extends Persona {
    private ArrayList<Viaje> viajes; // Relación: un usuario puede tener múltiples viajes

    public Usuario(int id, String nombre, String telefono) {
        super(id, nombre, telefono);
        this.viajes = new ArrayList<>();
    }

    public void agregarViaje(Viaje viaje) {
        viajes.add(viaje);
    }

    public ArrayList<Viaje> getViajes() {
        return viajes;
    }
}
