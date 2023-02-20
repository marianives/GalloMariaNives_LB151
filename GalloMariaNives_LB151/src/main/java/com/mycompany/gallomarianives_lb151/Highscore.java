/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gallomarianives_lb151;

/**
 *
 * @author M-N Kanti
 */
public class Highscore {

    String platz;
    String name;
    int punkte;
    boolean editable;

    public Highscore(String platz, String name, int punkte) {
        this.platz = platz;
        this.name = name;
        this.punkte = punkte;
    }

    public String getPlatz() {
        return platz;
    }

    public void setPlatz(String platz) {
        this.platz = platz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPunkte() {
        return punkte;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

}
