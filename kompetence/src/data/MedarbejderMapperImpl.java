package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Kompetence;
import domain.Medarbejder;
import domain.MedarbejderImpl;
import exceptions.NogetGikGaltException;

public class MedarbejderMapperImpl implements MedarbejderMapper {

	@Override
	public List<Medarbejder> findMedarbejdere(String navn, String email, DataAccess da, List<Kompetence> kompetencer) {
		List<Medarbejder> medarbejdere = new ArrayList<Medarbejder>();
		PreparedStatement statement = null;
		try {
			if(kompetencer.size()==1) {
				return findEnKompetence(kompetencer, da);
			} else if(kompetencer.size()==2) {
				return findToKompetencer(kompetencer, da);
			} else if(kompetencer.size()==3) {
				return findTreKompetencer(kompetencer, da);
			}
			Connection connection = da.getConnection();
			String sql = "SELECT * FROM MEDARBEJDER WHERE EMAIL LIKE '%"+email+"%' AND NAVN LIKE '%"+navn+"%'"; // Matcher email og navn
			statement = connection.prepareStatement(sql);
//			statement.setString(1, email);
//			statement.setString(2, navn);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Medarbejder medarbejder = new MedarbejderImpl(resultset.getString("navn"), resultset.getString("email"));
				medarbejdere.add(medarbejder);
			}
			resultset.close();
			
		}
		
		catch (SQLException sqlexc) {
			sqlexc.printStackTrace();
		throw new NogetGikGaltException();	
		}
		
		finally {
			try {
				statement.close();
			} catch (Exception e) {
				
			}
		}
		return medarbejdere;
	}

	@Override
	public boolean gemMedarbejder(String navn, String email, DataAccess da) {
		// TODO Auto-generated method stub
		return false;
	}
	
	// Metoder der finder kompetencer ud fra valgte medarbejdere
	
	private List<Medarbejder> findEnKompetence(List<Kompetence> kompetencer, DataAccess da) throws SQLException {
		List<Medarbejder> medarbejdere = new ArrayList<Medarbejder>();
		Connection connection = da.getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM MEDARBEJDERKOMPETENCE INNER JOIN MEDARBEJDER ON MEDARBEJDERKOMPETENCE . MEDARBEJDEREMAIL = MEDARBEJDER . EMAIL WHERE KOMPETENCENAVN IN (?)");
		statement.setString(1, kompetencer.get(0).getKompetencenavn());
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
	private List<Medarbejder> findToKompetencer(List<Kompetence> kompetencer, DataAccess da) throws SQLException {
		List<Medarbejder> medarbejdere = new ArrayList<Medarbejder>();
		Connection connection = da.getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM MEDARBEJDERKOMPETENCE INNER JOIN MEDARBEJDER ON MEDARBEJDERKOMPETENCE . MEDARBEJDEREMAIL = MEDARBEJDER . EMAIL WHERE KOMPETENCENAVN IN (?, ?)");
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

	private List<Medarbejder> findTreKompetencer(List<Kompetence> kompetencer, DataAccess da) throws SQLException {
		List<Medarbejder> medarbejdere = new ArrayList<Medarbejder>();
		Connection connection = da.getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM MEDARBEJDERKOMPETENCE INNER JOIN MEDARBEJDER ON MEDARBEJDERKOMPETENCE . MEDARBEJDEREMAIL = MEDARBEJDER . EMAIL WHERE KOMPETENCENAVN IN (?, ?, ?)");
		statement.setString(1, kompetencer.get(0).getKompetencenavn());
		statement.setString(2, kompetencer.get(1).getKompetencenavn());
		statement.setString(3, kompetencer.get(2).getKompetencenavn());
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