import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Producto> productos = new ArrayList<>();
        int opcion;

        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Menú de Productos");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Aplicar descuento");
            System.out.println("4. Vender unidades");
            System.out.println("5. Reponer unidades");
            System.out.println("6. Mostrar integrantes del equipo");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Entrada no válida.");
                scanner.nextLine();
                opcion = -1;
            } else {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
            }

            switch (opcion) {
                case 1:
                    mostrarMenuProductos(scanner, productos);
                    break;
                case 2:
                    mostrarInventario(productos);
                    break;
                case 3:
                    aplicarDescuento(scanner, productos);
                    break;
                case 4:
                    venderUnidades(scanner, productos);
                    break;
                case 5:
                    reponerUnidades(scanner, productos);
                    break;
                case 6:
                    mostrarIntegrantes();
                    break;
                case 7:
                    System.out.println("¡Gracias por usar el programa!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 7);

        scanner.close();
    }

    private static Producto capturarProducto(Scanner scanner) {
        System.out.println("\n=== Capturar Producto ===");
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el precio del producto: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Precio no válido. Intente de nuevo:");
            scanner.nextLine();
        }
        double precio = scanner.nextDouble();

        System.out.print("Ingrese la cantidad en inventario: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Cantidad no válida. Intente de nuevo:");
            scanner.nextLine();
        }
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setCantidad(cantidad);

        System.out.println("¡Producto capturado exitosamente!");
        return producto;
    }

    private static void mostrarInventario(List<Producto> productos) {
        System.out.println("\n=== Inventario Actual ===");
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
            return;
        }
        for (int i = 0; i < productos.size(); i++) {
            System.out.println("\nProducto " + (i + 1) + ":");
            System.out.println(productos.get(i).toString());
        }
    }

    private static void aplicarDescuento(Scanner scanner, List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos para aplicar descuento.");
            return;
        }
        System.out.println("\n=== Aplicar Descuento ===");
        int idx = seleccionarProducto(scanner, productos);
        System.out.print("Ingrese el porcentaje de descuento (0-100): ");
        double descuento = obtenerDoubleEnRango(scanner, 0, 100);

        Producto productoSeleccionado = productos.get(idx);
        double precioOriginal = productoSeleccionado.getPrecio();
        double precioConDescuento = precioOriginal - (precioOriginal * (descuento / 100));
        productoSeleccionado.setPrecio(precioConDescuento);

        System.out.println("¡Descuento aplicado exitosamente!");
    }

    private static void venderUnidades(Scanner scanner, List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos para vender.");
            return;
        }
        System.out.println("\n=== Vender Unidades ===");
        int idx = seleccionarProducto(scanner, productos);
        System.out.print("Ingrese la cantidad a vender: ");
        int cantidadVender = obtenerEntero(scanner, 0, Integer.MAX_VALUE);

        Producto productoSeleccionado = productos.get(idx);
        if (cantidadVender <= productoSeleccionado.getCantidad()) {
            productoSeleccionado.setCantidad(productoSeleccionado.getCantidad() - cantidadVender);
            System.out.println("¡Venta realizada exitosamente!");
        } else {
            System.out.println("Error: No hay suficientes unidades en inventario.");
        }
    }

    private static void reponerUnidades(Scanner scanner, List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos para reponer.");
            return;
        }
        System.out.println("\n=== Reponer Unidades ===");
        int idx = seleccionarProducto(scanner, productos);
        System.out.print("Ingrese la cantidad a reponer: ");
        int cantidadReponer = obtenerEntero(scanner, 0, Integer.MAX_VALUE);

        Producto productoSeleccionado = productos.get(idx);
        productoSeleccionado.setCantidad(productoSeleccionado.getCantidad() + cantidadReponer);
        System.out.println("¡Unidades repuestas exitosamente!");
    }

    private static void mostrarMenuProductos(Scanner scanner, List<Producto> productos) {
        int opcionProducto;
        do {
            System.out.println("\n=== MENÚ DE PRODUCTOS ===");
            System.out.println("1. Crear nuevo producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Regresar al menú principal");
            System.out.print("Seleccione una opción: ");

            opcionProducto = obtenerEntero(scanner, 1, 3);

            switch (opcionProducto) {
                case 1:
                    Producto nuevo = capturarProducto(scanner);
                    productos.add(nuevo);
                    break;
                case 2:
                    mostrarInventario(productos);
                    break;
                case 3:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcionProducto != 3);
    }

    private static int seleccionarProducto(Scanner scanner, List<Producto> productos) {
        System.out.println("Seleccione el producto:");
        for (int i = 0; i < productos.size(); i++) {
            System.out.println((i + 1) + ". " + productos.get(i).getNombre());
        }
        System.out.print("Ingrese el número del producto: ");
        int seleccion = obtenerEntero(scanner, 1, productos.size());
        return seleccion - 1; // devolver índice 0-based
    }

    private static void mostrarIntegrantes() {
        System.out.println("\n=== Integrantes del Equipo ===");
        System.out.println("1. Manuel Enquique Garcia Neve");
        System.out.println("   2193077979");
        System.out.println("2. Ian");
        System.out.println("   (info faltante)");
        System.out.println("3. Luis");
        System.out.println("   (info faltante)");
    }

    // Helpers para validación de entrada
    private static int obtenerEntero(Scanner scanner, int min, int max) {
        int val;
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Entrada no válida. Intente de nuevo:");
                scanner.nextLine();
                continue;
            }
            val = scanner.nextInt();
            scanner.nextLine();
            if (val < min || val > max) {
                System.out.println("Debe ingresar un número entre " + min + " y " + max + ". Intente de nuevo:");
                continue;
            }
            return val;
        }
    }

    private static double obtenerDoubleEnRango(Scanner scanner, double min, double max) {
        double val;
        while (true) {















}    }        }            return val;            }                continue;                System.out.println("Valor fuera de rango. Intente de nuevo:");            if (val < min || val > max) {            scanner.nextLine();            val = scanner.nextDouble();            }                continue;                scanner.nextLine();                System.out.println("Entrada no válida. Intente de nuevo:");            if (!scanner.hasNextDouble()) {            if (!scanner.hasNextDouble()) {
                System.out.println("Entrada no válida. Intente de nuevo:");
                scanner.nextLine();
                continue;
            }
            val = scanner.nextDouble();
            scanner.nextLine();
            if (val < min || val > max) {
                System.out.println("Valor fuera de rango. Intente de nuevo:");
                continue;
            }
            return val;
        }
    }
}
