
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
 * GlowneOkno-klasa bazowa, dziedzicząca po JFrame
 */
public class GlowneOkno extends JFrame {

    /**
     * utworzenie kontenera, do którego będą dodawane komponenty
     */
    public JPanel panel = new JPanel();
    /**
     * deklaracja pól etykiet oraz przycisków
     */
    JLabel etykieta1;
    JLabel etykieta2;
    JLabel etykieta3;
    JButton przycisk1;
    JButton przycisk2;
    JButton przycisk3;
    JButton przycisk4;
    /**
     * deklaracja stanu- obiektu klasy Stan, implementującej interfejs
     * Serializable
     */
    Stan stan;
    /**
     * zmienna typu boolean, która przyjmuje wartość true dla trybu angielskiego
     * lub false dla trybu polskiego
     */
    public boolean b = true;
    /**
     * zmienna typu String przechowująca ściezkę pliku, w którym będzie
     * zapisywany stan gry danego uzytkownika
     */
    public String sciezka = "C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\danegracza.txt";
    /**
     * deklaracja obiektu s klasy Stan
     */
    public Stan s;
    /**
     * Pobieraie parametrów ekranu
     */
    Dimension d;

    /**
     * Metoda, która pobiera pseudonim użytkownika oraz sprawdza, czy dany
     * użytkownik istnieje w pliku
     *
     * @throws InterruptedException
     * @throws IOException
     * @throws ClassNotFoundException
     *
     */
    public void dane_uzytkownika() throws InterruptedException, IOException, ClassNotFoundException {
        /**
         * utworzenie tablicy klasy String, posiadająca 3 opcje
         */
        String[] options = {"Jestem nowy", "juz gralem", "Wyjdź"};
        /**
         * utworzenie kontenera, do którego będą dodawane komponenty
         */
        JPanel panel_dane = new JPanel();
        /**
         * utworzenie nowego obiektu JLabel i dodanie do niego tekstu
         */
        JLabel lbl = new JLabel("WPROWADŹ SWOJE IMIE: ");
        /**
         * utworzenie nowego obiektu JLabel i dodanie do niego pobranego z pliku
         * gif'a
         */
        JLabel lb2 = new JLabel((new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\tuptam.gif")));
        /**
         * utworzenie nowego obiektu pola tekstowego
         */
        JTextField txt = new JTextField(10);
        /**
         * dodanie pola tekstowego i etykiet to kontenera panel_dane
         */
        panel_dane.add(lbl);
        panel_dane.add(txt);
        panel_dane.add(lb2);
        /**
         * utworzenie nowego obiektu klasy Stan
         */
        Stan s = new Stan();
        /**
         * zmiennna typu int, do której przypisana jest metoda showOptionDialog
         * zwracająca liczbę całkowitą, odpowiadającą wyborowi dokonanego przez
         * użytkownika
         */
        int wybrana_opcja = JOptionPane.showOptionDialog(null, panel_dane,//
                "Twój pseudonim", JOptionPane.NO_OPTION,//
                JOptionPane.QUESTION_MESSAGE, //
                null, options, options[0]);
        /**
         * case 0- nowy uzytkownik,
         */
        switch (wybrana_opcja) {
            case 0:
                /**
                 * przypisuje wartość pobraną z pola tekstowego do pola name w
                 * obiekcie klasy Stan
                 */
                s.name = txt.getText(); //potrzebne do rankingu
                /**
                 * rozpoczecie gry na poziomie pierwszym i przypisanie tej
                 * wartości do pola w obiekcie Stan
                 */
                s.poziom = 1;
                /**
                 * otworzenie okna z wyborem gry i przesyłanie informacji o
                 * stanie użytkownika
                 */
                new Tryb(s).setVisible(true);
                break;

            case 1:
                /**
                 * case 1 - uzytkownik rozpoczyna grę ponownie, do obiektu s
                 * przypisujemy wartości odczytane z pliku( informacje o
                 * użytkowniku
                 */
                s = s.czytajStan(sciezka);
                /**
                 * instrukcja warunkowa sprawdzająca pseudonim uzytkownika, czy
                 * znajduje sie w pliku jako ostatni gracz
                 */
                if (!s.name.contains(txt.getText())) {
                    /**
                     * wyswietlanie okienka z komunikatem
                     */
                    JOptionPane.showMessageDialog(null, "Brak pseudonimu w bazie");
                    /**
                     * ponowne wyswietlenie okienka startowego
                     */
                    new Start().setVisible(true);

                } else if (s.name.contains(txt.getText())) {
                    /**
                     * s.zakonczenie=true, jezeli uzytkownik przeszedł wszystkie
                     * 10 poziomow, rozpoczyna gre znowu od 1 poziomu
                     */
                    if (s.zakonczenie == true) {
                        /**
                         * rozpoczecie gry na poziomie pierwszym i przypisanie
                         * tej wartości do pola w obiekcie Stan
                         */
                        
                        s.poziom = 1;
                        /**
                         * wyzerownaie punktów
                         */
                        s.bonus=0;
                    }
                    /**
                     * wyswietlanie okna z wyborem trybu gry
                     */
                    new Tryb(s).setVisible(true);
                }

                break;
            default:
                panel_dane.setVisible(false);
                break;
        }
    }

    /**
     * metoda ustawiająca zmienną typu boolean b(odrozniającą tryb gry w języku
     * polskim od języka angielskiego) w zależności od zmiennej typu boolean
     * tryb, którego wartość zostaje zapisana w obiekcie stan
     */
    public void zmianaTrybu() {
        if (stan.tryb == true) {
            b = true; //tryb gry w języku angielskim
        } else {
            b = false; // tryb gry w języku polskim
        }
    }

    /**
     * metoda która pobiera parametry okna użytkownika i w zależności od
     * pobranych parametrów wyświetla okno gry na środku ekranu, bez możliwości
     * zmiany rozmiaru okna
     */
    public void ustaw() {
        d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width / 2, d.height / 2); // ustawienie rozmiaru okna 
        setVisible(true); // aby okno było widoczne
        setLocationRelativeTo(null); //aby okno było na środku
        setResizable(false); // aby nie bylo mozliwości zmiany rozmiaru okna
    }

    /**
     * metoda odtwarzająca dżwięk .au zapisany w pliku, przy udzieleniu dobrej
     * odpowiedzi
     */
    public void dobraOdpowiedz() {
        try {
            AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 8000, 16, 1, 2, 8000, false);
            File file = new File("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\correct.au");
            AudioInputStream stream = AudioSystem.getAudioInputStream(file);
            AudioInputStream stream_new = AudioSystem.getAudioInputStream(format, stream);
            Clip clip = AudioSystem.getClip();
            clip.open(stream_new);
            clip.start();
        } catch (Exception e) {
        }
    }

