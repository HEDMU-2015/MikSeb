package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Kompetence;
import domain.Medarbejder;
import domain.MedarbejderImpl;

public class AlleMedarbejdereMedKompetencer {
	
	public List<Medarbejder> allemedarbejderemedtokompetencer(List<Kompetence> kompetencer) throws SQLException{
		List<Medarbejder> medarbejdere = new ArrayList<>();
		
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/mydatabase", "SA", "");
		String sql = "SELECT * FROM MEDARBEJDERKOMPETENCE INNER JOIN MEDARBEJDER ON MEDARBEJDERKOMPETENCE . MEDARBEJDEREMAIL = MEDARBEJDER . EMAIL WHERE KOMPETENCENAVN IN (?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, kompetencer.get(0).getKompetencenavn());
		statement.setString(2, kompetencer.get(1).getKompetencenavn());
		ResultSet resultset = statement.executeQuery();
		while (resultset.next()) {
			Medarbejder medarbejder = new MedarbejderImpl(resultset.getString("navn"), resultset.getString("email"));
			medarbejdere.add(medarbejder);
		}
		resultset.close();
		statement.close();
		connection.close();
		
		return medarbejdere;

}
	
}
