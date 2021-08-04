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
public class UpdateDoctor {
    public static int update(DoctorDataUpdate u) throws SQLException{
        int status = 0;
        try {
                //load driver
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

                //connect to DB
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");

                if(u.getUdfname().equals("Update First Name")){
                    PreparedStatement ps =  con.prepareStatement
                            ("update DOCTOR_DETAILS set d_fname=? where DOCTOR_ID=?");
                    ps.setString(1, u.getDfname());
                    ps.setString(2, u.getDoctor_id());
                    status = ps.executeUpdate();
                }else if(u.getUdfname().equals("Update Last Name")){
                    PreparedStatement ps =  con.prepareStatement
                            ("update DOCTOR_DETAILS set d_lname=? where DOCTOR_ID=?");
                    ps.setString(1, u.getDlname());
                    ps.setString(2, u.getDoctor_id());
                    status = ps.executeUpdate();
                }else if(u.getUdfname().equals("Update Mobile Number")){
                    PreparedStatement ps =  con.prepareStatement
                            ("update DOCTOR_DETAILS set mobile_number=? where DOCTOR_ID=?");
                    ps.setString(1, u.getMobile());
                    ps.setString(2, u.getDoctor_id());
                    status = ps.executeUpdate();
                }else if(u.getUdfname().equals("Update Specialization")){
                    PreparedStatement ps =  con.prepareStatement
                            ("update DOCTOR_DETAILS set specialization=? where DOCTOR_ID=?");
                    ps.setString(1, u.getSpecialization());
                    ps.setString(2, u.getDoctor_id());
                    status = ps.executeUpdate();
                }
                
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        return status;
    }  
    public static int updatePassword(DoctorDataUpdate u) throws SQLException{
        int status1 = 0;
        try {
                //load driver
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

                //connect to DB
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
                if(u.getUdfname().equals("Update Password")){
                    PreparedStatement ps =  con.prepareStatement
                                ("update DOCTOR_DETAILS set password=? where DOCTOR_ID=?");
                    ps.setString(1, u.getPassword1());
                    ps.setString(2, u.getDoctor_id());
                    status1 = ps.executeUpdate();
                }
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        return status1;
    }  
}
