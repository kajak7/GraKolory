
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
 * Klasa będąca osobnym oknem, dziedzicząca po klasie GłowneOkno, decydująca,
 * który tryb gry został wybrany
 *
 */
public class Tryb extends GlowneOkno implements ActionListener {

    /**
     * Konstruktor przyjmujący jako parametr obiekt stan klasy Stan 
     *
     * @param stan
     */
    public Tryb(Stan stan) {
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
         * ustawienie koloru tła JPanel
         */
        panel.setBackground(new Color(255, 240, 245));
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
        setTitle("Wybór trybu gry");

    }

    /**
     * metoda, w której dodawane są komponenty i ustawiane ich własciwości (
     * JLabel i JButton) oraz wywołanie metody nasłuchującej addActionListener
     */
    public void opis() {
        /**
         * utworzenie nowego obiektu JLabel i dodanie do niego pobranego z pliku gif'a
         */
        etykieta1 = new JLabel(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\tuptam.gif"));
        /**
         * ustaienie położenia i rozmiaru JLabel etykieta0
         */
        etykieta1.setBounds(110, 100, 350, 269);

        /**
         * dodanie JLabel do JPanel
         */
        panel.add(etykieta1);

        /**
         * utworzenie nowego obiektu JLabel i dodanie do niego pobranego z pliku gif'a
         */
        etykieta2 = new JLabel(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\tryb.png"));
        /**
         * ustawienie położenia i rozmiaru JLabel etykieta1
         */
        etykieta2.setBounds(517, 80, 328, 78);
        /**
         * dodanie JLabel do JPanel
         */
        panel.add(etykieta2);
        /**
         *utworzenie nowego obiektu JButton i dodanie do niego pobranego z pliku obrazu .png
         */
        przycisk1 = new JButton(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\polski.png"));
        /**
         * ustawienie położenia i rozmiaru JButton przycisk1
         */
        przycisk1.setBounds(530, 280, 302, 78);
        /**
         * dodanie do JButton przycisk1 metodu nasłuchujacej
         */
        przycisk1.addActionListener(this);
        /**
         * dodanie JButton do JPanel
         */
       panel.add(przycisk1);
        /**
         *utworzenie nowego obiektu JButton i dodanie do niego pobranego z pliku obrazu .png
         */
        przycisk2= new JButton(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\angielski.png"));
        /**
         * ustawienie położenia i rozmiaru JButton przycisk2
         */
        przycisk2.setBounds(530, 180, 301, 78);
        /**
         * dodanie do JButton przycisk2 metodu nasłuchujacej
         */
       przycisk2.addActionListener(this);
        /**
         * dodanie JButton do JPanel
         */
        panel.add(przycisk2);

    }

    /**
     * metoda przyjmująca parametr przechowujący informację o źrodle, tzn.
     * wciśniety przycisk. W zalezności od wciżnietego przycisku pojawia się
     * nowe okno z wybranym trybem gry
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
         * Instrukcja warunkowa w celu wybrania trybu gry
         */
        if (source == przycisk1) {

            try {
                /**
                 * atrybutowi tryb klasy stan zostaje przypisana wartośc boolean
                 * false, tzn. tryb gry w języku polskim
                 */
                stan.tryb = false;
                /**
                 * zapisanie trybu w pliku
                 */
                stan.zapiszStan("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\danegracza.txt");
                /**
                 * otworzenie okna gry z odpowiadającym stanem uzytkownika
                 */
                new OknoGry(this.stan).setVisible(true);

            } catch (InterruptedException | IOException | ClassNotFoundException ex) {
                Logger.getLogger(Tryb.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (source == przycisk2) {

            try {
                /**
                 * atrybutowi tryb klasy stan zostaje przypisana wartośc boolean
                 * true, tzn. tryb gry w języku angielskim
                 */
                stan.tryb = true;
                /**
                 * zapisanie trybu w pliku
                 */
                stan.zapiszStan("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\danegracza.txt");
                /**
                 * otworzenie okna gry z odpowiadającym stanem uzytkownika
                 */
                new OknoGry(true, this.stan).setVisible(true);

            } catch (InterruptedException ex) {
                Logger.getLogger(Tryb.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Tryb.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Tryb.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        /**
         * zwalnia systemowe zasoby związane z wyświetlaniem okna, ukrywanie okna
         */
        this.dispose();

    }
}
