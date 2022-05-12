package demo02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestP {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = JDBCUtils.getConnect();
            String sql = "INSERT INTO dsj1(`姓名`,`Python程序设计`,`Linux操作系统`,`Hadoop生态系统`,`云计算与大数据技术`,`体育`,`总分`) \n" +
                    "VALUE (?,?,?,?,?,?,?)";
            st  = conn.prepareStatement(sql);

            st.setString(1,"原原本本");
            st.setString(2,"10");
            st.setString(3,"10");
            st.setString(4,"10");
            st.setString(5,"10");
            st.setString(6,"10");
            st.setString(7,"50");

            int i = st.executeUpdate();
            if (i > 0){
                System.out.println("插入成功！！！");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(conn,st,null);
        }
    }
}
