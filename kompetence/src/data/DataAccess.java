package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataAccess {

	private static final String CONNECTION_URL = "jdbc:hsqldb:hsql://localhost/mydatabase";
	private static final String DB_USER = "SA";
	private static final String DB_PASSWORD = "";

	private Connection connection = null;

	public DataAccess(){ // or runtime exception?

		try {
			this.connection = DriverManager.getConnection(CONNECTION_URL, DB_USER, DB_PASSWORD);
			this.connection.setAutoCommit(false);
		} catch (SQLException e) {
			throw new RuntimeException("Connection is not available.", e);
		}


	}

	public Connection getConnection(){ //logic layer : public private - but without anything means projeck layer

		return this.connection;
	}	


	public void close(){
		
		try {
			this.connection.close();
		} catch (SQLException e) {
			throw new RuntimeException("Connection is not available.", e);
		}
		
		/*if(this.connection != null){
			this.connection.close();
			this.connection = null;
		}else{
			throw new SQLException("Connection is not available.");
		}*/
	}

	public void commit(){
		
		try {
			this.connection.commit();
		} catch (SQLException e) {
			throw new RuntimeException("Connection is not available.", e);
		}
		
		/*if(this.connection != null){
			this.connection.commit();
			this.connection = null;
		}else{
			throw new SQLException("Connection is not available.");
		}*/



	}

	public void rollback() {
		
		try {
			this.connection.rollback();
		} catch (SQLException e) {
			throw new RuntimeException("Connection is not available.", e);
		}

		/*if(this.connection != null){
			this.connection.rollback();
			this.connection = null;
		}else{
			throw new SQLException("Connection is not available.");
		}
*/

	}
}
