package Hopital;

import java.util.ArrayList;
import java.util.List;

// Fiche de sejour
public class ResidenceCard {

	List<Speciality> listSpe; // use iterator

	public ResidenceCard() {
		super();
		listSpe = new ArrayList<>();
	}

	public List<Speciality> getListSpe() {
		return listSpe;
	}
	public void setListSpe(List<Speciality> listSpe) {
		this.listSpe = listSpe;
	}
	
	public void addSpe(Speciality spe){
		this.listSpe.add(spe);
	}

	public void display() {
		System.out.println(listSpe);
	}

	public void delete() {
		listSpe = new ArrayList<>();
	}

	public void deleteSpe(Speciality speciality) {
		this.getListSpe().remove(speciality);
	}
	
}
