
import java.awt.Color;

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
 *
 * Typ wyliczeniowy składający się z czterech róznych kolorów, które przyjmują
 * napisy
 *
 */
public enum KolorTekstu {
    CZERWONY(Color.RED),
    FIOLETOWY(new Color(138, 43, 226)),
    NIEBIESKI(Color.BLUE),
    ZIELONY(new Color(0, 128, 0));
    /**
     * obiekt klasy Color o ograniczonym dostępie
     */
    private Color color;

    /**
     * /**
     * Konstruktor przyjmujący jako parametr obiekt color klasy Color i
     * przypisuje właśnie ten parametr wejściowy color do pola klasy color
     *
     * @param color
     *
     *
     */
    private KolorTekstu(Color color) {
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
     * hermetyzacja metoda przyjmująca parametr obiekt color klasy Color i
     * ustawiająca color
     *
     * @param color
     * @return
     */
    public Color setColor(Color color) {
        return color;
    }

}
