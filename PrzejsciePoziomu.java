
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
 * się po ukończeniu całej gry
 */
public class PrzejsciePoziomu extends GlowneOkno implements ActionListener {

    /**
     * Konstruktor klasy PrzejsciePoziomu
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public PrzejsciePoziomu() throws IOException, ClassNotFoundException {
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
        setTitle("Gratulacje");

    }

    /**
     * metoda, w której dodawane są komponenty i ustawiane ich własciwości (
     * JLabel i JButton) oraz wywołanie metody nasłuchującej addActionListener
     */
    public void opis() {
        /**
         * utworzenie nowego obiektu JLabel i dodanie do niego pobranego z pliku
         * gif'a
         */
        etykieta1 = new JLabel(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\tuptam.gif"));
        /**
         * ustawenie położenia i rozmiaru JLabel etykieta1
         */
        etykieta1.setBounds(150, 110, 350, 269);
        /**
         * dodanie etykieta1 do JPanel
         */
        panel.add(etykieta1);
        /**
         * utworzenie nowego obiektu JLabel i dodanie do niego pobranego z pliku
         * obrazu .png
         */
        etykieta2 = new JLabel(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\gratulacje.png"));
        /**
         * ustawenie położenia i rozmiaru JLabel etykieta2
         */
        etykieta2.setBounds(545, 80, 368, 89);
        /**
         * dodanie etykieta2 do JPanel
         */
        panel.add(etykieta2);
        /**
         * utworzenie nowego obiektu JButton i dodanie do niego pobranego z
         * pliku obrazu .png
         */
        przycisk1 = new JButton(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\zwynik.png"));
        /**
         * ustawienie położenia i rozmiaru JButton przycisk1
         */
        przycisk1.setBounds(580, 200, 271, 76);
        /**
         * dodanie do JButton przycisk1 metodu nasłuchujacej
         */
        przycisk1.addActionListener(this);
        /**
         * dodanie przycisk1 do JPanel
         */
        panel.add(przycisk1);

        przycisk2 = new JButton(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\menu2.png"));
        /**
         * ustawienie położenia i rozmiaru JButton przycisk2
         */
        przycisk2.setBounds(580, 300, 270, 72);
        /**
         * dodanie do JButton przycisk2 metodu nasłuchujacej
         */
        przycisk2.addActionListener(this);
        /**
         * dodanie przycisk2 do JPanel
         */
        panel.add(przycisk2);

    }

    /**
     * metoda przyjmująca parametr przechowujący informację o źrodle, tzn.
     * wciśniety przycisk. W zalezności od wciżnietego przycisku pojawia się
     * nowe oknoz wynikiem gracza bądź przejścia do okna startowego (MENU)
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        /**
         * pobieranie źródła ae
         */
        Object source = ae.getSource();
        /**
         * wywołanie metody odtwarzającej dźwięk
         */
        klikniecie();
        /**
         * Instrukcja warunkowa w celu wybrania opcji wyswietlania wyniku bądź
         * przejścia do okna startowego (MENU)
         */
        if (source == przycisk1) {
            try {
                /**
                 * otworzenie okna z wynikiem gracza
                 */
                new Wynik().setVisible(true);
                
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(PrzejsciePoziomu.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (source == przycisk2) {
           
            /**
             * otworzenie okna startowego
             */
            new Start().setVisible(true);
            /**
             * zwalnia systemowe zasoby związane z wyświetlaniem okna, ukrywanie
             * okna
             */
            this.dispose();
        }

    }
}
