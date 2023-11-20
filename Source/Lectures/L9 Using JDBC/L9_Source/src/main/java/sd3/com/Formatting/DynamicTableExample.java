package sd3.com.Formatting;

import java.sql.*;

public class DynamicTableExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/books";
        String user = "root";
        String password = "";
        try {
            // Establishing a connection
            Connection conn = DriverManager.getConnection(url, user, password);

            // Creating a statement
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            // Executing a query
            String sql = "SELECT Title,EditionNumber  FROM titles";
//            String sql = "SELECT *  FROM titles";
//            String sql = "SELECT Title,EditionNumber, YearPublished, Price  FROM titles";
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            // Calculate column widths
            int[] columnWidths = new int[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnWidths[i - 1] = rsmd.getColumnName(i).length();
            }
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    if (rs.getString(i) != null) {
                        columnWidths[i - 1] = Math.max(columnWidths[i - 1], rs.getString(i).length());
                    }
                }
            }
            rs.beforeFirst();

            // Print table header
            String separatorLine = "+";
            String headerLine = "|";
            for (int i = 0; i < columnWidths.length; i++) {
                separatorLine += String.format("%-" + (columnWidths[i] + 2) + "s", "").replace(' ', '-') + "+";
                headerLine += String.format(" %-"+ columnWidths[i] +"s |", rsmd.getColumnName(i + 1));
            }
            System.out.println(separatorLine);
            System.out.println(headerLine);
            System.out.println(separatorLine);

            // Print rows
            String rowFormat = "|";
            for (int width : columnWidths) {
                rowFormat += " %-" + width + "s |";
            }
            while (rs.next()) {
                System.out.format(rowFormat + "\n", (Object[]) getRowValues(rs, columnCount));
            }
            System.out.println(separatorLine);

            // Close resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Object[] getRowValues(ResultSet rs, int columnCount) throws SQLException {
        Object[] values = new Object[columnCount];
        for (int i = 1; i <= columnCount; i++) {
            values[i - 1] = rs.getString(i) != null ? rs.getString(i) : "";
        }
        return values;
    }
}