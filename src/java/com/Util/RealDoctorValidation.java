/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class RealDoctorValidation {
    public static boolean ValidateUser1 (String doctor_id, String df_name) {
        boolean exist1 = false;
        try {
            //loading driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            //creating connection string
            Connection con =
                        DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            PreparedStatement ps =
                        con.prepareStatement("select * from DOCTOR_VALIDATION where DOCTOR_ID=? and D_FNAME=?");
            ps.setString(1, doctor_id);
            ps.setString(2, df_name);
            ResultSet rs = ps.executeQuery();
            exist1 = rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exist1;
    }
}
