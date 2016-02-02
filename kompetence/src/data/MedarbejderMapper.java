package data;

import java.util.List;

import domain.Kompetence;
import domain.Medarbejder;

public interface MedarbejderMapper {
	
	List<Medarbejder> findMedarbejdere(String navn, String email, DataAccess da, List<Kompetence> kompetencer);

	boolean gemMedarbejder(String navn, String email, DataAccess da);
}
