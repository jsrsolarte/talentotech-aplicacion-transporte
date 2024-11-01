import dominio.*;

import java.util.ArrayList;
import java.util.HashMap;

public class BaseDatos {
    private HashMap<Integer, Usuario> usuarios; // Clave: teléfono
    private HashMap<Integer, Conductor> conductores; // Clave: teléfono
    private HashMap<Integer, Vehiculo> vehiculos; // Clave: modelo
    private ArrayList<Viaje> viajes; // Lista de viajes

    public BaseDatos() {
        usuarios = new HashMap<>();
        conductores = new HashMap<>();
        vehiculos = new HashMap<>();
        viajes = new ArrayList<>();
        inicializarDatos();
    }

    private void inicializarDatos() {
        // Inicializar conductores
        Conductor conductor1 = new Conductor(1, "Juan", "123456789");
        Conductor conductor2 = new Conductor(2, "Ana", "987654321");
        Conductor conductor3 = new Conductor(3, "Luis", "555555555");

        // Agregar conductores a la base de datos
        agregarConductor(conductor1);
        agregarConductor(conductor2);
        agregarConductor(conductor3);

        // Inicializar vehículos
        Vehiculo coche1 = new Carro(1, "Toyota", "Corolla", 4, "AAA111", conductor1);
        Vehiculo coche2 = new Carro(2, "Ford", "Focus", 4, "AAA222", conductor2);
        Vehiculo moto1 = new Moto(3, "Yamaha", "MT-07", 2, "AAA33D", conductor3);

        // Agregar vehículos a la base de datos
        agregarVehiculo(coche1);
        agregarVehiculo(coche2);
        agregarVehiculo(moto1);

        // Inicializar usuarios
        Usuario usuario1 = new Usuario(1, "Carlos", "111222333");
        Usuario usuario2 = new Usuario(2, "Lucía", "444555666");
        Usuario usuario3 = new Usuario(3, "Pedro", "222333444");

        // Agregar usuarios a la base de datos
        agregarUsuario(usuario1);
        agregarUsuario(usuario2);
        agregarUsuario(usuario3);
    }

    // Métodos para agregar objetos
    public void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
    }

    public void agregarConductor(Conductor conductor) {
        conductores.put(conductor.getId(), conductor);
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.put(vehiculo.getId(), vehiculo);
        vehiculo.getConductor().setVehiculo(vehiculo);
    }

    public void agregarViaje(Viaje viaje) {
        viajes.add(viaje);
    }

    public Vehiculo obtenerVehiculo(int idVehiculo) {
        return vehiculos.get(idVehiculo);
    }

    public Usuario obtenerUsuario(int idUsuario) {
        return usuarios.get(idUsuario);
    }

    public ArrayList<Viaje> obtenerViajesDelUsuario(int idUsuario) {
        return usuarios.get(idUsuario).getViajes();
    }

    public ArrayList<Vehiculo> listarVehiculos() {
        return new ArrayList<>(vehiculos.values());
    }

    public Conductor obtenerConductor(int idConductor) {
        return conductores.get(idConductor);
    }

    public ArrayList<Viaje> listarViajesDelConductor(int idConductor) {
        ArrayList<Viaje> viajesConductor = conductores.get(idConductor).getViajes();
        return viajesConductor;
    }
}
