package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
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
 * Servlet implementation class Inicio
 */
@WebServlet("/Inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		//Obtener contexto del servlet...
		ServletContext contexto=config.getServletContext();
		
		//Establecer dao necesario para la ejecución del servlet... (se van a gestionar datos de la database)
		DAOViaje dao=new DAOViaje();
		
		//Indicar qué viaje estará en promoción
		Viaje promocion=dao.getViaje(1);
		
		//Aplicar el objeto como atributo de contexto
	    contexto.setAttribute("promocion", promocion);
	    
	    //Aplicar el número de usuarios conectados actualmente al servlet
		Integer numeroUsuarios=new Integer(0);
		contexto.setAttribute("numeroUsuarios",numeroUsuarios);
	}//Fin de init

	// -----------------------------------------------------------------------------------------------------------------------
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Obtener contexto del servlet...
		ServletContext contexto=request.getServletContext();
		
		//iniciar objeto HttpSession (esto desencadenará el listener que añadirá 1 a la sesión del servlet)
		HttpSession sesion=request.getSession();
		
		//Ejecutar vista a mostrar
		RequestDispatcher dispatcher=contexto.getRequestDispatcher("/inicio.jsp");
		dispatcher.forward(request,response);
	}//Fin de doGet

	// -----------------------------------------------------------------------------------------------------------------------
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}//Fin de Servlet Inicio
