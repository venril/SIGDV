package fr.demos.formation.sigdv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fr.demos.formation.sigdv.model.DAOException;

public class UtilisateurDAOMySQL implements UtilisateurDAO {
	private static final String FINDALL_user = "SELECT *  FROM user";
	
	private static final String FINDALBYPROP_utilisateur = "SELECT * FROM utilisateur ";
	private static final String AUTHENTIF = " select * from utilisateur where pseudo=? and password=?";
	DataSource ds=null;
	
	public UtilisateurDAOMySQL() {
		Context ic = null;
		
		try {
			ic = new InitialContext();
			//ds = (DataSource) ic.lookup("jdbc/dvdtheque");
			ds = (DataSource) ic.lookup("jdbc/sigdv");
		} catch (NamingException e) {
			System.out.println("pas de datasource");
		}
	}
	@Override
	public Utilisateur verif(String pseudo, String pwd) {
		// TODO Auto-generated method stub
		Utilisateur utilisateur=null;
		
		try(Connection cx = ds.getConnection();) {
			
			//System.out.println(insertDVD);
			PreparedStatement stmt = cx.prepareStatement(AUTHENTIF) ;
			stmt.setString(1,pseudo);
			stmt.setString(2,pwd);
			
			
			//int result = stmt.executeUpdate("INSERT 'dvd' VALUES "+d.getISBN()+","+d.getIntitule()+")");
			ResultSet rs =stmt.executeQuery();
			if(rs.next()){
				 utilisateur = new Utilisateur(rs.getString(1),pseudo,pwd);
				 System.out.println("result utilisateur dao"+utilisateur);
				return utilisateur;
			}
			
		}catch(SQLException es){
			es.printStackTrace();
			throw new DAOException(es.getMessage(), es);
		}finally{
			try{
				Connection cx = ds.getConnection();
				if (cx != null) {
					cx.close();
				}
			}catch (SQLException es){
				throw new DAOException(es.getMessage(), es);	
			}
		}
		return null;
	}

	@Override
	public void create(Utilisateur d) throws DAOException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Utilisateur d) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Utilisateur d) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Utilisateur> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
