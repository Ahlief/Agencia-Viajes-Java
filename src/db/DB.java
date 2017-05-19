package db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 
 * Clase para establecer la conexión a la base de datos
 * 
 * @author Óscar G.
 *
 */
public class DB {

	/**
	 * Establece y Devuelve una conexión a la base de datos con un contexto determinado.
	 * 
	 * @return 		Conexión a la base de datos
	 */
	public static Connection getConexion(){
		Connection conexion=null;
		try {
			Context initContext = new InitialContext();										//Inicializar contexto
			Context envContext  = (Context)initContext.lookup("java:/comp/env");			//Establecer entorno 
			DataSource dataSource = (DataSource)envContext.lookup("jdbc/AgenciaViajes");	//Indicar contexto de conexión a la base de datos
			conexion = dataSource.getConnection();											//Obtener conexión
			
		//Trabajando las excepciones...	
		} catch (NamingException e) {
			e.printStackTrace();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return conexion;		//Retornar la conexión para poder operar con la base de datos
	}//Fin getConexion
	
}//Fin Class DB
