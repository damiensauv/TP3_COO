package Hopital;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Specialiste {

	String name;
	Speciality speciality;

	public Specialiste(String name, Speciality speciality) {
		super();
		this.name = name;
		this.speciality = speciality;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Specialiste [name=" + name + ", speciality=" + speciality + "]";
	}

	public void makeReport(Patient patient, Speciality speciality) throws IOException {
		Report report = new Report();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Date report : ");
		String s = br.readLine();
		report.setDate(s);
		report.setNomSpe(this.getName());
		System.out.println("Enter comment : ");
		s = br.readLine();
		report.setCommentaire(s);
		
		patient.addReportCurrentCard(report);
		patient.addReportScoreCard(report);

		patient.getResidenceCard().deleteSpe(speciality);
		
	}
	
	
}
