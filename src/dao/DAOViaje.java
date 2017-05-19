package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import db.DB;
import models.Viaje;

/**
 * Clase para gestionar las operaciones SQL de la tabla viaje
 * 
 * @author Óscar G.
 *
 */
public class DAOViaje {

	/*
	 * --------------------------------------------------------------------------------------------
	 * CRUD Methods
	 * --------------------------------------------------------------------------------------------
	 */
	
	/**
	 * Read Viaje.
	 * 
	 * Obtiene los datos de un viaje mediante un identificador, si no hay un viaje coincidente
	 * con el parámetro el método devolverá null, si no, devolverá el objeto viaje con 
	 * las características obtenidas de la base de datos;
	 * 
	 * @param id	Identificador a buscar
	 * @return		null u objeto de tipo viaje con las caracteristicas del registro encontrado
	 */
	public Viaje getViaje(int id){
		Viaje v=null;	//Establecer el resultado por defaul
		
		String sql="select * from viajes where id=?";
		
		try(Connection con=DB.getConexion();
			PreparedStatement ps=con.prepareStatement(sql);){
			
			ps.setInt(1, id);					//Establecer los valores de cada "?"
			ResultSet rs=ps.executeQuery();		//Ejecutar la query ya preformateada
			
			if(rs.next()){						
				//Si hay registro crear objeto con los datos obtenidos...
				v=new Viaje(id, rs.getString("destino"), rs.getInt("duracion"), rs.getDouble("precio"));
			}
		
			rs.close();
			
		}
		//Tratando las excepciones...
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return v;
	}// Fin de getViaje
	
	// --------------------------------------------------------------------------------------------
	
	/**
	 * List all Viaje.
	 * 
	 * Obtiene los datos de todos los viajes registrados en la base de datos. y los devuelve
	 * como un ArrayList
	 * 
	 * @return		ArrayList de objetos de tipo viaje con las caracteristicas de los registros 
	 * 				encontrados
	 */
	public ArrayList<Viaje> listar(){
		//Establecer el Objeto a devolver...
		ArrayList<Viaje> lista=new ArrayList<Viaje>();
		
		String sql="select * from viajes";
		
		try(Connection con=DB.getConexion();
			
			Statement stm=con.createStatement();	//Crear Statement (no hay "?" a sustituir...)
			ResultSet rs=stm.executeQuery(sql);){	//Ejecutar la query
			
			//Si hay registros este bucle irá creando objetos con los datos resultantes
			while(rs.next()){
				Viaje v=new Viaje(rs.getInt("id"), rs.getString("destino"), rs.getInt("duracion"), rs.getDouble("precio"));
				lista.add(v);	//Añadir objeto del registro al ArrayList
			}
			
		}
		
		//Tratando las excepciones...
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return lista;
	}//Fin de listar
	
	// --------------------------------------------------------------------------------------------
	
	
	/**
	 * Read Viaje by Keyword.
	 * 
	 * Obtiene los datos de todos los viajes registrados en la base de datos que contengan la palabra
	 * que se pasa por parámetro en su destino y los devuelve como un ArrayList
	 * 
	 * @param palabra	Keyword a buscar en la columna "destino" de la base de datos
	 * @return
	 */
	public ArrayList<Viaje> buscar(String palabra){
		//Establecer el Objeto a devolver...
		ArrayList<Viaje> lista=new ArrayList<Viaje>();
		
		String sql="select * from viajes where destino like ?";
		
		try(Connection con=DB.getConexion();
			PreparedStatement ps=con.prepareStatement(sql);){
			
			ps.setString(1,"%"+palabra+"%");	//Establecer los valores de cada "?"
			ResultSet rs=ps.executeQuery();		//Ejecutar la query
			
			//Si hay registros este bucle irá creando objetos con los datos resultantes
			while(rs.next()){
				Viaje v=new Viaje(rs.getInt("id"), rs.getString("destino"), rs.getInt("duracion"), rs.getDouble("precio"));
				lista.add(v);	//Añadir objeto del registro al ArrayList
			}
			
			rs.close();
			
		}
		
		//Tratando las Excepciones
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return lista;
	}//Fin de buscar

}//Fin de Class DAOViaje
