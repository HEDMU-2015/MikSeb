package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Kan returnere alle indtastede kompetencer
public class AlleKompetencerTest {

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/mydatabase", "SA", "");
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM KOMPETENCENAVN");
		ResultSet resultset = statement.executeQuery();
		while (resultset.next()) {
			String kompetencenavn = resultset.getString("kompetencenavn");
			System.out.println(kompetencenavn);
		}
		resultset.close();
		statement.close();
		connection.close();
	}
}