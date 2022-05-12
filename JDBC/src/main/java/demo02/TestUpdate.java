package demo02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet re = null;

        try {
            conn = JDBC.JDBCUtils.getConnect();
            st = conn.createStatement();
            String sql = "UPDATE dsj1 SET `Python程序设计` = '71' WHERE `姓名` = '宗腾达'";
            int i = st.executeUpdate(sql);
            if (i > 0){
                System.out.println("更新成功！！！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBC.JDBCUtils.close(conn,st,re);
        }
    }
}
