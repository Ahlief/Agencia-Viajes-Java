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
 * Servlet implementation class Listar
 */
@WebServlet("/Listar")
public class Listar extends HttpServlet {
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
		
		//Establecer el ArrayList que contendrá los viajes resultantes del método dao...
		ArrayList<Viaje> viajes=dao.listar();
		request.setAttribute("lista", viajes);	//Estabñecer un atributo de request con dicho listado de viajes
		
		//Ejecutar vista a mostrar
		RequestDispatcher dispatcher=contexto.getRequestDispatcher("/listar.jsp");
		dispatcher.forward(request,response);
	}//Fin de doGet

	// -----------------------------------------------------------------------------------------------------------------------
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}//Fin de Servlet Listar
