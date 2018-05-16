/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;

/**
 *
 * @author Katherine
 */
/**
 * Typ wyliczeniowy składający się z czterech róznych kolorów, które opisują tło przycisku
 *
 */
public enum Kolory {

    ALICEBLUE(new Color(240, 248, 255)),
    ANTIQUEWHITE(new Color(250, 235, 215)),
    AZURE(new Color(240, 255, 255)),
    BLANCHEDALMOND(new Color(255, 235, 205));

    /**
     * obiekt klasy Color o ograniczonym dostępie
     */
    private Color color;

    /**
     * Konstruktor przyjmujący jako parametr obiekt color klasy Color i
     * przypisuje właśnie ten parametr wejściowy color do pola klasy color
     *
     * @param color
     */
    private Kolory(Color color) {
        this.color = color;
    }

    /**
     * hermetyzacja metoda pobierająca obiekt
     *
     * @return
     */
    public Color getColor() {

        return color;
    }

    /**
     * hermetyzacja 
     * metoda przyjmująca parametr obiekt color klasy Color i
     * ustawiająca color 
     *
     * @param color
     * @return
     */
    public Color setColor(Color color) {
        return color;
    }

}
