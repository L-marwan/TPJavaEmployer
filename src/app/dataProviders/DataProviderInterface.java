package app.dataProviders;

import java.util.ArrayList;

import app.model.Employer;

public interface DataProviderInterface {

	
	public ArrayList<Employer> getEmployers();
	public Employer getEmployerByNames(String nom,String prenom);
	
}
