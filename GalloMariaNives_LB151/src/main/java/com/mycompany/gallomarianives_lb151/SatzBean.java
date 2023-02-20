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

@ManagedBean(name = "satz")
@SessionScoped
public class SatzBean implements Serializable {


    private static final ArrayList<Satz> satzListe
            = new ArrayList<Satz>(Arrays.asList(
                    new Satz("1", "Hallo wie gehts",
                            "Satz"),
                    new Satz("2", "Hallo wie gehts",
                            "Satz"),
                    new Satz("3", "Hallo wie gehts",
                            "Satz")
            ));

    public ArrayList<Satz> getSatzListe() {
        return satzListe;
    }

    public String speichern() {

        for (Satz satz : satzListe) {
            satz.setEditable(false);
        }
        return null;

    }

    public String aendern(Satz satz) {

        satz.setEditable(true);
        return null;
    }

}
