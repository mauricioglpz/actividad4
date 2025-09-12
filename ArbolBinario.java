class ArbolBinario {
    Nodo raiz;

    
    public void insertar(Empleado empleado) {
        raiz = insertarRec(raiz, empleado);
    }

    private Nodo insertarRec(Nodo actual, Empleado empleado) {
        if (actual == null) {
            return new Nodo(empleado);
        }
        if (empleado.id < actual.empleado.id) {
            actual.izquierdo = insertarRec(actual.izquierdo, empleado);
        } else if (empleado.id > actual.empleado.id) {
            actual.derecho = insertarRec(actual.derecho, empleado);
        }
        return actual;
    }

    public Empleado buscar(int id) {
        Nodo resultado = buscarRec(raiz, id);
        return (resultado != null) ? resultado.empleado : null;
    }

    private Nodo buscarRec(Nodo actual, int id) {
        if (actual == null || actual.empleado.id == id) {
            return actual;
        }
        if (id < actual.empleado.id) {
            return buscarRec(actual.izquierdo, id);
        } else {
            return buscarRec(actual.derecho, id);
        }
    }

    
    public void eliminar(int id) {
        raiz = eliminarRec(raiz, id);
    }

    private Nodo eliminarRec(Nodo actual, int id) {
        if (actual == null) return null;

        if (id < actual.empleado.id) {
            actual.izquierdo = eliminarRec(actual.izquierdo, id);
        } else if (id > actual.empleado.id) {
            actual.derecho = eliminarRec(actual.derecho, id);
        } else {
            
            if (actual.izquierdo == null && actual.derecho == null) {
                return null;
            }

            if (actual.izquierdo == null) return actual.derecho;
            if (actual.derecho == null) return actual.izquierdo;

            
            Nodo sucesor = encontrarMin(actual.derecho);
            actual.empleado = sucesor.empleado;
            actual.derecho = eliminarRec(actual.derecho, sucesor.empleado.id);
        }
        return actual;
    }

    private Nodo encontrarMin(Nodo nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo;
    }

    public void inorden() {
        inordenRec(raiz);
    }

    private void inordenRec(Nodo actual) {
        if (actual != null) {
            inordenRec(actual.izquierdo);
            System.out.println(actual.empleado);
            inordenRec(actual.derecho);
        }
    }
}
