/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Katherine
 */
/**
 *
 * Klasa, w ktorej utowrzona jest lista przyciski -lista obiektów klasy
 * Przycisk, która zwraca listową reprezentację tablicy
 */
public class LosujKolor {

    private static List<Przycisk> przyciski = Arrays.asList( //
            Przycisk.of("NIEBIESKI", Kolory.ALICEBLUE, KolorTekstu.NIEBIESKI), //
            Przycisk.of("CZERWONY", Kolory.ANTIQUEWHITE, KolorTekstu.CZERWONY), //
            Przycisk.of("ZIELONY", Kolory.AZURE, KolorTekstu.ZIELONY), //
            Przycisk.of("FIOLETOWY", Kolory.BLANCHEDALMOND, KolorTekstu.FIOLETOWY) //
    );

    /**
     * metoda zwracająca obiekt klasy Przycisk; pobiera obiekt losowany
     * randomowo z listy przyciski
     *
     * @return
     */
    public static Przycisk wylosuj() {
        Random r = new Random();
        return przyciski.get(r.nextInt(4));
    }

}
