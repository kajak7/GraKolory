/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

/**
 * @author Katherine
 */
/**
 *
 * Klasa będąca osobnym oknem, dziedzicząca po klasie GłowneOkno,wyswietlajaca
 * okno startowe
 */
class Start extends GlowneOkno implements ActionListener {

    /**
     * Konstruktor klasy Start
     */
    public Start() {
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
        panel.setBackground(new Color(255, 239, 213));
        /**
         * wywołanie metody z klasy bazowej GlowneOkno
         */
        ustaw();
        /**
         * wywołanie metody
         */
        PanelGlowny();
        /**
         * ustawienie rozmiaru okna
         */
        setSize(1000, 700);
        /**
         * ustawienie tytulu okna
         */
        setTitle("Co dwie półkule to nie jedna");

    }

    /**
     * metoda, w której ustawiane są komponenty
     */
    public void PanelGlowny() {
        /**
         * utworzenie nowego obiektu JLabel i dodanie do niego pobranego z pliku
         * obrazu .png
         */
        JLabel tekst = new JLabel(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\tytul.png"));
        /**
         * ustawenie położenia i rozmiaru JLabel tekst
         */
        tekst.setBounds(240, 50, 503, 82);
        /**
         * dodanie tekst do JPanel tlo
         */
        panel.add(tekst);
        /**
         * utworzenie nowego obiektu JLabel i dodanie do niego pobranego z pliku
         * obrazu .png
         */
        JLabel obraz1 = new JLabel(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\mozg.gif"));
        /**
         * ustawenie położenia i rozmiaru JLabel obraz1
         */
        obraz1.setBounds(20, 160, 320, 320);
        /**
         * dodanie tekst do JPanel tlo
         */
        panel.add(obraz1);
        /**
         * utworzenie nowego obiektu JLabel i dodanie do niego pobranego z pliku
         * obrazu .png
         */
        JLabel obraz2 = new JLabel(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\pomysl1.gif"));
        /**
         * ustawenie położenia i rozmiaru JLabel obraz2
         */
        obraz2.setBounds(670, 160, 320, 320);
        /**
         * dodanie tekst do JPanel obraz2
         */

        panel.add(obraz2);
        /**
         * utworzenie nowego obiektu JButton i dodanie do niego pobranego z
         * pliku obrazu .png
         */

        przycisk1 = new JButton(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\rozpocznij.png"));
        /**
         * ustawenie położenia i rozmiaru
         */
        przycisk1.setBounds(85, 500, 242, 82);
        /**
         * dodanie do przycisk1 metody nasłuchujacej
         */
        przycisk1.addActionListener(this);
        /**
         * dodanie do JPanel
         */
        panel.add(przycisk1);

        /**
         * utworzenie nowego obiektu JButton i dodanie do niego pobranego z
         * pliku obrazu .png
         */
        przycisk2 = new JButton(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\opis.png"));
        /**
         * ustawenie położenia i rozmiaru
         */
        przycisk2.setBounds(337, 500, 150, 82);
        /**
         * dodanie do przycisk1 metody nasłuchujacej
         */
        przycisk2.addActionListener(this);
        /**
         * dodanie do JPanel
         */
        panel.add(przycisk2);
        /**
         * utworzenie nowego obiektu JButton i dodanie do niego pobranego z
         * pliku obrazu .png
         */
        przycisk3 = new JButton(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\wynik3.png"));
        /**
         * ustawenie położenia i rozmiaru
         */

        przycisk3.setBounds(497, 500, 198, 81);
        /**
         * dodanie do przycisk1 metody nasłuchujacej
         */
        przycisk3.addActionListener(this);
        /**
         * dodanie do JPanel
         */
        panel.add(przycisk3);
        /**
         * utworzenie nowego obiektu JButton i dodanie do niego pobranego z
         * pliku obrazu .png
         */
        przycisk4 = new JButton(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\wyjscie.png"));
        /**
         * ustawenie położenia i rozmiaru
         */
        przycisk4.setBounds(707, 500, 187, 82);
        /**
         * dodanie do przycisk1 metody nasłuchujacej
         */
        przycisk4.addActionListener(this);
        /**
         * dodanie do JPanel
         */
        panel.add(przycisk4);
        /**
         * utworzenie nowego obiektu JlLabel i dodanie do niego pobranego z
         * pliku obrazu .png
         */

        JLabel bg = new JLabel(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaApplication1\\src\\CoDwiePolkule\\mozg.jpg"));
        /**
         * ustawenie położenia i rozmiaru
         */
        bg.setBounds(340, 150, 280, 280);
        /**
         * dodanie do JPanel
         */

        panel.add(bg);
    }

    /**
     * metoda przyjmująca parametr przechowujący informację o źrodle, tzn.
     * wciśniety przycisk. W zalezności od wciżnietego przycisku pojawia się
     * nowe okno
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
         * instrukcja warunkowa, w zalezności od wciśniętego przycisku otwiera
         * się odpowiednie okno
         */
        if (source == przycisk1) {

            try {
                /**
                 * wywołanie metody z klasy bazowej, pobierającej pseudonim
                 * użytkownika i przekierowującej go do odpowiedniego poziomu
                 * gry
                 */
                dane_uzytkownika();
            } catch (InterruptedException ex) {
                Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
            }
            /**
             * zwalnia systemowe zasoby związane z wyświetlaniem okna, ukrywanie
             * okna
             */
            dispose();
            /**
             * zwalnia systemowe zasoby związane z wyświetlaniem okna, ukrywanie
             * okna
             */
            Start.this.dispose();
        }

        if (source == przycisk2) {
            try {
                /**
                 * otworzenie okna, w którym, znajduje się opis
                 */
                new DrugieOkno().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (source == przycisk3) {
            try {
                /**
                 * otworzenie okna, w którym znajduje sie aktualny wynik użytkownika
                 */
                new Wynik().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (source == przycisk4) {
            /**
             * wyjscie z aplikacji
             */
            System.exit(0);
        }

    }
/**
 * główna metoda, w której utworzony jest nowy obiekt klasy Start (uruchomienie aplikacji)
 * @param arg 
 */
    public static void main(String arg[]) {
        Start start = new Start();

    }

} //koniec public class start
