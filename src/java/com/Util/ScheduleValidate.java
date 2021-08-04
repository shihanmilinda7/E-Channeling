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
public class ScheduleValidate {
    public static boolean ValidateUser (String doctor_id, String date) {
    boolean exist = false;
    try {
        //loading driver
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        //creating connection string
        Connection con =
                    DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
        PreparedStatement ps =
                    con.prepareStatement("select * from SCHEDULE where DOCTOR_ID=? and DATE=?");
        ps.setString(1, doctor_id);
        ps.setString(2, date);
        ResultSet rs = ps.executeQuery();
        exist = rs.next();
    } catch (Exception e) {
            e.printStackTrace();
    }
        return exist;
    }    
}
