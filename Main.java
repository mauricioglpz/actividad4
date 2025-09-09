package actividad4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario();

        String[] nombres = {
            "Ana", "Luis", "María", "Carlos", "Sofía", "Pedro", "Laura",
            "José", "Marta", "Andrés", "Lucía", "Raúl", "Valeria", "Diego",
            "Elena", "Jorge", "Patricia", "Ricardo", "Gabriela", "Fernando",
            "Antonio", "Josefina", "Ernesto", "Santiago", "Lalo", "Frida",
        };

        // Insertar automáticamente 1000 empleados
        for (int i = 1; i <= 1000; i++) {
            String nombre = nombres[(i - 1) % nombres.length];
            arbol.insertar(new Empleado(i, nombre));
        }

        System.out.println("=== sistema de gestión de Empleados ===");
        int opcion;
        int nextId = 1001; 

        do {
            System.out.println("\nMenú:");
            System.out.println("1. buscar empleado por ID");
            System.out.println("2. insertar nuevo empleado");
            System.out.println("3. eliminar empleado por ID");
            System.out.println("4. mostrar todos los empleados (Inorden)");
            System.out.println("5. salir");
            System.out.print("elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("ingrese ID del empleado a buscar: ");
                    int idBuscar = sc.nextInt();
                    Empleado encontrado = arbol.buscar(idBuscar);
                    if (encontrado != null) {
                        System.out.println("empleado encontrado: " + encontrado);
                    } else {
                        System.out.println("empleado con ID " + idBuscar + " no existe.");
                    }
                    break;

                case 2:
                    sc.nextLine(); // limpiar buffer
                    System.out.print("ingrese nombre del nuevo empleado: ");
                    String nombre = sc.nextLine();
                    Empleado nuevo = new Empleado(nextId, nombre);
                    arbol.insertar(nuevo);
                    System.out.println("empleado insertado: " + nuevo);
                    nextId++;
                    break;

                case 3:
                    System.out.print("ingrese ID del empleado a eliminar: ");
                    int idEliminar = sc.nextInt();
                    arbol.eliminar(idEliminar);
                    System.out.println("empleado con ID " + idEliminar + " eliminado (si existía).");
                    break;

                case 4:
                    System.out.println("lista de todos los empleados (Inorden):");
                    arbol.inorden();
                    break;

                case 5:
                    System.out.println("saliendo del sistema..");
                    break;

                default:
                    System.out.println("opción inválida, intente de nuevo");
            }
        } while (opcion != 5);

        sc.close();
    }
}
