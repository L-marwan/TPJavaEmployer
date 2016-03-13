package app.dataProviders;

import java.util.ArrayList;

import app.model.Employer;

/*
 * interface to give access to data to the views without caring about the source
 */
public interface DataProviderInterface {

	
	public ArrayList<Employer> getEmployers() throws Exception;
	public Employer getEmployerByNames(String nom,String prenom) throws Exception;
	public void addEmployer(Employer emp) throws Exception;
	
}
