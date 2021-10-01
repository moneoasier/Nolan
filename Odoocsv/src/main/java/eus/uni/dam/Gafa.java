package eus.uni.dam;

import java.util.List;
import java.util.Objects;

public class Gafa {
	private String id;
	private String nombre;
	private int precio;



	public Gafa(String id, String nombre, int precio) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;

		//this.material = material;
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

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	/*
	 * public List<String> getTipo() { return tipo; }
	 * 
	 * public void setTipo(List<String> tipo) { this.tipo = tipo; }
	 * 
	 * public String getMaterial() { return material; }
	 * 
	 * public void setMaterial(String material) { this.material = material; }
	 */



	@Override
	public String toString() {
		return id.toString() +","+nombre+","+precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, precio);
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
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre) && precio == other.precio;
	}

}
