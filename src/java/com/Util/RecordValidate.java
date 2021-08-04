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
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class RecordValidate {
    public static boolean ValidateUser (String nic, String doctor_id, String date) {
    boolean exist = false;
    try {
        //loading driver
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        //creating connection string
        Connection con =
                    DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
        PreparedStatement ps =
                    con.prepareStatement("select * from PATIENT_RECORDS where NIC=? and DOCTOR_ID =? and DATE=?");
        ps.setString(1, nic);
        ps.setString(2, doctor_id);
        ps.setString(3, date);
        ResultSet rs = ps.executeQuery();
        exist = rs.next();
    } catch (Exception e) {
            e.printStackTrace();
    }
        return exist;
    }    
}
