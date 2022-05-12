package demo02;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String passwd = null;

    static {
        try{
            InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(in);
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            passwd = properties.getProperty("passwd");

            Class.forName(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnect() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, passwd);
        return connection;
    }

    public static void close(Connection conn, Statement st, ResultSet re){
        if (re != null){
            try {
                re.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (st != null){
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
