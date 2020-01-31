package cinema.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
	
	private static final String DATABASE_NAME = "cinema.db";
	
	private static final String FILE_SEPARATOR = System.getProperty("file.separator");
	private static final String WINDOWS_PATH = "C:" + FILE_SEPARATOR + "Users" + FILE_SEPARATOR + "Snezana" + FILE_SEPARATOR + "SQLite" + FILE_SEPARATOR + DATABASE_NAME;
	
	private static final String PATH = WINDOWS_PATH;
	
	private static Connection connection;
	
	private static void open() {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:" + PATH);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static Connection getConnection() {
		return connection;
	}
	
	private static void close() {
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
