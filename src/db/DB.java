package db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 
 * Clase para establecer la conexi�n a la base de datos
 * 
 * @author �scar G.
 *
 */
public class DB {

	/**
	 * Establece y Devuelve una conexi�n a la base de datos con un contexto determinado.
	 * 
	 * @return 		Conexi�n a la base de datos
	 */
	public static Connection getConexion(){
		Connection conexion=null;
		try {
			Context initContext = new InitialContext();										//Inicializar contexto
			Context envContext  = (Context)initContext.lookup("java:/comp/env");			//Establecer entorno 
			DataSource dataSource = (DataSource)envContext.lookup("jdbc/AgenciaViajes");	//Indicar contexto de conexi�n a la base de datos
			conexion = dataSource.getConnection();											//Obtener conexi�n
			
		//Trabajando las excepciones...	
		} catch (NamingException e) {
			e.printStackTrace();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return conexion;		//Retornar la conexi�n para poder operar con la base de datos
	}//Fin getConexion
	
}//Fin Class DB
