package fr.demos.formation.sigdv.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.demos.formation.sigdv.model.*;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		// on test si il y a l'objet utilisateur dans la session
		HttpSession session = ((HttpServletRequest) request).getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		String Nom = (String) session.getAttribute("Nom");
		String Prenom = (String) session.getAttribute("Prenom");
		System.out.println("entré filter");
		if (utilisateur != null){
			try{
				System.out.println("authentifié");
				
				chain.doFilter(request, response);
				
			
			}catch(Throwable t) {
				t.printStackTrace();
			}
			return;
		}
		if (utilisateur == null) {
			//si il n'y a pas d'utilisateur - utilisateur=null, c'est qu'il n'est pas connecté
			System.out.println("pseudo nul : pas connecté");
			String pseudoparam = request.getParameter("login");
			
			if (pseudoparam != null && !pseudoparam.equals("")) {
				// si l'utilisateur essaye de se connecter(ie rentre login/ mot de passe)
				//on test si le login et le mot de passe est bon.
				System.out.println("Le login est entré");
				String motdepasseparam = request.getParameter("motdepasse");
				
				UtilisateurDAOMySQL authentifuser = new UtilisateurDAOMySQL();
				
				Utilisateur veriflogin = authentifuser.verif(pseudoparam,motdepasseparam);
				System.out.println("Verification "+veriflogin);
				if (veriflogin == null) {
					// Si le mot de passe ou login n'est pas bon, on renvoi à la page d'authentification
					// avec un message d'alerte " mot de passe ou login incorrect"
					request.setAttribute("messageerror","mot de passe ou login incorrect");
					RequestDispatcher rd = request.getRequestDispatcher("/authentification.jsp");
					rd.forward(request, response);
					return;
					// mot de passe bon, on ajoute l'utilisateur dans la session
				} else {
					System.out.println("mot de passe correct");
					session.setAttribute("utilisateur",veriflogin);
					
					RequestDispatcher rd = request.getRequestDispatcher("/menuAccueil.jsp");
					rd.forward(request, response);
					
				}

			} else {
				RequestDispatcher rd = request
						.getRequestDispatcher("/authentification.jsp");
				rd.forward(request, response);

				return;
			}
		}
		try {
			chain.doFilter(request, response);
		} catch (Throwable t) {
			t.printStackTrace();
		}
		System.out.println("pseudo pas nul : connecté");
		// pass the request along the filter chain
		chain.doFilter(request, response);
		return;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
