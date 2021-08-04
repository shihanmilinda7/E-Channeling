/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class DoctorRegister {
     public static int register(EnterDoctorDetails u) throws SQLException{
        int status = 0;
        try {
                //load driver
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

                //connect to DB
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");

                PreparedStatement ps =  con.prepareStatement
                            ("insert into DOCTOR_DETAILS values (?,?,?,?,?,?)");

                ps.setString(1, u.getDoctorId());
                ps.setString(2, u.getFname());
                ps.setString(3, u.getLname());
                ps.setString(4, u.getSpecialization());
                ps.setString(5, u.getMobile());
                ps.setString(6, u.getPassword1());

                status = ps.executeUpdate();
                
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        return status;
    }  
}
