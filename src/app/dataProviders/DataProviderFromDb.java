package app.dataProviders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import app.db.DBConnection;
import app.model.Employer;
import app.util.IdGenerator;

public class DataProviderFromDb implements DataProviderInterface{

	@Override
	public ArrayList<Employer> getEmployers() throws Exception{
		
		ArrayList<Employer> result = new ArrayList<>();
		Connection dbConn = null;
		try{
			try{
				dbConn = DBConnection.createConnection();
			} catch (Exception e){
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			String query = "SELECT * FROM employee";
			ResultSet res = stmt.executeQuery(query);
			while(res.next()){
				
				String id = res.getString(1);
				String nom = res.getString(2);
				String prenom = res.getString(3);
				String poste = res.getString(4);
				int salaire = res.getInt(5);
				
				result.add(new Employer(nom, prenom, poste, salaire));
			}
		} catch (SQLException sqle){
			throw sqle;
		} catch (Exception e) {
			if(dbConn != null){
				dbConn.close();
			}
			throw e;
		} finally {
			if(dbConn != null){
				dbConn.close();
			}
		}
		
		return result;
	}
	
	@Override
	public Employer getEmployerByNames(String nom, String prenom)throws Exception {
		Employer result = new Employer();
		Connection dbConn = null;
		try{
			try{
				dbConn = DBConnection.createConnection();
			} catch (Exception e){
				e.printStackTrace();
			}
			PreparedStatement stmt = dbConn.prepareStatement("SELECT * FROM `employee` WHERE `nom` = ? AND `prenom` = ?");
			stmt.setString(1, nom);
			stmt.setString(2, prenom);
			System.out.println(stmt.toString());
			ResultSet res = stmt.executeQuery();
			while(res.next()){
				String id = res.getString(1);
				String mNom = res.getString(2);
				String mPrenom = res.getString(3);
				String poste = res.getString(4);
				int salaire = res.getInt(5);
				
				result = new Employer(nom, prenom, poste, salaire);
			}
		} catch (SQLException sqle){
			throw sqle;
		} catch (Exception e) {
			if(dbConn != null){
				dbConn.close();
			}
			throw e;
		} finally {
			if(dbConn != null){
				dbConn.close();
			}
		}
		
		return result;
	}

	@Override
	public void addEmployer(Employer emp) throws Exception {
		Connection dbConn = null;
		String insertSQL =  "INSERT INTO `employee`(`id`, `nom`, `prenom`, `poste`,`salaire` ) VALUES "
				+ "(?,?,?,?,?)";
		try{
			try{
				dbConn = DBConnection.createConnection();
			} catch (Exception e){
				e.printStackTrace();
			}
			
			PreparedStatement preparedStatement = dbConn.prepareStatement(insertSQL);
			preparedStatement.setString(1,IdGenerator.generate());
			preparedStatement.setString(2, emp.getNom());
			preparedStatement.setString(3,emp.getPrenom());
			preparedStatement.setString(4,emp.getPost());
			preparedStatement.setInt(5, emp.getSalaire());
			
			preparedStatement.executeUpdate();
			System.out.println("order item added!!");
			
			
		} catch (SQLException sqle){
			printSQLException(sqle);
		} catch (Exception e) {
			if(dbConn != null){
				dbConn.close();
			}
			throw e;
		} finally {
			if(dbConn != null){
				dbConn.close();
			}
		}
		
	}
	
	
	
	//helper method 
	public static void printSQLException(SQLException ex) {

	    for (Throwable e : ex) {
	        if (e instanceof SQLException) {


	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " +
	                    ((SQLException)e).getSQLState());

	                System.err.println("Error Code: " +
	                    ((SQLException)e).getErrorCode());

	                System.err.println("Message: " + e.getMessage());

	                Throwable t = ex.getCause();
	                while(t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	     
	    }
	}
	
	
	

}
