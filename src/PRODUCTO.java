/***************************************************************************

AUTORES: 
	1. SANTIAGO DELGADILLO IAN JAIR / 2203027063.
	2. 
	3. 
FECHA: 03/NOVIEMBRE/2025.
DESCRIPCION: 

***************************************************************************/

public class Producto {
	
	//Atributos 
	
	String Nombre;
	double Precio;
	int Cantidad;
	String Categoria;
	boolean Disponible;
	
	//Método constructor
	
	public Producto (String Nombre, double Precio, int Cantidad, String Categoria, boolean Disponible) {
	this.Nombre=Nombre;
	this.Precio=Precio;
	this.Cantidad=Cantidad;
	this.Categoria=Categoria;
	this.Disponible=Disponible;
	}
	
	//Metodos get y set

	public String getnombre() {
		return Nombre;
	}
	public void setnombre(String Nombre) {
		this.Nombre=Nombre;
	}
	public double getprecio() {
		return Precio;
	}
	public void setprecio(double Precio) {
		this.Precio=Precio;
	}
	public int getcantidad() {
		return Cantidad;
	}
	public void setcantidad(int Cantidad) {
		this.Cantidad=Cantidad;
	}
	public String getcategoria() {
		return Categoria;
	}
	public void setcategoria(String Categoria) {
		this.Categoria=Categoria;
	}
	public boolean getdisponible() {
		return Disponible;
	}
	public void setdisponible(boolean Disponible) {
		this.Disponible=Disponible;
	}
	
	//Metodos adicionales

	public void mostrarInformacion() {
		System.out.println("Estos son los datos del producto: ");
		System.out.println("Nombre del producto: "+Nombre);
		System.out.println("Precio del producto: "+Precio);
		System.out.println("Cantidad ingresada del producto: "+Cantidad);
		System.out.println("Categoria donde entra el producto: "+Categoria);
		System.out.println("Unidades disponibles del producto: "+Disponible);
	}
	public void aplicarDescuento(double porcentaje) {
		if(porcentaje > 0 && porcentaje <= 100) {
			double Descuento = Precio * (porcentaje/100);
			Precio -= Descuento;
			System.out.println("Tienes un descuento de: "+porcentaje+"%");
			System.out.println("Nueva cantidad a pagar: $"+Precio+" MXN");
		} else {
			System.out.println("Ingresa otro valor");
		}
	}
	public void vender(int unidades) {
		if(unidades > 0 && unidades <= Cantidad) {
			Cantidad -= unidades;
			System.out.println("Se vendieron: "+unidades+" unidades");
			System.out.println("Quedan: "+Cantidad+" unidades en el inventario");
		} else if (unidades > Cantidad){
			System.out.println("No podemos realizar la venta. Faltan unidades en nuestro inventario);
		} else {
			System.out.println("Ingresa otro valor");
		}
	}
	public void reponer(int unidades) {
		if (unidades > 0) {
			Cantidad += unidades;
			System.out.println("Se agregaron "+unidades+" unidades a nuestro inventario");
			System.out.println("Actualizacion: Tenemos "+Cantidad+" unidades en nuestro inventario");
		} else {
			System.out.println("Ingresa otro valor");
		}
	}
	public void verificarDisponibilidad() {
		Disponible = Cantidad > 0;
	}
}