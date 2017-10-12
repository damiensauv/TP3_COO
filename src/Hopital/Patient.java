package Hopital;

import java.util.ArrayList;
import java.util.List;

public class Patient {

	String numSecu;
	String name;
	String adresse;
	String age;
	ResidenceCard residenceCard; // sejour
	List<Report> currentReports;
	ScoreCard scoreCard;

	public Patient() {
		super();
		currentReports = new ArrayList<>();
		residenceCard = new ResidenceCard();
		this.scoreCard = new ScoreCard();
	}
	
	public Patient(String numSecu, String name, String adresse, String age) {
		super();
		this.numSecu = numSecu;
		this.name = name;
		this.adresse = adresse;
		this.age = age;
	}

	public void addReportCurrentCard(Report report) {
		this.getCurrentReports().add(report);
	}

	public void addReportScoreCard(Report report) {
		this.getScoreCard().getListReport().add(report);
	}

	public List<Report> getReports() {
		return currentReports;
	}

	public void setReports(List<Report> reports) {
		this.currentReports = reports;
	}

	public ResidenceCard getResidenceCard() {
		return residenceCard;
	}

	public void setResidenceCard(ResidenceCard residenceCard) {
		this.residenceCard = residenceCard;
	}

	public String getNumSecu() {
		return numSecu;
	}

	public void setNumSecu(String numSecu) {
		this.numSecu = numSecu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public List<Report> getCurrentReports() {
		return currentReports;
	}

	public void setCurrentReports(List<Report> currentReports) {
		this.currentReports = currentReports;
	}

	public ScoreCard getScoreCard() {
		return scoreCard;
	}

	public void setScoreCard(ScoreCard scoreCard) {
		this.scoreCard = scoreCard;
	}

	public void displayResidenceCard() {
		System.out.println("Patient : " + this.name + " Fiche de sejour : ");
		this.residenceCard.display();
	}

	public void displayReport() {
		System.out.println("Patient : " + this.name + " Compte Rendu en cours : ");
		if (this.currentReports.isEmpty()) {
			System.out.println("[]");
		} else {
			for (Report report : currentReports) {
				report.display();
			}
		}
	}

	public void displayFromSpe(String name) {
		System.out.println("Report History : ");
		this.getScoreCard().displayFromSpe(name);
	}

	public void deleteCurrentReport() {
		this.currentReports = new ArrayList<>();
	}

}
