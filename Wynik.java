
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
 * Klasa będąca osobnym oknem, dziedzicząca po klasie GłowneOkno,wyswietlajaca
 * wynik gracza
 */
public class Wynik extends GlowneOkno implements ActionListener {

    /**
     * Konstruktor klasy Wynik
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Wynik() throws IOException, ClassNotFoundException {
        /**
         * Dodanie JPanel
         */
        add(panel);
        /**
         * własne rozmieszczenie komponentów
         */
        panel.setLayout(null);
        /**
         * ustawienie koloru tła JPanel
         */
        panel.setBackground(new Color(135, 206, 235));
        /**
         * wywołanie metody z klasy bazowej GlowneOkno
         */
        ustaw();
        /**
         * wywołanie metody
         */
        opis();
        /**
         * ustawienie tytulu okna
         */
        setTitle("Wynik");

    }

    /**
     * metoda, w której dodawane są komponenty i ustawiane ich własciwości (
     * JLabel i JButton) oraz wywołanie metody nasłuchującej addActionListener
     */
    public void opis() {
        /**
         * wywołanie metody odczytującej z pliku stan gry uzytkownika i
         * przypisanie go do obiektu s
         */
        s = s.czytajStan(sciezka);
        /**
         * utworzenie nowego obiektu JLabel i dodanie do niego tekstu i odczytanej z pliku nazwy uzytkownika
         */

        etykieta1 = new JLabel("Najlepszy wynik: " + s.name);
        /**
         * ustawienie czcionki
         */
        etykieta1.setFont(new Font("droid", Font.BOLD, 45));
        /**
         * ustawenie położenia i rozmiaru JLabel jetykieta1
         */
        etykieta1.setBounds(50, 100, 600, 200);
        /**
         * dodanie jl1 do JPanel
         */
        panel.add(etykieta1);

        /**
         * utworzenie nowego obiektu JLabel i dodanie do niego tekstu i odczytanej z pliku sumy punktów
         * uzytkownika
         */
        etykieta2 = new JLabel("Suma punktów: " + s.bonus);
        /**
         * ustawienie czcionki
         */
        etykieta2.setFont(new Font("droid", Font.BOLD, 40));
        /**
         * ustawenie położenia i rozmiaru JLabel etykieta2
         */
        etykieta2.setBounds(100, 150, 600, 269);
        /**
         * dodanie jl2 do JPanel
         */
        panel.add(etykieta2);
        /**
         * utworzenie nowego obiektu JLabel i dodanie do niego pobranego z pliku obrazu .png
         */
        etykieta3 = new JLabel(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\puchar.png"));
        /**
         * ustawenie położenia i rozmiaru JLabel stykieta3
         */
        etykieta3.setBounds(600, 120, 316, 254);
        /**
         * dodanie etykieta3 do JPanel
         */
        panel.add(etykieta3);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }
}
