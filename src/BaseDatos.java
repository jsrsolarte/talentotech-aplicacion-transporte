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
        // Inicializar vehículos
        Vehiculo coche1 = new Carro(1, "Toyota", "Corolla", 4, "AAA111");
        Vehiculo coche2 = new Carro(2, "Ford", "Focus", 4, "AAA222");
        Vehiculo moto1 = new Moto(3, "Yamaha", "MT-07", 2, "AAA33D");

        // Agregar vehículos a la base de datos
        agregarVehiculo(coche1);
        agregarVehiculo(coche2);
        agregarVehiculo(moto1);

        // Inicializar conductores
        Conductor conductor1 = new Conductor("Juan", "123456789", coche1);
        Conductor conductor2 = new Conductor("Ana", "987654321", coche2);
        Conductor conductor3 = new Conductor("Luis", "555555555", moto1);

        // Agregar conductores a la base de datos
        agregarConductor(conductor1);
        agregarConductor(conductor2);
        agregarConductor(conductor3);

        // Inicializar usuarios
        Usuario usuario1 = new Usuario(1, "Carlos", "111222333", "Calle Falsa 123");
        Usuario usuario2 = new Usuario(2, "Lucía", "444555666", "Avenida Siempre Viva 456");
        Usuario usuario3 = new Usuario(3, "Pedro", "222333444", "Calle Imaginaria 789");

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
    }

    public void agregarViaje(Viaje viaje) {
        viajes.add(viaje);
    }

    // Métodos para listar objetos
    public ArrayList<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios.values());
    }

    public ArrayList<Conductor> listarConductores() {
        return new ArrayList<>(conductores.values());
    }

    public ArrayList<Vehiculo> listarVehiculos() {
        return new ArrayList<>(vehiculos.values());
    }

    public ArrayList<Viaje> listarViajes() {
        return viajes;
    }


}
