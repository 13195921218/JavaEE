package demo02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestTransaction {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet re = null;

        try {
            conn = JDBCUtils.getConnect();
            conn.setAutoCommit(false);

            String sql1 = "update test03 set grade = grade+10 where id = 1";
            st = conn.prepareStatement(sql1);
            st.executeUpdate();

            String sql2 = "update test03 set grade = grade-10 where id = 2";
            st = conn.prepareStatement(sql2);
            st.executeUpdate();

            conn.commit();
            System.out.println("成功！！！");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
