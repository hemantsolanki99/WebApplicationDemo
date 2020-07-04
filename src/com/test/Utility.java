package com.test;

import java.sql.*;

public class Utility {
    public static boolean validate(String email, String password) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_web_app_demo","root","");

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM employee WHERE email=? AND password=?");
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            int count=0;
            while (rs.next()){
                count++;
            }
            if (count>0)
                return true;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
