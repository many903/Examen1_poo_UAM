/***************************************************************************
AUTORES: 
    1. SANTIAGO DELGADILLO IAN JAIR / 2203027063.
FECHA: 03/NOVIEMBRE/2025.
DESCRIPCION: Clase Producto corregida.
***************************************************************************/
public class Producto {
    
    // Atributos 
    private String Nombre;
    private double Precio;
    private int Cantidad;
    private String Categoria;
    private boolean Disponible;
    
    // Constructor con parámetros
    public Producto(String Nombre, double Precio, int Cantidad, String Categoria, boolean Disponible) {
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Cantidad = Cantidad;
        this.Categoria = Categoria;
        this.Disponible = Disponible;
    }
    
    // Constructor por defecto
    public Producto() {
        this("", 0.0, 0, "", false);
    }
    
    // Getters y setters
    public String getNombre() { return Nombre; }
    public void setNombre(String Nombre) { this.Nombre = Nombre; }

    public double getPrecio() { return Precio; }
    public void setPrecio(double Precio) { this.Precio = Precio; }

    public int getCantidad() { return Cantidad; }
    public void setCantidad(int Cantidad) { 
        this.Cantidad = Cantidad;
        verificarDisponibilidad();
    }

    public String getCategoria() { return Categoria; }
    public void setCategoria(String Categoria) { this.Categoria = Categoria; }

    public boolean isDisponible() { return Disponible; }
    public void setDisponible(boolean Disponible) { this.Disponible = Disponible; }
    
    // Métodos adicionales
    public void mostrarInformacion() {
        verificarDisponibilidad();
        System.out.println("Estos son los datos del producto:");
        System.out.println("Nombre: " + Nombre);
        System.out.println("Precio: " + Precio);
        System.out.println("Cantidad: " + Cantidad);
        System.out.println("Categoria: " + Categoria);
        System.out.println("Disponible: " + Disponible);
    }

    public void aplicarDescuento(double porcentaje) {
        if (porcentaje > 0 && porcentaje <= 100) {
            double descuento = Precio * (porcentaje / 100.0);
            Precio -= descuento;
            System.out.println("Descuento aplicado: " + porcentaje + "%");
            System.out.println("Nuevo precio: $" + Precio + " MXN");
        } else {
            System.out.println("Porcentaje inválido");
        }
    }

    public void vender(int unidades) {
        if (unidades > 0 && unidades <= Cantidad) {
            Cantidad -= unidades;
            verificarDisponibilidad();
            System.out.println("Se vendieron: " + unidades + " unidades");
            System.out.println("Quedan: " + Cantidad + " unidades");
        } else if (unidades > Cantidad) {
            System.out.println("No hay suficientes unidades para la venta");
        } else {
            System.out.println("Cantidad inválida");
        }
    }

    public void reponer(int unidades) {
        if (unidades > 0) {
            Cantidad += unidades;
            verificarDisponibilidad();
            System.out.println("Se agregaron " + unidades + " unidades");
            System.out.println("Total en inventario: " + Cantidad + " unidades");
        } else {
            System.out.println("Cantidad inválida");
        }
    }

    public void verificarDisponibilidad() {
        Disponible = Cantidad > 0;
    }

    @Override
    public String toString() {
        verificarDisponibilidad();
        return "Nombre: " + Nombre + "\nPrecio: " + Precio + "\nCantidad: " + Cantidad + "\nCategoria: " + Categoria + "\nDisponible: " + Disponible;
    }
}