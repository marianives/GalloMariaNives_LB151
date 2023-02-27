# Projekt-Dokumentation

Gallo

|  Datum | Version | Zusammenfassung                                              |
| -----  | ------- | ------------------------------------------------------------ |
|15-01-23| 0.0.1   | Ich habe die Dokumentation 1-5 gemacht.                      |
|23-01-23| 0.0.2   |Theorie |
|30-01-23| 0.0.3   |Interface, Datenbank verbindung|
|13-02-23| 0.0.4   |Spiellogik angefangen|
|20-02-23| 0.0.5   |Ganzes Projekt neu programmiert|
|27-02-23| 1.0.0   |Dokumentation, Korrekturen|

# 0 Ihr Projekt

Das Spiel "Glücksrad" als Webapplikation mit JSF programmiert. Zusätzlich eine Datenbank mit JDBC verbunden.

# 1 Analyse

* Tier 1 (Presentation): Kontostand anzeigen, Vokale kaufen, Satz anzeigen, Satz raten, Shop, Highscore anzeigen, Sätzeliste anzeigen.
* Tier 2 (Webserver): Eingaben, Anmelden, Formular übergabe.
* Tier 3 (Application Server): Überprüfung übereinstimmung gerateter Satz, Vokaleingabe überprüfen, Buchstab Eingabe überprüfen, Datensätze aufrufen, Kontostand bei einkauf überprüfen, Filter, Glücksrad drehen.
* Tier 4 (Dataserver): Abspeicherung Datensätze, Herausgabe Datensätze.

# 2 Technologie

Ich werde dieses Projekt mit JSF (Java) programmieren und JDBC für die Datenbank benutzen

# 3 Datenbank

✍️ Wie steuern Sie Ihre Datenbank an? Wie ist das Interface aufgebaut? 

# 4.1 User Stories

| US-№ | Verbindlichkeit | Typ        | Beschreibung                       |
| ---- | --------------- |    ----    | ---------------------------------- |
| 1    |       Muss      | Funktional | Als Spieler möchte ich meinen Namen eingeben können, um es dann in der Highscore-Liste zu sehen. |
| 2    |       Muss      | Funktional | Als Spieler möchte ich am Glücksrad drehen können, um eine Glückszahl zu bekommen.|
| 3    |       Muss      | Funktional | Als Spieler möchte ich einen Satz aufdecken können, um diesen dann herausfinden zu können.|
| 4    |       Muss      | Funktional | Als Spieler möchte ich den aufgedeckten Satz mit * sehen, damit ich diesen erraten kann.|
| 5    |       Muss      | Funktional | Als Spieler möchte ich einen Buchstaben eingeben können, um herauszufinden, ob dieser im Satz enthalten ist.|
| 6    |       Muss      | Funktional | Als Spieler möchte ich, wenn ich einen Buchstaben herausgefunden habe, für jeden Buchstabe die Glückszahl als Betrag auf mein Konto gutgeschrieben bekommen|
| 7    |       Muss      | Funktional | Als Spieler möchte ich, dass wenn ich einen Buchstabe falsch gerate habe, einen abzug auf dem Konto von 200 bekomme.|
| 8    |       Muss      | Funktional | Als Spieler möchte ich einen zufälligen Vokal kaufen können für 400 um den Satz einfacher zu finden.|
| 9    |       Muss      | Funktional | Als Spieler möchte ich einen Satz eingeben können, um diesen Herauszufinden. Wenn ich ihn errate, bekomme ich 3000, sonst werden mir 1000 abgeschrieben.|
| A   |       Muss      | Funktional | Als Spieler möchte ich, wenn der Satz herausgefunden wurde Gewinnen, um dann im Shop etwas zu kaufen. |
| 11   |       Muss      | Funktional | Als Spieler möchte ich, wenn der Kontostand bei 0 ist Verlieren, um dann die Highscore-Liste zu sehen.|
| B   |       Muss      | Funktional | Als Spieler möchte ich im Shop so lange einkaufen können, bis der Geldbetrag bei 0 ist.|
| C  |       Muss      | Funktional | Als Spieler möchte ich, wenn ich fertig im Shop bin, zur Highscore-Liste gehen, um mir diese anzuschauen.|
| 14   |       Muss      | Funktional | Als Admin möchte ich mich anmedlen können, um die Highscore-Liste und Satzliste zu sehen.|
| 15   |       Muss      | Funktional | Als Spieler möchte ich die Kategorie vom Satz wissen, um einfacher herauszufinden|



# 4.2 Testfälle

