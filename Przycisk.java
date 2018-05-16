

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Katherine
 */
/**
 * Klasa opisująca przycisk
 * @author Katherine
 */
public class Przycisk {
/**
 * deklaracja obiektów i typów wyliczenioweych enum
 */
    private String nazwa;
    private Kolory kolory;
    private KolorTekstu tekst;

    /**
     * Konstruktor klasy Przycisk, przyjmujący jako parametry obiekty i typy wyliczeniowe
     * @param nazwa
     * @param kolory
     * @param tekst 
     */
    private Przycisk(String nazwa, Kolory kolory, KolorTekstu tekst) {
        this.nazwa = nazwa;
        this.kolory = kolory;
        this.tekst = tekst;

    }

    /**
     * metoda pobierająca obiekty klasy String, typu wyliczeniowego Kolory i
     * KolorTekstu oraz zwracająca nowy obiekt klasy Przycisk; "fabryka
     * Przycisków"
     *
     * @param nazwa
     * @param kolory
     * @param tekst
     * @return
     */
    public static Przycisk of(String nazwa, Kolory kolory, KolorTekstu tekst) {
        return new Przycisk(nazwa, kolory, tekst);
    }

    /**
     * metoda pobierająca obiekt klasy String
     *
     * @return
     */
    public String getNazwa() {
        return nazwa;
    }

    /**
     * metoda przyjmująca obiekt nazwa klasy String i ustawiająca tą nazwe do
     * pola klasy String
     */
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    /**
     * metoda pobierająca obiekt typu wyliczeniowego Kolory
     *
     * @return
     */
    public Kolory getKolory() {
        return kolory;
    }

    /**
     * metoda przyjmująca obiekt kolory typu wyliczeniowego Kolory i ustawiająca
     * ten kolor do pola typu wyliczeniowego Kolory
     *
     * @param kolory
     */
    public void setKolory(Kolory kolory) {
        this.kolory = kolory;
    }

    /**
     * metoda pobierająca obiekt typu wyliczeniowego KolorTekstu
     *
     * @return
     */
    public KolorTekstu getKolorTekstu() {
        return tekst;
    }

    /**
     * metoda przyjmująca obiekt tekst typu wyliczeniowego KolorTekstu i ustawiająca
     * ten tekst do pola typu wyliczeniowego KolorTekstu
     *
     * @param tekst
     */
    public void setKolorTekstu(KolorTekstu tekst) {
        this.tekst = tekst;
    }

}
