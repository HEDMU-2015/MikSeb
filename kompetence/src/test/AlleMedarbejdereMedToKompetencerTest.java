package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


// Kan returnere alle medarbejdere med bestemt kompetence

public class AlleMedarbejdereMedToKompetencerTest {

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/mydatabase", "SA", "");
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM MEDARBEJDERKOMPETENCE INNER JOIN MEDARBEJDER ON MEDARBEJDERKOMPETENCE . MEDARBEJDEREMAIL = MEDARBEJDER . EMAIL WHERE KOMPETENCENAVN IN ('Udvikling JAVA', 'Udvikling C#')");
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