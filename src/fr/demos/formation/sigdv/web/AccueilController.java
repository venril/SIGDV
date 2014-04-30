package fr.demos.formation.sigdv.web;

import java.io.IOException;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.formation.sigdv.*;
import fr.demos.formation.sigdv.model.Fournisseur;
import fr.demos.formation.sigdv.model.Produit;
import fr.demos.formation.sigdv.model.ProduitDAOMySQL;
/*

import fr.g2l2corp.model.FournisseurDAOJPA;

import fr.g2l2corp.model.ProduitDAOJPA; */


/**
 * Servlet implementation class AccueilController
 */
@WebServlet("/")
public class AccueilController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
    private ProduitDAOMySQL produitdao=new ProduitDAOMySQL();
    //private FournisseurDAOMySQL fournisseurdao= new FournisseurDAOSQL();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueilController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getPathInfo().equals("/depovente/")) {
			//Collection<Produit> liste =produitdao.findAll();
			RequestDispatcher rd = request
					.getRequestDispatcher("/menuAccueil.jsp");
			rd.forward(request, response);
		}
		if (request.getPathInfo().equals("/depotvente/#")) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/menuAccueil.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action= request.getParameter("action");
		Collection<Produit> listeProduit=null;
		Collection<Fournisseur> listeFournisseur=null;
		RequestDispatcher rd= request.getRequestDispatcher("/menuAccueil.jsp");
		
		// navigation menu accueil
		if (action!=null && action.equals("produit")) {
			try {
			//listeProduit =produitdao.findAll();
			rd =  request.getRequestDispatcher("/listeProduits.jsp");
			request.setAttribute("listeProduit",listeProduit);
			rd.forward(request, response);
			}	catch(Exception e){
					e.printStackTrace();
					System.out.println("selection de produit NOK");
				}
		
			
			return;
		}
		if (action!=null && action.equals("fournisseur")) {
			//listeFournisseur =fournisseurdao.findAll();
			request.setAttribute("Listefournisseur",listeProduit);
			rd = request.getRequestDispatcher("/listeFournisseurs.jsp");
			
			rd.forward(request, response);
			return;
		}
		if (action!=null && action.equals("vente")) {
			//Collection<Fournisseur> liste =fournisseurdao.findAll();
			//request.setAttribute("Listefournisseur",liste);
			rd = request.getRequestDispatcher("/listeVente.jsp");
			rd.forward(request, response);
			return;
		}
		// navigation liste produit
		if (action!=null && action.equals("creaproduit")) {
			
			 rd = request.getRequestDispatcher("/produit.jsp");
			rd.forward(request, response);
			return;
		}
		if (action!=null && action.equals("enregistrerproduit")) {
			
			System.out.println("entré dans enregistrer produit");
			String nom = request.getParameter("nomProduit");
			String prix = request.getParameter("prixUnitaire");
			String fournisseur = request.getParameter("fournisseur");
			System.out.println(fournisseur);
			String quantite =request.getParameter("quantite");
			String lot = request.getParameter("lot");
			
			
			double prixUnitaire=0;
			int iquantite=0;
			Fournisseur fourni;
			boolean blot=true;
			try {
				
				prixUnitaire = Integer.parseInt(prix);
				iquantite=Integer.parseInt(quantite);
				blot=Boolean.getBoolean(lot);
			}catch(NumberFormatException ex){
				System.out.println("erreur de conversion ligne "+ex.getMessage());
			}
			fourni= new Fournisseur(fournisseur);
			
			//Produit oproduit=new Produit(nom,prixUnitaire,fourni,iquantite,blot);
			// (String nom, double prixunitaire, Fournisseur fournisseur,int quantite, boolean lot)
			System.out.println("produit");
			try {
				//produitdao.create(produit);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("creation de produit non faite");
			}
			System.out.println("creation de produit faite");
		 rd = request.getRequestDispatcher("/produit.jsp");
			rd.forward(request, response);
			return;
		}
		if (action!=null && action.equals("modiproduit")) {
			 rd = request.getRequestDispatcher("/fournisseur.jsp");
			rd.forward(request, response);
			return;
		}
		if (action!=null && action.equals("suppproduit")) {
			 rd = request.getRequestDispatcher("/fournisseur.jsp");
			rd.forward(request, response);
			return;
		}
		// navigation  liste fournisseur
		if (action!=null && action.equals("creafourni")) {
			rd = request.getRequestDispatcher("/fournisseur.jsp");
			rd.forward(request, response);
			return;
		}
		
		if (action!=null && action.equals("modifourni")) {
			rd = request.getRequestDispatcher("/fournisseur.jsp");
			rd.forward(request, response);
			return;
		}
		if (action!=null && action.equals("suppfourni")) {
			 rd = request.getRequestDispatcher("/fournisseur.jsp");
			rd.forward(request, response);
			return;
		}
		
		 rd = request.getRequestDispatcher("/menuAccueil.jsp");
		rd.forward(request, response);
		return;
	}

}
