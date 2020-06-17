package cinema.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cinema.model.User;

public class UserDAO {
	
	public static User getUser(String username, String password) {
		
		ConnectionManager.open();
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			String query = "SELECT Id,Role from Users WHERE Username=? AND Password=? AND Deleted=?";
			pstmt = conn.prepareStatement(query);
			int index = 1;
			
			pstmt.setString(index ++, username);
			pstmt.setString(index ++, password);
			Boolean deleted = false;
			pstmt.setString(index ++, deleted.toString());
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				int id = rset.getInt(1);
				User.Role role = User.Role.valueOf(rset.getString(2));
				
				User user = new User(username, role);
				user.setId(id);
				 
				return user;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();} 
			
		}
				
		return null;	
	}
	
	public static User getUserByUsername(String username) {
		
		ConnectionManager.open();
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			String query = "SELECT Id,Role from Users WHERE Username=? AND Deleted=?";
			pstmt=conn.prepareStatement(query);
			int index = 1;
			
			pstmt.setString(index ++, username);
			
			Boolean deleted = false;
			pstmt.setBoolean(index ++, deleted);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				int id = rset.getInt(1);
				User.Role role = User.Role.valueOf(rset.getString(2));
				
				User user = new User(username, role);
				user.setId(id);
				
				return user;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();} 
			
		}
		
		return null;
	}
	
}
