/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gallomarianives_lb151;

/**
 *
 * @author M-N Kanti
 */
public class Satz {

    String satzNr;
    String satz;
    String Kategorie;
    boolean editable;

    public Satz(String satzNr, String satz, String Kategorie) {
        this.satzNr = satzNr;
        this.satz = satz;
        this.Kategorie = Kategorie;
    }

    public String getSatzNr() {
        return satzNr;
    }

    public void setSatzNr(String satzNr) {
        this.satzNr = satzNr;
    }

    public String getSatz() {
        return satz;
    }

    public void setSatz(String satz) {
        this.satz = satz;
    }

    public String getKategorie() {
        return Kategorie;
    }

    public void setKategorie(String Kategorie) {
        this.Kategorie = Kategorie;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
}
