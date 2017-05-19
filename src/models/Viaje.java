package models;

/**
 * Clase Viaje que consta de un identificador (id), destino duración y precio.
 * 
 * @author Óscar G.
 *
 */
public class Viaje {
	/*
	 * Attributes
	 */
	private int id;
	private String destino;
	private int duracion;
	private double precio;
	
	/*
	 * --------------------------------------------------------------------------------------------
	 * Constructors
	 * --------------------------------------------------------------------------------------------
	 */
	
	/**
	 * Empty Constructor
	 */
	public Viaje(){ }
	
	/**
	 * Param Constructor
	 * 
	 * @param id		Id del viaje
	 * @param destino	Lugar de destino del viaje
	 * @param duracion	Duración en días del viaje
	 * @param precio	Precio del viaje [Decimal(8,2) en la base de datos]
	 */
	public Viaje(int id,String destino,int duracion,double precio){
		this.id=id;
		this.destino=destino;
		this.duracion=duracion;
		this.precio=precio;
	}

	/*
	 * --------------------------------------------------------------------------------------------
	 * Getters & Setters
	 * --------------------------------------------------------------------------------------------
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// --------------------------------------------------------------------------------------------
	
	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	// --------------------------------------------------------------------------------------------
	
	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	// --------------------------------------------------------------------------------------------
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}	
	
}//Fin de Class Viaje
