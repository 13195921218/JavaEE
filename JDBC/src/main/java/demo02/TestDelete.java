package demo02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDelete {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet re = null;

        try {
            conn = JDBCUtils.getConnect();
            st = conn.createStatement();
            String sql = "DELETE FROM dsj1 WHERE `姓名` = '叶叶博'";
            int i = st.executeUpdate(sql);
            if (i > 0){
                System.out.println("删除成功！！！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(conn,st,re);
        }
    }
}
