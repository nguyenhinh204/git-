
package demo.responsitory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    static String url = "jdbc:sqlserver://;serverName=THANH2K;databaseName=QuanLyTrungTamTinHoc_SOF2041;encrypt=true;trustServerCertificate=true;";
    static String user = "sa";
    static String password = "123456";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("Kết nối thành công");
    }

}
