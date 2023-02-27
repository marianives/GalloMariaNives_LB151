/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.mycompany.gallomarianives_lb151;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "dataBean")
@SessionScoped
public class DatenBean implements Serializable {

    public ArrayList<String[]> getHighscoreData() {

        ArrayList<String[]> data = new ArrayList<String[]>();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lb151_gewinnspiel", "root", "");

            String query = "SELECT * FROM highscore ORDER BY score DESC";
            PreparedStatement stmt = conn.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String[] row = new String[2];
                row[0] = rs.getString("Score");
                row[1] = rs.getString("Name");
                data.add(row);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public ArrayList<String[]> getSatzData() {

        ArrayList<String[]> data = new ArrayList<String[]>();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lb151_gewinnspiel", "root", "");

            String query = "SELECT * FROM satz ";
            PreparedStatement stmt = conn.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String[] row = new String[3];
                row[0] = rs.getString("id_Satz");
                row[1] = rs.getString("Satz");
                row[2] = rs.getString("Kategorie");

                data.add(row);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
