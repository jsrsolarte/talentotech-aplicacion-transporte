package dominio;

public class Persona {
    protected int id;
    protected String nombre;
    protected String telefono;

    public Persona(int id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }


    public String getTelefono() {
        return telefono;
    }

}
