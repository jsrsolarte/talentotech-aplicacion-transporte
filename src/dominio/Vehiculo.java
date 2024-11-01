package dominio;

public abstract class Vehiculo {
    protected int id;
    protected String marca;
    protected String modelo;
    protected int capacidad;
    protected String placa;

    public Vehiculo(int id, String marca, String modelo, int capacidad, String placa) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.placa = placa;
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

    public String obtenerDescripcion() {
        return "Id: " + id + ", Marca: " + marca + ", Modelo: " + modelo + ", Capacidad: " + capacidad + ", Placa: " + placa;
    }

    public abstract double calcularTarifa(int minutos);

    public abstract String obtenerTipo();
}