    /**
     * metoda odtwarzająca dżwięk .au zapisany w pliku, przy udzieleniu złej
     * odpowiedzi
     */
    public void zlaOdpowiedz() {
        try {
            AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 8000, 16, 1, 2, 8000, false);
            File file = new File("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\incorrect.au");
            AudioInputStream stream = AudioSystem.getAudioInputStream(file);
            AudioInputStream stream_new = AudioSystem.getAudioInputStream(format, stream);
            Clip clip = AudioSystem.getClip();
            clip.open(stream_new);
            clip.start();
        } catch (Exception e) {
        }
    }

    /**
     * metoda odtwarzająca dźwiek .au przy kliknięciu przycisków dodanych do
     * odpowiednich kontenerów JPanel
     */
    public void klikniecie() {
        try {
            AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 8000, 16, 1, 2, 8000, false);
            File file = new File("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\clik.au");
            AudioInputStream stream = AudioSystem.getAudioInputStream(file);
            AudioInputStream stream_new = AudioSystem.getAudioInputStream(format, stream);
            Clip clip = AudioSystem.getClip();
            clip.open(stream_new);
            clip.start();
        } catch (Exception e) {
        }
    }

    /**
     * metoda odtwarzająca dźwięk .au po ukończeniu 10 poziomu,przy otworzeniu
     * okna PrzejsciePoziomu
     */
    public void dzwiekWow() {
        try {
            AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 8000, 16, 1, 2, 8000, false);
            File file = new File("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\wow.au");
            AudioInputStream stream = AudioSystem.getAudioInputStream(file);
            AudioInputStream stream_new = AudioSystem.getAudioInputStream(format, stream);
            Clip clip = AudioSystem.getClip();
            clip.open(stream_new);
            clip.start();
        } catch (Exception e) {
        }
    }

}
