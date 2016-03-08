package app.model;

import java.time.LocalDate;
import java.util.Date;

public class Personne {
	
	private String mNom;
	private String mPrenom;
	private LocalDate   mDateDeNaissance;
	
	/*-- constructors --*/
	
	public Personne(){ }
	
	public Personne(String nom, String prenom){
		mNom    = nom;
		mPrenom = prenom;
	}
	
	public Personne (String nom, String prenom, LocalDate date){
		mNom    		  = nom;
		mPrenom 	      = prenom;
		mDateDeNaissance  = date;
		
	}
	
	
	
	/*-- getters and setters --*/
	public String getNom() {
		return mNom;
	}
	public void setNom(String mNom) {
		this.mNom = mNom;
	}
	public String getPrenom() {
		return mPrenom;
	}
	public void setPrenom(String mPrenom) {
		this.mPrenom = mPrenom;
	}
	public LocalDate getDateDeNaissance() {
		return mDateDeNaissance;
	}
	public void setDateDeNaissance(LocalDate mDateDeNaissance) {
		this.mDateDeNaissance = mDateDeNaissance;
	}
	
	
	
	

}
