package dominio;

public abstract class Vehiculo {
    private int id;
    private String marca;
    private String modelo;
    private int capacidad;
    private String placa;
    private Conductor conductor;

    public Vehiculo(int id, String marca, String modelo, int capacidad, String placa, Conductor conductor) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.placa = placa;
        this.conductor = conductor;
    }

    public int getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public String obtenerDescripcion() {
        return "Id: " + id + ", Marca: " + marca + ", Modelo: " + modelo + ", Capacidad: " + capacidad + ", Placa: "
                + placa;
    }

    public abstract double calcularTarifa(int minutos);

    public abstract String obtenerTipo();

}
