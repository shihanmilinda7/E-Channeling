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
public class RecordRegister {
     public static int register(EnterRecord u) throws SQLException{
        int status = 0;
        try {
                //load driver
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

                //connect to DB
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");

                PreparedStatement ps =  con.prepareStatement
                            ("insert into PATIENT_RECORDS values (?,?,?,?)");

                ps.setString(1, u.getNic());
                ps.setString(2, u.getDoctor_id());
                ps.setString(3, u.getDate());
                ps.setString(4, u.getP_count());
                status = ps.executeUpdate();
                
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        return status;
    }      
}
