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
 * Servlet implementation class Buscar
 */
@WebServlet("/Buscar")
public class Buscar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtener contexto del servlet...
		ServletContext contexto=request.getServletContext();
		//Establecer dao necesario para la ejecución del servlet... (se van a gestionar datos de la database)
		DAOViaje dao=new DAOViaje();
		
		//Iniciar variable de session
		HttpSession sesion=request.getSession();
		
		//Obtener ArrayList de la sesión con atributo favoritos
		ArrayList<Viaje> favoritos=(ArrayList<Viaje>)sesion.getAttribute("favoritos");
		
		//Si favoritos no existe, crear el ArrayList vacio e instanciarlo como sesión
		if(favoritos==null){
			favoritos=new ArrayList<Viaje>();
			sesion.setAttribute("favoritos",favoritos);
		}
		
		//obtener valores del formulario...
		String palabra=(String)request.getAttribute("palabra");
		
		//Rellenar ArrayList con el contenido de la query
		ArrayList<Viaje> lista=dao.buscar(palabra);
		
		//Establecer atributo de respuesta con el contenido del ArrayList
		request.setAttribute("lista",lista);
		
		//Ejecutar vista a mostrar
		RequestDispatcher dispatcher=contexto.getRequestDispatcher("/buscar.jsp");
		dispatcher.forward(request,response);
	}//Fin de doGet

	// -----------------------------------------------------------------------------------------------------------------------
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}//Fin de Servlet Buscar
