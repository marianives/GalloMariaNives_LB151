/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.mycompany.gallomarianives_lb151;

import javax.ejb.Stateless;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "highscore")
@SessionScoped
public class HighscoreBean implements Serializable {

     private static final ArrayList<Highscore> highscoreListe
            = new ArrayList<Highscore>(Arrays.asList(
                    new Highscore("1", "Mario",
                            100),
                    new Highscore("2", "Luigi",
                            99)
            ));

    public ArrayList<Highscore> getHighscoreListe() {
        return highscoreListe;
    }

    public String speichern() {

        for (Highscore highscore : highscoreListe) {
            highscore.setEditable(false);
        }
        return null;

    }

    public String aendern(Highscore highscore) {

        highscore.setEditable(true);
        return null;
    }

}
