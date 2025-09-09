package actividad4;
class Nodo {
    Empleado empleado;
    Nodo izquierdo, derecho;

    public Nodo(Empleado empleado) {
        this.empleado = empleado;
        izquierdo = derecho = null;
    }
}