| TC-№ | Vorbereitung | Eingabe | Erwartete Ausgabe |
| ---- | ------------ | ------- | ----------------- |
| 1.1  |Applikation muss gestartet sein, auf Home sein| Name eingeben, OK klicken|Spiel wird gestartet|
| 2.1  |Spiel gestartet haben | Auf "drehen" klicken |Eine Glückszahl wird angezeigt.|
| 3.1  |Spiel gestartet haben|Auf "Show me" klicken|Ein Satz erscheint.|
| 4.1  |Spiel gestartet haben |Auf "Show me" klicken| Satz wird mit * anstatt buchstaben angezeigt|
| 5.1  |Spiel gestartet, Satz aufgedeckt, Glücksrad gedreht|Buchstab bei "Buchstabe erraten" eingeben und auf Button klicken|Falls enthalten, wird dieser im Satz aufgedeckt, sonst nicht.|
| 6.1  |Spiel gestartet, Satz aufgedeckt, Glücksrad gedreht |Buchstabe bei "Buchstabe erraten" eingeben und auf Button klicken|der Buchstabe wird aufgedeckt im Satz, Kontostand wird erhöht um Glückszahl.|
| 7.1  |Spiel gestartet, Satz aufgedeckt, Glücksrad gedreht |Buchstabe bei "Buchstabe erraten" eingeben und auf Button klicken|der Buchstabe wird nicht aufgedeckt, Kontostand wird um 200 kleiner.|
| 8.1  |Spiel gestartet, Satz aufgedeckt, Glücksrad gedreht |Auf Vokal kaufen klicken|der Vokal wird aufgedeckt im Satz, Kontostand wird um 400 kleiner.|
| 9.1  |Spiel gestartet, Satz aufgedeckt, Glücksrad gedreht |Satz im eingabefeld eingeben und auf raten klicken|Falls richtig -> Kontostand +3000|
| 9.2  |Spiel gestartet, Satz aufgedeckt, Glücksrad gedreht |Satz im eingabefeld eingeben und auf raten klicken|Falls falsch -> Kontostand -1000|
| A.1  |Spiel gestartet, Satz aufgedeckt, Glücksrad gedreht |Satz im eingabefeld eingeben und auf raten klicken|Falls richtig -> Gewinnseite mit weg zu Highscore Liste und Shop wird angezeigt |
| 11.1  |Spiel gestartet, Satz aufgedeckt, Glücksrad gedreht, Kontostand bei 0 |-|GameOver Seite mit Weg zu HighscoreListe wird angezeigt.|
| D.1  |Spiel gewonnen, auf Shop-Seite | Gegenstände kaufen |Bei Kontostand 0 -> Nicht mehr möglich einzukaufen|
| B.1  |Spiel gewonnen, auf Shop-Seite |Auf "High Score" klicken|High Score wird angezeigt.|
| C14  |Applikation gestartet, auf Home sein |Benutzername & Passwort eingeben |High Score Liste und Satzliste anzeigen.|
| 15.1  |Spiel gestartet, Satz aufgedeckt, Glücksrad gedreht |Satz aufdecken|Kategorie wird mit Satz ausgegeben|


# 5 Prototyp

![Screenshot 2023-01-15 204932](https://user-images.githubusercontent.com/100756109/212563751-488eab78-3c3f-4530-a9d9-388772ffbf03.jpg)



# 6 Implementation

| User Story | Datum | Beschreibung |
| ---------- | ----- | ------------ |
| 1       |23-01-23|OK|
| 2       |20-02-23|OK|
| 3       |20-02-23|OK|
| 4       |20-02-23|OK|
| 5       |20-02-23|OK|
| 6       |20-02-23|OK|
| 7       |20-02-23|OK|
| 8       |20-02-23|OK|
| 9       |20-02-23|OK|
| A      |20-02-23|OK|
| 11      |20-02-23|OK|
| D      |20-02-23|OK|
| B      |30-01-23|OK|
|14    |30-01-23|OK|
| 15      |30-01-23|OK|



# 7 Projektdokumentation

| US-№ | Erledigt? | Entsprechende Code-Dateien oder Erklärung |
| ---- | --------- | ----------------------------------------- |
| 1    |     ja    |Home.xhtml                               |
| 2    |     ja    |Spiel.xhtml & SpielBean.java -> drehen()|
| 3    |     ja    |Spiel.xhtml & SpielBean.java -> SpielSatz() |
| 4    |     ja    |Spiel.xhtml & SpielBean.java -> getSentence(), verdeckterSatz|
| 5    |     ja    |Spiel.xhtml & SpielBean.java -> verifyChar()|
| 6    |     ja    |Spiel.xhtml & SpielBean.java -> verifyChar()|
| 7    |     ja    |Spiel.xhtml & SpielBean.java -> verifyChar()|
| 8    |     ja    |Spiel.xhtml & SpielBean.java -> vokalKaufen()|
| 9    |     ja    |Spiel.xhtml & SpielBean.java -> checkSentence()|
| A   |     ja    |Spiel.xhtml & SpielBean.java -> checkSentence()|
| 11   |     ja    |Spiel.xhtml & SpielBean.java -> checkSentence(),vokalKaufen(),verifyChar()|
| D   |     ja    |Gewonnen.xhtml & ShopBean.java|
| B   |     ja    |Gewonnen.xhtml & ShopBean.java|
| 14 |     ja    |Home.xhtml, FilterAdmin,java|
| 15   |     ja    |Spiel.xhtml & SpielBean.java -> SpielSatz()|


# 8 Testprotokoll

✍️ Fügen Sie hier den Link zu dem Video ein, welches den Testdurchlauf dokumentiert.

| TC-№ | Datum | Resultat | Tester |
| ---- | ----- | -------- | ------ |
| 1.1  |27-02.23|OK|MNG|
| 2.1  |27-02.23|OK|MNG|
| 3.1  |27-02.23|OK|MNG|
| 4.1  |27-02.23|OK|MNG|
| 5.1  |27-02.23|OK|MNG|
| 6.1  |27-02.23|OK|MNG|
| 7.1  |27-02.23|OK|MNG|
| 8.1  |27-02.23|OK|MNG|
| 9.1  |27-02.23|OK|MNG|
| 10.1  |27-02.23|OK|MNG|
| 11.1  |27-02.23|OK|MNG|
| 12.1  |27-02.23|OK|MNG|
| 13.1  |27-02.23|OK|MNG|
| 14.1  |27-02.23|OK|MNG|
| 15.1  |27-02.23|OK|MNG|


Alle Tests sind postiv herausgekommen, ausser bei der Anmeldung vom Admin wird das Passwort & Benutzername nicht überprüft und im Shop wird der falsche kontostand angezeigt.

# 9 `README.md`
.

# 10 Allgemeines

- [x] Ich habe die Rechtschreibung überprüft
- [x] Ich habe überprüft, dass die Nummerierung von Testfällen und User Stories übereinstimmen
- [x] Ich habe alle mit ✍️ markierten Teile ersetzt
