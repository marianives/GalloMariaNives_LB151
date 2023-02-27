/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.mycompany.gallomarianives_lb151;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name = "spielBean")
@SessionScoped
public class SpielBean {

    private char[] sentenceChars = {' '};
    private char[] verdeckterSatz = {' '};
    private String category;
    char charInput = ' ';
    private int kontostand = 1000;
    String inputSentence = "";
    String name = "";
    int gluecksZahl = 0;

    public int getGluecksZahl() {
        return gluecksZahl;
    }

    public void setGluecksZahl(int gluecksZahl) {
        this.gluecksZahl = gluecksZahl;
    }

    public char getCharInput() {
        return charInput;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void SpielSatz() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lb151_gewinnspiel", "root", "");
            String sql = "SELECT satz, kategorie FROM satz ORDER BY RAND() LIMIT 1";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                String sentence = result.getString("satz");
                sentenceChars = sentence.toCharArray();

                verdeckterSatz = new char[sentenceChars.length];
                for (int i = 0; i < sentenceChars.length; i++) {
                    char c = sentenceChars[i];
                    if (Character.isLetter(c)) {
                        verdeckterSatz[i] = '*';
                    } else if (Character.isWhitespace(c) || !Character.isLetterOrDigit(c)) {
                        verdeckterSatz[i] = c;
                    }
                }

                category = result.getString("kategorie");
            }

            result.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public char[] getSentenceChars() {
        return sentenceChars;
    }

    public char[] getVerdeckterSatz() {
        return verdeckterSatz;
    }

    public String getCategory() {
        return category;
    }

    public void drehen() {
        Random rnd = new Random();
        int rndnr = rnd.nextInt(16);
        gluecksZahl = rndnr * 100;
    }

    public String getSentence() {
        String sentence = "";
        for (char b : verdeckterSatz) {
            sentence = sentence + b;
        }
        return sentence;
    }

    public void setCharInput(char charInput) {
        this.charInput = charInput;
    }

    public void setInputSentence(String inputSentence) {
        this.inputSentence = inputSentence;
    }

    public int getKontostand() {
        return kontostand;
    }

    public void verifyChar() throws IOException, SQLException {
        boolean found = false;
        for (int i = 0; i < sentenceChars.length; i++) {
            if (Character.toLowerCase(charInput) == Character.toLowerCase(sentenceChars[i])) {
                verdeckterSatz[i] = sentenceChars[i];
                kontostand += gluecksZahl;
                found = true;
            }
        }
        if (!found) {
            kontostand -= 200;
            if (kontostand < 0 || kontostand == 0) {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lb151_gewinnspiel", "root", "");
                String query = "INSERT INTO highscore (Score, Name) VALUES (?, ?)";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, String.valueOf(kontostand));
                statement.setString(2, getName());
                statement.executeUpdate();
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                ec.redirect("GameOver.xhtml");
            }

        }

    }

    public void vokalKaufen() throws SQLException, IOException {
        if (kontostand < 400) {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lb151_gewinnspiel", "root", "");
            String query = "INSERT INTO highscore (Score, Name) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, String.valueOf(kontostand));
            statement.setString(2, getName());
            statement.executeUpdate();
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect("GameOver.xhtml");
        } else {
            kontostand -= 400;
            for (int i = 0; i < sentenceChars.length; i++) {
                char c = sentenceChars[i];
                if (isVowel(c) && verdeckterSatz[i] == '*') {
                    int count = countOccurrences(sentenceChars, c);
                    for (int j = 0; j < count; j++) {
                        int index = indexOf(sentenceChars, c, i);
                        verdeckterSatz[index] = c;
                        i = index;
                    }
                    return;
                }
            }
        }
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    private int countOccurrences(char[] arr, char c) {
        int count = 0;
        for (char x : arr) {
            if (x == c) {
                count++;
            }
        }
        return count;
    }

    private int indexOf(char[] arr, char c, int startIndex) {
        for (int i = startIndex; i < arr.length; i++) {
            if (arr[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public String getInputSentence() {
        return inputSentence;
    }

    public void checkSentence() throws IOException, SQLException {
        boolean erraten = false;
        if (inputSentence.equals(String.valueOf(sentenceChars))) {
            kontostand += gluecksZahl * 2;
            erraten = true;
        } else {
            kontostand -= 1000;
            if (kontostand < 0 || kontostand == 0) {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lb151_gewinnspiel", "root", "");
                String query = "INSERT INTO highscore (Score, Name) VALUES (?, ?)";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, String.valueOf(kontostand));
                statement.setString(2, getName());
                statement.executeUpdate();
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                ec.redirect("GameOver.xhtml");
            }
        }

        if (erraten) {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lb151_gewinnspiel", "root", "");
            String query = "INSERT INTO highscore (Score, Name) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, String.valueOf(kontostand));
            statement.setString(2, getName());
            statement.executeUpdate();
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect("Gewonnen.xhtml");
        }
    }
}
