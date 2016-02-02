package præsentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import data.AlleMedarbejdereMedKompetencer;
import domain.Kompetence;
import domain.KompetenceImpl;
import domain.Medarbejder;
import logik.Medarbejderkartotek;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
//		AlleMedarbejdereMedKompetencer a = new AlleMedarbejdereMedKompetencer();
//		
//		List<Kompetence> k = Arrays.asList(new KompetenceImpl("Udvikling JAVA"), new KompetenceImpl("Fokusgrupper"));
//		List<Medarbejder> l = a.allemedarbejderemedtokompetencer(k);
//		System.out.println(l);
		
		Medarbejderkartotek mk = new Medarbejderkartotek();
		List<Medarbejder> soegvianavnelleremail = mk.findMedarbejdere("Anders","", new ArrayList<Kompetence>());
		System.out.println(soegvianavnelleremail);
	}

	
}
