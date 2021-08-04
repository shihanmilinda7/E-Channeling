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
public class UpdatePatient {
    public static int update(PatientDataUpdate u) throws SQLException{
        int status = 0;
        try {
                //load driver
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

                //connect to DB
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");

                if(u.getUfname().equals("Update First Name")){
                    PreparedStatement ps =  con.prepareStatement
                            ("update PATIENTDETAILS set fname=? where NIC=?");
                    ps.setString(1, u.getFname());
                    ps.setString(2, u.getPatient_id());
                    status = ps.executeUpdate();
                }else if(u.getUfname().equals("Update Last Name")){
                    PreparedStatement ps =  con.prepareStatement
                            ("update PATIENTDETAILS set lname=? where NIC=?");
                    ps.setString(1, u.getLname());
                    ps.setString(2, u.getPatient_id());
                    status = ps.executeUpdate();
                }else if(u.getUfname().equals("Update Mobile Number")){
                    PreparedStatement ps =  con.prepareStatement
                            ("update PATIENTDETAILS set mobile_number=? where NIC=?");
                    ps.setString(1, u.getMobile());
                    ps.setString(2, u.getPatient_id());
                    status = ps.executeUpdate();
                }
                
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        return status;
    }  
    public static int updatePassword(PatientDataUpdate u) throws SQLException{
        int status1 = 0;
        try {
                //load driver
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

                //connect to DB
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
                if(u.getUfname().equals("Update Password")){
                    PreparedStatement ps =  con.prepareStatement
                                ("update PATIENTDETAILS set password=? where NIC=?");
                    ps.setString(1, u.getPassword1());
                    ps.setString(2, u.getPatient_id());
                    status1 = ps.executeUpdate();
                }
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        return status1;
    }  
}
