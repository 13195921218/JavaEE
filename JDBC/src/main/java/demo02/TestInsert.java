package demo02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet re = null;
        try {
            conn = JDBC.JDBCUtils.getConnect();
            st = conn.createStatement();
            String sql = "INSERT INTO dsj1(`姓名`,`Python程序设计`,`Linux操作系统`,`Hadoop生态系统`,`云计算与大数据技术`,`体育`,`总分`) \n" +
                    "VALUE ('叶叶博','90','95','95','80','90','450')";
            int i = st.executeUpdate(sql);
            if (i > 0){
                System.out.println("插入成功！！！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBC.JDBCUtils.close(conn,st,re);
        }
    }
}
