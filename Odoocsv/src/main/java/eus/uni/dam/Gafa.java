package eus.uni.dam;

import java.util.Objects;

public class Gafa {
	private String id;
	private String nombre;
	private double precio;
	private int stock;

	public Gafa(String id, String nombre, double precio, int stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}

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

	@Override
	public String toString() {
		return id.toString() +","+nombre+","+precio+","+stock;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, precio, stock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gafa other = (Gafa) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre) && precio == other.precio
				&& stock == other.stock;
	}


}
