package com.Util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class PatientRegister {
    public static int register(EnterPatientDetails u) throws SQLException{
        int status = 0;
        try {
                //load driver
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

                //connect to DB
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");

                PreparedStatement ps =  con.prepareStatement
                            ("insert into PATIENTDETAILS values (?,?,?,?,?)");

                ps.setString(1, u.getNic());
                ps.setString(2, u.getFname());
                ps.setString(3, u.getLname());
                ps.setString(4, u.getMobile());
                ps.setString(5, u.getPassword1());

                status = ps.executeUpdate();
                
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        return status;
    }  
}
