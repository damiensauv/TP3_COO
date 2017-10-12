package Hopital;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		Medecin medecin = new Medecin();
		List<Specialiste> specialistes = new ArrayList<>();
		specialistes.add(new Specialiste("DRCAR", Speciality.CARDIOLOGIE));
		specialistes.add(new Specialiste("DRPSY", Speciality.PSYCHIATRE));
		specialistes.add(new Specialiste("DRNEU", Speciality.NEUROLOGIE));
		specialistes.add(new Specialiste("DRKIN", Speciality.KINE));
		specialistes.add(new Specialiste("DROPH", Speciality.OPHTALMOLOGIE));

		while (true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Welcome Enter Number Secu  : ");
			String numPatient = br.readLine();

			/* Cas 1 */
			boolean ret = medecin.searchPatient(numPatient);
			if (!ret) {
				System.out.println("Patient doesn't exist, Create it");
				numPatient = medecin.createPatient();
			}
			ret = medecin.searchPatient(numPatient);
			if (ret) {
				Patient patient = medecin.getPatient(numPatient);
				medecin.createResidenceCard(patient);
			}

			// Cas 2-3
			boolean cardEmpty = false;
			while (cardEmpty == false) {
				System.out.println("[Medecin] Visualization current residence, Enter Number Secu: ");
				numPatient = br.readLine();
				if (medecin.searchPatient(numPatient)) {
					medecin.displayPatient(numPatient);
				} else {
					System.out.println("Patient doesn't exist, Stop run");
					return;
				}
				System.out.println("Choose a Specialist : ");
				System.out.println(specialistes);
				String specialiste = br.readLine();
				String tmpSpe = specialiste.toUpperCase();
				Specialiste drSpe = null;

				try {
					drSpe = specialistes.stream().filter(o -> o.getName().equals(tmpSpe)).findFirst().get();
				} catch (Exception e) {
					drSpe = null;
				}

				if (drSpe == null) {
					System.out.println("The Specialist doesn't exist, Stop run");
					return;
				}

				System.out.println("Enter Patient Secu number : ");
				numPatient = br.readLine();

				ret = medecin.searchPatient(numPatient);
				if (!ret) {
					System.out.println("Patient doesn't exist, Stop run");
					return;
				} else {
					Patient patient = medecin.getPatient(numPatient);
					ResidenceCard rc = patient.getResidenceCard();

					if (!rc.listSpe.contains(drSpe.getSpeciality())) {
						System.out.println("Specialty not in list, stop run");
						return;
					}
					patient.displayFromSpe(drSpe.getName());
					drSpe.makeReport(patient, drSpe.getSpeciality());
					if (patient.getResidenceCard().getListSpe().isEmpty())
						cardEmpty = true;
				}
			}

			// Cas 4
			System.out.println("[Medecin] Enter num Secu patient to back home");
			numPatient = br.readLine();
			ret = medecin.searchPatient(numPatient);
			if (ret) {
				medecin.exitPatient(numPatient);
			} else {
				System.out.println("Patient Doesn't exit, Stop Run");
				return;
			}

		}

	}

}
