package demo02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSelect {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet re = null;

        try {
            conn = JDBC.JDBCUtils.getConnect();
            st = conn.createStatement();
            String sql = "SELECT * FROM dsj1";

            re = st.executeQuery(sql);

            while (re.next()){
                System.out.print(re.getObject("姓名"));
                System.out.print("    ");
                System.out.print(re.getObject("Python程序设计"));
                System.out.print(re.getObject("Linux操作系统"));
                System.out.print(re.getObject("Hadoop生态系统"));
                System.out.print(re.getObject("云计算与大数据技术"));
                System.out.print(re.getObject("体育"));
                System.out.println(re.getObject("总分"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBC.JDBCUtils.close(conn,st,re);
        }
    }
}
