package com.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ValidatePatientRegistration {
     public static boolean ValidateUser (String nic) {
        boolean exist = false;
        try {
            //loading driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            //creating connection string
            Connection con =
                        DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            PreparedStatement ps =
                        con.prepareStatement("select * from PATIENTDETAILS where NIC=?");
            ps.setString(1, nic);
            ResultSet rs = ps.executeQuery();
            exist = rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exist;
    }
}
