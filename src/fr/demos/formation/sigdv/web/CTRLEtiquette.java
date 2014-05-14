package fr.demos.formation.sigdv.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.demos.formation.sigdv.model.DAOException;
import fr.demos.formation.sigdv.model.Etiquette;
import fr.demos.formation.sigdv.model.EtiquetteDAOMySQL;

/**
 * Servlet implementation class CTRLEtiquette
 */
@WebServlet("/CTRLEtiquette")
public class CTRLEtiquette extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/* Variables globales utiles */
	private EtiquetteDAOMySQL daoEtiquette = new EtiquetteDAOMySQL();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CTRLEtiquette() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Initialisation de la session:
		HttpSession session = request.getSession();
		// Liste des etiquettes:
		List<Etiquette> listeEtiquettes = null;
			
		String action = request.getParameter("action");
		// On a selectionné l'onglet "Etiquettes des produits" pour imprimer les etiquettes:
		
		if (action.equals("creeretiquette")) {
			try {
				listeEtiquettes = (List<Etiquette>) daoEtiquette.creerEtiquette();
			} catch (DAOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			request.setAttribute("listeEtiquettes", listeEtiquettes);
			RequestDispatcher rd = request.getRequestDispatcher("afficheretiquettes.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
				
	} // Fin doGet().

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
