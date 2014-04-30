package fr.demos.formation.sigdv.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class TraceFilter
 */
@WebFilter("/*")
public class TraceFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TraceFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("entrée dans l'application");
		long debut =System.currentTimeMillis();
   
		// pass the request along the filter chain
		chain.doFilter(request, response);
		// en retour de la requête
		System.out.println("sortie de l'application");
		long fin = System.currentTimeMillis();
		System.out.println("l'execution à durée : "+(fin-debut));
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
