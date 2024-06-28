package PersoFI;

public class ReportGenerator {

    private static final String DB_URL = "jdbc:sqlite:finance.db";

    public static FinancialReport generateMonthlyReport(int userId, int month, int year) throws Exception {
        Connection conn = DriverManager.getConnection(DB_URL);
        String sql = "SELECT category, SUM(amount) AS total FROM transactions WHERE user_id = ? AND strftime('%m', date) = ? AND strftime('%Y', date) = ? GROUP BY category";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, userId);
        pstmt.setString(2, String.format("%02d", month));
        pstmt.setString(3, String.valueOf(year));
        ResultSet rs = pstmt.executeQuery();
        FinancialReport report = new FinancialReport();
        while (rs.next()) {
            report.addCategoryTotal(rs.getString("category"), rs.getDouble("total"));
        }
        conn.close();
        return report;
    }

    public static FinancialReport generateYearlyReport(int userId, int year) throws Exception {
        Connection conn = DriverManager.getConnection(DB_URL);
        String sql = "SELECT category, SUM(amount) AS total FROM transactions WHERE user_id = ? AND strftime('%Y', date) = ? GROUP BY category";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, userId);
        pstmt.setString(2, String.valueOf(year));
        ResultSet rs = pstmt.executeQuery();
        FinancialReport report = new FinancialReport();
        while (rs.next()) {
            report.addCategoryTotal(rs.getString("category"), rs.getDouble("total"));
        }
        conn.close();
        return report;
    }
}
