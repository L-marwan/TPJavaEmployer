package app.model;

import java.time.LocalDate;
import java.util.Date;

public class Employer extends Personne{
	
	private String mPost;
	private int    mSalaire;
	
	/*-- constructors --*/
	
	public Employer() { }
	
	public Employer(String nom, String prenom){
		super(nom,prenom);
	}
	
	public Employer(String nom, String prenom, LocalDate date){
		super(nom,prenom, date);
	}
	
	public Employer(String nom, String prenom, LocalDate date,String post){
		super(nom,prenom, date);
		mPost = post;
	}
	
	public Employer(String nom, String prenom, LocalDate date,String post, int salaire){
		super(nom,prenom, date);
		mPost    = post;
		mSalaire = salaire;
	}
	
	public Employer(String nom, String prenom, LocalDate date,int salaire){
		super(nom,prenom, date);
		mSalaire = salaire;
	}
	
	/*--getters and setters --*/

	public String getPost() {
		return mPost;
	}

	public void setPost(String mPost) {
		this.mPost = mPost;
	}

	public Integer getSalaire() {
		return mSalaire;
	}

	public void setSalaire(int mSalaire) {
		this.mSalaire = mSalaire;
	}
	
	

}
