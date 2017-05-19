package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class FiltroValidarBusqueda
 */
@WebFilter("/Buscar")
public class FiltroValidarBusqueda implements Filter {
	/*
	 * -----------------------------------------------------------------------------------------
	 * Constructors
	 * ----------------------------------------------------------------------------------------- 
	 */
	
    /**
     * Default constructor. 
     */
    public FiltroValidarBusqueda() {   }

	/*
	 * -----------------------------------------------------------------------------------------
	 * Methods
	 * ----------------------------------------------------------------------------------------- 
	 */
    
	/**
	 * Apply Filter.
	 * Aplicará el filtro el cual se encargará de comprobar que la palabra introducida en la 
	 * búsqueda sea válida
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		ServletContext contexto=request.getServletContext();	//Obtener contexto del servlet
		String palabra=request.getParameter("palabra");			//Obtener parámetros del formulario
		
		if(palabra==null || palabra.trim().equals("")){			//Si la palabra es nula o está vacia no es válido...
			//Establecer vista de error y terminar el filtro
			RequestDispatcher dispatcher=contexto.getRequestDispatcher("/datosinvalidos.jsp");
			dispatcher.forward(request,response);
		}
		else{
			//Si la palabra introducida tiene contenido
			palabra=palabra.trim();
			//establecer como atributo resultante de la request y proseguir con la ejecución 
			request.setAttribute("palabra",palabra);
			chain.doFilter(request, response);
		}
		
	}// Fin de doFilter

	// ----------------------------------------------------------------------------------------- 
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException { }

}//Fin de Filter FiltroValidarBusqueda
