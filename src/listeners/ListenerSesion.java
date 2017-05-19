package listeners;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class ListenerSesion
 *
 */
@WebListener
public class ListenerSesion implements HttpSessionListener {
	/*
	 * -----------------------------------------------------------------------------------------
	 * Constructors
	 * ----------------------------------------------------------------------------------------- 
	 */
		
    /**
     * Default constructor. 
     */
    public ListenerSesion() {  }

	/*
	 * -----------------------------------------------------------------------------------------
	 * Methods
	 * ----------------------------------------------------------------------------------------- 
	 */
    
	/**
	 * Método ejecutado al crear una sesión el cual establecerá un atributo con el conteo de usuarios
	 * Totales conectados actualmente al servidor
	 * 
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	
        ServletContext contexto=se.getSession().getServletContext();	//Obtener contexto de sesiones 
        
        synchronized(contexto){			//synchronized para manejar los threads...
        	
        	//Establecer un integet con el valor actual de la sesión numeroUsuarios
        	Integer numeroUsuarios=(Integer)contexto.getAttribute("numeroUsuarios");
        	//Sumar 1 al contador de usuarios conectados actualmente
        	numeroUsuarios++;
        	
        	//Establecer nuevamente el atributo con el valor modificado
        	contexto.setAttribute("numeroUsuarios",numeroUsuarios);	
        }
    }//Fin sessionCreated

    // -----------------------------------------------------------------------------------------
    
	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { }
	
}//Fin Listener ListenerSesion
