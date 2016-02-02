package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Kan returnere alle medarbejdere to bestemte kompetencer

public class AlleMedarbejdereMedEntenEllerTest {

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/mydatabase", "SA", "");
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM MEDARBEJDERKOMPETENCE INNER JOIN MEDARBEJDER ON MEDARBEJDERKOMPETENCE . MEDARBEJDEREMAIL = MEDARBEJDER . EMAIL WHERE KOMPETENCENAVN='Udvikling JAVA' OR KOMPETENCENAVN='Fokusgrupper'");
		ResultSet resultset = statement.executeQuery();
		while (resultset.next()) {
			String medarbejder = resultset.getString("navn");
			System.out.println(medarbejder);
		}
		resultset.close();
		statement.close();
		connection.close();
	}
}