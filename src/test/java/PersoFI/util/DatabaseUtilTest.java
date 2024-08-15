package test.java.PersoFI.util;

import main.java.PersoFI.util.DatabaseUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtilTest {

    private Connection connection;

    @Before
    public void setUp() throws SQLException {
        DatabaseUtil.initDatabase();
        connection = DatabaseUtil.getConnection();
    }

    @After
    public void tearDown() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    public void testDatabaseConnection() {
        assertNotNull(connection);
    }

    @Test
    public void testTablesCreation() throws SQLException {
        String[] tables = {"transactions", "categories", "budgets"};
        
        for (String table : tables) {
            try (Statement stmt = connection.createStatement()) {
                stmt.execute("SELECT 1 FROM " + table + " LIMIT 1");
            } catch (SQLException e) {
                fail("Table " + table + " does not exist");
            }
        }
    }
}