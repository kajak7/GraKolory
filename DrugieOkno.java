/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Katherine
 */
/**
 * Klasa będąca osobnym oknem, dziedzicząca po klasie GłowneOkno,wyswietlajaca
 * opis gry
 */
public class DrugieOkno extends GlowneOkno implements ActionListener {
/**
 * Konstruktor klasy DrugieOkno
 * @throws IOException 
 */
    public DrugieOkno() throws IOException {
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
        panel.setBackground(new Color(216, 191, 216));
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
        setTitle("Na czym to polega?");

    }

    /**
     * metoda, w której dodawane są komponenty i ustawiane ich własciwości (
     * JLabel i JButton) oraz wywołanie metody nasłuchującej addActionListener
     */
    public void opis() {
        /**
         *
         * utworzenie nowego obiektu JLabel i dodanie do niego pobranego z pliku
         * obrazu .png
         */
        etykieta1 = new JLabel(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\zasady.png"));
        /**
         * ustawenie położenia i rozmiaru JLabel etykieta1
         */
        etykieta1.setBounds(250, 150, 653, 231);
        /**
         * dodanie etykieta1 do JPanel
         */
        panel.add(etykieta1);
        /**
         *
         * utworzenie nowego obiektu JLabel i dodanie do niego pobranego z pliku
         * obrazu .png
         */
        etykieta2 = new JLabel(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\jak.png"));
        /**
         * ustawenie położenia i rozmiaru JLabel etykieta1
         */
        etykieta2.setBounds(265, 60, 420, 68);
        /**
         * dodanie etykieta2 do JPanel
         */
        panel.add(etykieta2);
        /**
         *
         * utworzenie nowego obiektu JLabel i dodanie do niego pobranego z pliku
         * obrazu .png
         */
        etykieta3 = new JLabel(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\mysle.gif"));
        /**
         * ustawenie położenia i rozmiaru JLabel etykieta1
         */
        etykieta3.setBounds(30, 160, 200, 200);
        /**
         * dodanie etykieta3 do JPanel
         */
        panel.add(etykieta3);
        /**
         *
         * utworzenie nowego obiektu JButton i dodanie do niego pobranego z
         * pliku obrazu .png
         */
        przycisk1 = new JButton(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\zamknij.png"));
        /**
         * ustawenie położenia i rozmiaru JButton przycisk1
         */
        przycisk1.setBounds(680, 400, 184, 78);
        /**
         * dodanie do JButton przycisk1 metody nasłuchujacej
         */
        przycisk1.addActionListener(this);
        /**
         * dodanie przycisk1 do JPanel
         */
        panel.add(przycisk1);

    }

    /**
     * metoda przyjmująca parametr przechowujący informację o źrodle, tzn.
     * wciśniety przycisk. Jeżeli przycisk został wciśnięty okno z opisem
     * zostaje zamkniete
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * wywołanie metody odtwarzającej dźwięk
         */
        klikniecie();
        /**
         * zwalnia systemowe zasoby związane z wyświetlaniem okna, ukrywanie
         * okna
         */
        this.dispose();

    }

}
