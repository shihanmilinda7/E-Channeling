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
public class UpdateSchedule {
    public static int update(EditScheduleData u) throws SQLException{
        int status = 0;
        try {
                //load driver
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

                //connect to DB
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");

                if(u.getUfname().equals("Update Starting Time")){
                    PreparedStatement ps =  con.prepareStatement
                            ("update SCHEDULE set start_time=? where DOCTOR_ID=? and DATE=?");
                    ps.setString(1, u.getStime());
                    ps.setString(2, u.getDoctor_id());
                    ps.setString(3, u.getDate());
                    status = ps.executeUpdate();
                }else if(u.getUfname().equals("Update Ending Time")){
                    PreparedStatement ps =  con.prepareStatement
                            ("update SCHEDULE set end_time=? where DOCTOR_ID=? and DATE=?");
                    ps.setString(1, u.getEtime());
                    ps.setString(2, u.getDoctor_id());
                    ps.setString(3, u.getDate());
                    status = ps.executeUpdate();
                }else if(u.getUfname().equals("Update No Of Patient")){
                    PreparedStatement ps =  con.prepareStatement
                            ("update SCHEDULE set n_o_p=? where DOCTOR_ID=? and DATE=?");
                    ps.setString(1, u.getNop());
                    ps.setString(2, u.getDoctor_id());
                    ps.setString(3, u.getDate());                    
                    status = ps.executeUpdate();
                }
                
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        return status;
    }     
}
