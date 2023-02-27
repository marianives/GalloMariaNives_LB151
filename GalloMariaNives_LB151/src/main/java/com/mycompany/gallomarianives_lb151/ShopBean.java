/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.mycompany.gallomarianives_lb151;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author M-N Kanti
 */
@SessionScoped
@ManagedBean(name = "shopBean")
public class ShopBean {

    SpielBean s = new SpielBean();
    int kontostand = s.getKontostand();
    String message = "";

    public int getKontostand() {
        return kontostand;
    }

    public String getMessage() {
        return message;
    }

    public void kaufeAuto() {
        if (kontostand >= 1000) {
            kontostand -= 1000;
            message = "Du hast ein Auto gekauft";
        } else {
            message = "Kontostand zu tief!";
        }
    }

    public void kaufeSchuhe() {
        if (kontostand >= 200) {
            kontostand -= 200;
            message = "Du hast einen paar Schuhe gekauft";
        } else {
            message = "Kontostand zu tief!";
        }
    }

    public void kaufeRing() {
        if (kontostand >= 800) {
            kontostand -= 800;
            message = "Du hast einen Ring gekauft";
        } else {
            message = "Kontostand zu tief!";
        }
    }

    public void kaufeEssen() {
        if (kontostand >= 100) {
            kontostand -= 100;
            message = "Du hast Essen gekauft";
        } else {
            message = "Kontostand zu tief!";
        }
    }
}
