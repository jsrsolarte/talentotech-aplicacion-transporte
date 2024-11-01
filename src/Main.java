import dominio.*;
import excepciones.CapacidadExcedidaException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        manejarMenu();
    }


    private static void manejarMenu() {
        BaseDatos baseDeDatos = new BaseDatos();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Ingresar como Usuario");
            System.out.println("2. Ingresar como Conductor");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        // Opción para Usuario
                        manejarUsuario(baseDeDatos, scanner);
                        break;

                    case 2:
                        // Opción para Conductor
                        manejarConductor(baseDeDatos, scanner);
                        break;

                    case 0:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción inválida. Intenta nuevamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingresa un número.");
                scanner.nextLine(); // Limpiar el buffer
                opcion = -1; // Forzar el bucle a continuar
            }
        } while (opcion != 0);

        scanner.close();

    }


    private static void manejarUsuario(BaseDatos baseDeDatos, Scanner scanner) {
        System.out.print("Ingresa tu teléfono: ");
        String telefonoUsuario = scanner.nextLine();

        Usuario usuario = baseDeDatos.listarUsuarios().stream()
                .filter(u -> u.getTelefono().equals(telefonoUsuario))
                .findFirst()
                .orElse(null);

        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        int opcion;
        do {
            System.out.println("\n=== Menú Usuario: " + usuario.getNombre() + " ===");
            System.out.println("1. Ver historial de viajes");
            System.out.println("2. Pedir un nuevo viaje");
            System.out.println("0. Volver al menú principal");
            System.out.print("Elige una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        // Ver historial de viajes
                        System.out.println("Historial de viajes:");
                        for (Viaje viaje : baseDeDatos.listarViajes()) {
                            if (viaje.getUsuario().getTelefono().equals(usuario.getTelefono())) {
                                System.out.println("Conductor: " + viaje.getConductor().getNombre() + ", Tarifa: " + viaje.obtenerTarifa());
                            }
                        }
                        break;

                    case 2:
                        // Pedir un nuevo viaje
                        System.out.println("Selecciona un tipo de vehículo:");
                        System.out.println("1. Carro");
                        System.out.println("2. Moto");
                        int tipoVehiculo = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer

                        String tipoVehiculoStr = tipoVehiculo == 1 ? "Carro" : "Moto";
                        System.out.println("Vehículos disponibles:");

                        ArrayList<Vehiculo> vehiculosDisponibles = baseDeDatos.listarVehiculos();
                        int i = 1;
                        for (Vehiculo vehiculo : vehiculosDisponibles) {
                            if (vehiculo.obtenerTipo().equals(tipoVehiculoStr)) {
                                System.out.println(i + ". " + vehiculo.obtenerDescripcion());
                                i++;
                            }
                        }

                        System.out.print("Seleccione el id del vehículo: ");
                        int modeloVehiculo = scanner.nextInt();

                        vehiculoElegido =

                        if (vehiculoElegido != null) {
                            System.out.print("Número de pasajeros: ");
                            int pasajeros = scanner.nextInt();
                            System.out.print("Duración del viaje (en minutos): ");
                            int minutos = scanner.nextInt();
                            scanner.nextLine(); // Limpiar el buffer

                            // Obtener conductor disponible
                            Conductor conductorDisponible = baseDeDatos.listarConductores().stream()
                                    .filter(c -> c.getVehiculo().getModelo().equals(vehiculoElegido.getModelo()))
                                    .findFirst()
                                    .orElse(null);

                            if (conductorDisponible != null) {
                                try {
                                    Viaje nuevoViaje = new Viaje(usuario, conductorDisponible, pasajeros, minutos);
                                    baseDeDatos.agregarViaje(nuevoViaje);
                                    System.out.println("Viaje realizado. Tarifa: " + nuevoViaje.obtenerTarifa());
                                } catch (CapacidadExcedidaException e) {
                                    System.out.println(e.getMessage());
                                }
                            } else {
                                System.out.println("No hay conductores disponibles para este vehículo.");
                            }
                        } else {
                            System.out.println("Vehículo no encontrado.");
                        }
                        break;

                    case 0:
                        System.out.println("Volviendo al menú principal...");
                        break;

                    default:
                        System.out.println("Opción inválida. Intenta nuevamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingresa un número.");
                scanner.nextLine(); // Limpiar el buffer
                opcion = -1; // Forzar el bucle a continuar
            }
        } while (opcion != 0);
    }

    private static void manejarConductor(BaseDatos baseDeDatos, Scanner scanner) {
        System.out.print("Ingresa tu teléfono: ");
        String telefonoConductor = scanner.nextLine();

        Conductor conductor = baseDeDatos.listarConductores().stream()
                .filter(c -> c.getTelefono().equals(telefonoConductor))
                .findFirst()
                .orElse(null);

        if (conductor == null) {
            System.out.println("Conductor no encontrado.");
            return;
        }

        int opcion;
        do {
            System.out.println("\n=== Menú Conductor: " + conductor.getNombre() + " ===");
            System.out.println("1. Ver historial de viajes");
            System.out.println("2. Ver datos del vehículo");
            System.out.println("0. Volver al menú principal");
            System.out.print("Elige una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        // Ver historial de viajes
                        System.out.println("Historial de viajes:");
                        for (Viaje viaje : baseDeDatos.listarViajes()) {
                            if (viaje.getConductor().getTelefono().equals(conductor.getTelefono())) {
                                System.out.println("Usuario: " + viaje.getUsuario().getNombre() + ", Tarifa: " + viaje.obtenerTarifa());
                            }
                        }
                        break;

                    case 2:
                        // Ver datos del vehículo
                        System.out.println("Datos del vehículo:");
                        System.out.println("Modelo: " + conductor.getVehiculo().getModelo());
                        System.out.println("Tipo: " + (conductor.getVehiculo() instanceof Carro ? "Coche" : "Moto"));
                        break;

                    case 0:
                        System.out.println("Volviendo al menú principal...");
                        break;

                    default:
                        System.out.println("Opción inválida. Intenta nuevamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingresa un número.");
                scanner.nextLine(); // Limpiar el buffer
                opcion = -1; // Forzar el bucle a continuar
            }
        } while (opcion != 0);
    }
}
