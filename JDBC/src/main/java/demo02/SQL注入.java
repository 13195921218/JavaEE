package demo02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQL注入 {

    public static void main(String[] args) {
        login("叶博","1");
    }


    public static void login(String username,String passwd) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet re = null;

        try {
            conn = JDBCUtils.getConnect();
            String sql = "select * from dsj1 where `姓名` = ? and `Hadoop生态系统` = ?";
            st = conn.prepareStatement(sql);

            st.setString(1, username);
            st.setString(2, passwd);

            re = st.executeQuery();

            while (re.next()){
                System.out.println(re.getString("姓名"));
                System.out.println(re.getString("Hadoop生态系统"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
