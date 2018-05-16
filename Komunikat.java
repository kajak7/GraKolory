
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
 * komunikat, pojawiający się, gdy użytkownik popełnił błąd lub gdy upłynął czas
 * gry
 */
public class Komunikat extends GlowneOkno implements ActionListener {

    /**
     * Konstruktor przyjmujący jako parametr obiekt stan klasy Stan
     *
     * @param stan
     * @throws InterruptedException
     */
    public Komunikat(Stan stan) throws InterruptedException {
        /**
         * odróznienie parametru stan od atrybutu klasy stan
         */
        this.stan = stan;
        /**
         * Dodanie JPanel
         */
        add(panel);
        /**
         * własne rozmieszczenie komponentów
         */
        panel.setLayout(null);
        /**
         * wywołanie metody z klasy bazowej GlowneOkno
         */
        ustaw();
        /**
         * Ustawienie rozmiaru okna
         */
        setSize(d.width / 4, d.height / 4);
        /**
         * ustawienie położenie okna
         */
        setLocation(d.width / 3, d.height / 3);
        /**
         * ustawienie koloru tła JPanel
         */
        panel.setBackground(new Color(255, 239, 213));
        /**
         * wywołanie metody
         */
        panel_komunikatu();
        /**
         * ustawienie tytulu okna
         */
        setTitle("Błąd");

    }

    /**
     * metoda, w której dodawane są komponenty i ustawiane ich własciwości (
     * JLabel i JButton) oraz wywołanie metody nasłuchującej addActionListener
     *
     * @throws InterruptedException
     */
    public void panel_komunikatu() throws InterruptedException {
        /**
         *
         * utworzenie nowego obiektu JButton i dodanie do niego pobranego z
         * pliku obrazu .png
         */

        przycisk1 = new JButton(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\ponownie.png"));
        /**
         * ustawenie położenia i rozmiaru JButton przycisk1
         */
        przycisk1.setBounds(25, 175, 276, 40);
        /**
         * dodanie do JButton przycisk2 metody nasłuchujacej
         */
        przycisk1.addActionListener(this);

        /**
         *
         * utworzenie nowego obiektu JButton i dodanie do niego pobranego z
         * pliku obrazu .png
         */
        przycisk2 = new JButton(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\wyjscie2.png"));
        /**
         * ustawenie położenia i rozmiaru JButton przycisk2
         */
        przycisk2.setBounds(315, 175, 123, 40);
        /**
         * dodanie do JButton przycisk2 metody nasłuchujacej
         */
        przycisk2.addActionListener(this);
        /**
         *
         * utworzenie nowego obiektu JButton i dodanie do niego pobranego z
         * pliku gif'a
         */
        JLabel bg = new JLabel(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\blad.gif"));
        /**
         * ustawenie położenia i rozmiaru JLabel bg
         */
        bg.setBounds(160, 5, 150, 160);
        /**
         * dodanie etykiety bg oraz przycisków do JPanel
         */
        panel.add(bg);
        panel.add(przycisk1);
        panel.add(przycisk2);

    }

    /**
     *
     * metoda przyjmująca parametr przechowujący informację o źrodle, tzn.
     * wciśniety przycisk. W zalezności od wciśnietego przycisku pojawia się
     * nowe okno ( Sprobuj ponownie- przycisk1- przekierowanie do poziomu gry,
     * na którym użytkownik skończył i w trybie jakim rozpoczął gre (angielski
     * lub polski); przycisk2 oznacza wyjście
     *
     *
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * pobieranie źródła e
         */
        Object source = e.getSource();
        /**
         * wywołanie metody odtwarzającej dźwięk
         */
        klikniecie();
        /**
         * Instrukcja warunkowa w celu wybrania opcji ponownej gry lub wyjścia z
         * aplikacji
         */
        if (source == przycisk1) {
            /**
             * wywołanie metody, posiadającej informacje, w jakim trybie gry
             * uzytkownik się znajduje
             */
            zmianaTrybu();
            /**
             * b=false - tryb polski, b=true- tryb angielski
             */
            if (b == false) {
                try {
                    /**
                     * otworzenie okna gry w trybie w języku polskim
                     */
                    new OknoGry(this.stan).setVisible(true);
                } catch (InterruptedException | IOException | ClassNotFoundException ex) {
                    Logger.getLogger(Komunikat.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    /**
                     * otworzenie okna gry w trybie w języku polskim
                     */

                    new OknoGry(true, this.stan).setVisible(true);
                } catch (InterruptedException | IOException | ClassNotFoundException ex) {
                    Logger.getLogger(Komunikat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            /**
             * zwalnia systemowe zasoby związane z wyświetlaniem okna, ukrywanie
             * okna
             */
            Komunikat.this.dispose();

        } else if (source == przycisk2) {
            /**
             * wyjscie z aplikacji
             */
            System.exit(0);
        }

    }
}
