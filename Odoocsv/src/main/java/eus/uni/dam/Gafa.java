package eus.uni.dam;

import java.util.Objects;


//Gafa klasea
public class Gafa {
	//Klasearen parametroak
	private String id;
	private String nombre;
	private double precio;
	private int stock;
	private String category;
	
	//Klasearen konstruktorea
	public Gafa(String id, String nombre, double precio, int stock,String category) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.category=category;
	}
	//Get eta Set metodoak

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	//toString metodoa
	@Override
	public String toString() {
		return id.toString() +","+nombre+","+precio+","+stock+","+category;
	}
	
	//hashCode metodoa, objetuen estruktura konparatzen du
	@Override
	public int hashCode() {
		return Objects.hash(category, id, nombre, precio, stock);
	}
	
	//equals metodoa, metodo honek bi objetu konparatzen ditu datu berdinak dituzten jakiteko
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gafa other = (Gafa) obj;
		return Objects.equals(category, other.category) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio) && stock == other.stock;
	}

	


}
