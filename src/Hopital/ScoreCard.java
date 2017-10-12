package Hopital;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Fiche de suivie
public class ScoreCard {

	List<Report> listReport;

	public ScoreCard() {
		super();
		this.listReport = new ArrayList<>();
	}

	public List<Report> getListReport() {
		return listReport;
	}

	public void setListReport(List<Report> listReport) {
		this.listReport = listReport;
	}

	public void displayFromSpe(String name) {
		List<Report> lr = this.getListReport().stream().filter(o -> o.getNomSpe().equals(name))
				.collect(Collectors.toList());
		for (Report report : lr) {
			report.display();
		}

	}
}
