package Hopital;

public class Report {

	String date;
	String NomSpe;
	String Commentaire;
	
	public Report() {
		super();
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNomSpe() {
		return NomSpe;
	}
	public void setNomSpe(String nomSpe) {
		NomSpe = nomSpe;
	}
	public String getCommentaire() {
		return Commentaire;
	}
	public void setCommentaire(String commentaire) {
		Commentaire = commentaire;
	}
	public void display() {
		System.out.println("[Date] : " + date);
		System.out.println("[NomSpe] : " + NomSpe);
		System.out.println("[Commentaire] : " + Commentaire);
		System.out.println("----------------------");
	}
	
}
