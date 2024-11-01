# Aplicación de Transporte

Este proyecto es una aplicación de transporte que permite a los usuarios solicitar viajes y a los conductores gestionar sus vehículos y viajes. La aplicación está escrita en Java y utiliza una estructura de clases para representar a los usuarios, conductores, vehículos y viajes.


## Descripción de Archivos y Directorios

- **src/**: Contiene todos los archivos fuente del proyecto.
  - **BaseDatos.java**: Clase que maneja la base de datos en memoria de usuarios, conductores, vehículos y viajes.
  - **dominio/**: Contiene las clases principales del dominio del problema.
    - **Carro.java**: Clase que representa un carro y extiende de `Vehiculo`.
    - **Conductor.java**: Clase que representa a un conductor y extiende de `Persona`.
    - **Moto.java**: Clase que representa una moto y extiende de `Vehiculo`.
    - **Persona.java**: Clase base para `Usuario` y `Conductor`.
    - **Usuario.java**: Clase que representa a un usuario y extiende de `Persona`.
    - **Vehiculo.java**: Clase abstracta que representa un vehículo.
    - **Viaje.java**: Clase que representa un viaje.
  - **excepciones/**: Contiene las excepciones personalizadas del proyecto.
    - **CapacidadExcedidaException.java**: Excepción lanzada cuando se excede la capacidad de un vehículo.
  - **interfaces/**: Contiene las interfaces del proyecto.
    - **Conducible.java**: Interfaz que define los métodos que deben implementar los vehículos conducibles.
  - **Main.java**: Clase principal que contiene el método `main` y maneja la interacción con el usuario.

## Funcionalidades

### Usuarios

- **Registrar Usuarios**: Los usuarios pueden ser registrados en la base de datos.
- **Solicitar Viajes**: Los usuarios pueden solicitar viajes indicando el tipo de vehículo, número de pasajeros y duración del viaje.
- **Ver Historial de Viajes**: Los usuarios pueden ver el historial de sus viajes.

### Conductores

- **Registrar Conductores**: Los conductores pueden ser registrados en la base de datos.
- **Gestionar Vehículos**: Los conductores pueden gestionar los vehículos que conducen.
- **Ver Historial de Viajes**: Los conductores pueden ver el historial de sus viajes.

### Vehículos

- **Registrar Vehículos**: Los vehículos pueden ser registrados en la base de datos.
- **Calcular Tarifa**: Los vehículos pueden calcular la tarifa de un viaje basado en la duración del mismo.

## Ejecución del Proyecto

Para ejecutar el proyecto, sigue estos pasos:

1. Clona el repositorio en tu máquina local.
2. Abre el proyecto en tu IDE preferido (por ejemplo, IntelliJ IDEA o Visual Studio Code).
3. Compila y ejecuta la clase `Main.java`.

## Ejemplo de Uso

Al ejecutar la aplicación, se presentará un menú principal donde puedes elegir entre ingresar como usuario o conductor. Dependiendo de tu elección, se te presentarán diferentes opciones para gestionar viajes y vehículos.

