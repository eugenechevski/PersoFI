package PersoFI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.mindrot.jbcrypt.BCrypt;

public class UserAuthentication {

    private static final String DB_URL = "jdbc:sqlite:finance.db";

    public static void registerUser(String username, String password) throws Exception {
        Connection conn = DriverManager.getConnection(DB_URL);
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        pstmt.setString(2, hashedPassword);
        pstmt.executeUpdate();
        conn.close();
    }

    public static boolean loginUser(String username, String password) throws Exception {
        Connection conn = DriverManager.getConnection(DB_URL);
        String sql = "SELECT password FROM users WHERE username = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            String storedHash = rs.getString("password");
            conn.close();
            return BCrypt.checkpw(password, storedHash);
        }
        conn.close();
        return false;
    }
}
