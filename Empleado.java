class Empleado {
    int id;
    String nombre;

    public Empleado(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "ID: " + id + " - Nombre: " + nombre;
    }
}

