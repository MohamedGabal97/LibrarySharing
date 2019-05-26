/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectdisser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ALKODS
 */
public class alg {

    PreparedStatement pst = null;
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public alg() {
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }

    public String search(String txt) {
        String url = "";
        try {
            String sql = "SELECT * FROM word name where word_name='mohamed';";

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("555");
                System.out.println(rs.getString(1));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return url;
    }
}
