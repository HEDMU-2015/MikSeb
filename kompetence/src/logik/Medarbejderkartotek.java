package logik;

import java.util.List;

import data.DataAccess;
import data.MedarbejderMapper;
import data.MedarbejderMapperImpl;
import domain.Kompetence;
import domain.Medarbejder;

public class Medarbejderkartotek {

	private MedarbejderMapper mm = new MedarbejderMapperImpl();

	public List<Medarbejder> findMedarbejdere(String navn, String email, List<Kompetence> kompetencer) {
		DataAccess da = new DataAccess();
		List<Medarbejder> medarbejdere = mm.findMedarbejdere(navn, email, da, kompetencer);
		
		return medarbejdere;
	}

}
