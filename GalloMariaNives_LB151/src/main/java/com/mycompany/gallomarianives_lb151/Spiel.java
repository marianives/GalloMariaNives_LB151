/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gallomarianives_lb151;

/**
 *
 * @author M-N Kanti
 */
public class Spiel {

    String name;
    int kontostand;
    Satz spielSatz;

    public Spiel(String name, int kontostand, Satz spielSatz) {
        this.name = name;
        this.kontostand = kontostand;
        this.spielSatz = spielSatz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKontostand() {
        return kontostand;
    }

    public void setKontostand(int kontostand) {
        this.kontostand = kontostand;
    }

    public Satz getSpielSatz() {
        return spielSatz;
    }

    public void setSpielSatz(Satz spielSatz) {
        this.spielSatz = spielSatz;
    }

}
