package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOViaje;
import models.Viaje;

/**
 * Servlet implementation class IntroducirFavoritos
 */
@WebServlet("/Favoritos")
public class Favoritos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtener el contexto del servlet
		ServletContext contexto=request.getServletContext();
		
		
		//Iniciar variable de session
		HttpSession sesion=request.getSession();
		
		//Obtener ArrayList de la sesión con atributo favoritos
		ArrayList<Viaje> favoritos=(ArrayList<Viaje>)sesion.getAttribute("favoritos");
		
		//Si favoritos no existe, crear el ArrayList vacio e instanciarlo como sesión
		if(favoritos==null){
			favoritos=new ArrayList<Viaje>();
			sesion.setAttribute("favoritos",favoritos);
		}
		
		//Obtener el viaje que ha sido indicado como favorito mediante la id obtenida desde la url
		String stId=request.getParameter("id");
		int id=Integer.parseInt(stId);
		
		DAOViaje dao=new DAOViaje();	//Crear objeto dao para gestionar la petición
		Viaje viaje=dao.getViaje(id);	//Establecer objeto viaje con los datos obtenidos del dao
		
		//Si el favorito no existía previamente añadirlo
		String favmessage =	"No se ha pdido añadir el Viaje a "+ viaje.getDestino() +" a favoritos porque ya existe";
		if(! favExist(viaje, favoritos)){
			favoritos.add(viaje);
			favmessage = "Viaje a "+ viaje.getDestino() +" añadido a favoritos con éxito";
		}
		
		//Establecer mensaje de la operacion de añadir favorito...
		request.setAttribute("favmessage", favmessage);
		
		//Cargar vista a mostrar
		RequestDispatcher dispatcher=contexto.getRequestDispatcher("/introducirFavorito.jsp");
		dispatcher.forward(request,response);
	}//Fin de doGet

	// -----------------------------------------------------------------------------------------------------------------------
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	// -----------------------------------------------------------------------------------------------------------------------
		
	/**
	 * Comprobar si el viaje existe ya entre los favoritos
	 * 
	 * @param viaje			Viaje a añadir
	 * @param favoritos		Lista de favoritos ya añadidos
	 * @return				true si el favorito ya estaba introducido false si no
	 */
	private boolean favExist(Viaje viaje, ArrayList<Viaje> favoritos){
		for(Viaje fav : favoritos){
			if(fav.getId() == viaje.getId()){
				return true;
			}
		}
		return false;
	}//Fin de favExist
	
}//Fin de Servlet Favoritos
