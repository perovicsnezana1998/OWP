package cinema.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

public class ConnectionManager {

	private static final String DATABASE_NAME = "cinema.db";
	private static final String WINDOWS_PATH = "jdbc:sqlite:C:\\Users\\Snezana\\SQLite\\cinema.db";
	
	private static Connection connection;
	
	public static void open() {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(WINDOWS_PATH);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
	public static void close() {
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
