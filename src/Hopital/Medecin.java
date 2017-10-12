package Hopital;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class Medecin {

	List<Patient> listPatients;
		
	public Medecin() {
		super();
		this.listPatients = new ArrayList<Patient>();
	}

	// Test if patien exist
	public boolean searchPatient(String numSecu) {	
		return listPatients.stream().filter(o -> o.getNumSecu().equals(numSecu)).findFirst().isPresent();
	}

	// Create Patient and return num secu
	public String createPatient() throws IOException {
		Patient patient = new Patient();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Number Secu : ");
		String numSecu = br.readLine();
		patient.setNumSecu(numSecu);
		
		System.out.println("Enter Name : ");
		String s = br.readLine();
		patient.setName(s);
		
		System.out.println("Enter Adresse : ");
		s = br.readLine();
		patient.setAdresse(s);
		
		System.out.println("Enter Age : ");
		s = br.readLine();
		patient.setAge(s);
		
		listPatients.add(patient);
		return numSecu;
	}

	// get Patient from list Patient
	public Patient getPatient(String numSecu) {
		return listPatients.stream().filter(o -> o.getNumSecu().equals(numSecu)).findFirst().get();
	}

	// Create ResidenceCard
	public void createResidenceCard(Patient patient) throws IOException {
		ResidenceCard residenceCard = new ResidenceCard();
		
		// initialise a -1 pour la boucle
		Integer numSpe = -1;
		
		while (numSpe < 5)
		{
			EnumSet<Speciality> allSpeciality = EnumSet.allOf(Speciality.class);
			System.out.println( "Choose Speciality : ");
			int i = 0;
			for (Speciality spe : allSpeciality)
			{
				System.out.print(i + " : " + spe + ", ");
				i++;
			}
			System.out.println("9 : End -->");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s = br.readLine();
			
			try {
				numSpe = Integer.parseInt(s);
			} catch (Exception e) {
				numSpe = 9;
			}
			
			switch (numSpe) {
			case 0:
				residenceCard.addSpe(Speciality.CARDIOLOGIE);
				break;
			case 1:
				residenceCard.addSpe(Speciality.PSYCHIATRE);
				break;
			case 2:
				residenceCard.addSpe(Speciality.NEUROLOGIE);
				break;
			case 3:
				residenceCard.addSpe(Speciality.KINE);
				break;
			case 4:
				residenceCard.addSpe(Speciality.OPHTALMOLOGIE);
				break;
			default:
				break;
			}
			
		}
		System.out.println("End Choice Specialty");
		patient.setResidenceCard(residenceCard);
	}

	public void displayPatient(String numPatient) {
		Patient patient = this.getPatient(numPatient);
		patient.displayResidenceCard();
		patient.displayReport();
	}

	public void exitPatient(String numPatient) {
		Patient patient = this.getPatient(numPatient);
		System.out.println("Patient " + patient.getName() + " returning Home !");
		patient.getResidenceCard().delete();
		patient.deleteCurrentReport();
	}

}
