
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.JOptionPane;

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
 * Klasa, w której wykonuje się gra
 */
public class OknoGry extends GlowneOkno implements ActionListener {

    // deklaracja obiektów, zmiennych
    /**
     * btn8- przycisk MENU, przekierowujący do okna startowego oraz zapisujący
     * aktualny stan użytkownika
     */
    private JButton btn8;
    /**
     * btn7-przycisk, w którym wyświetla się aktualny poziom użytkownika
     */
    private JButton btn7;
    /**
     * btn6- przycisk, który wyswietla tekst "Pozostało do końca"
     */
    private JButton btn6;
    /**
     * btn5- przycisk, który wyswietla tekst "Poziom"
     */
    private JButton btn5;
    /**
     * btn4-przycisk, który wyświetla ilośc zdobytych punktów
     */
    private JButton btn4;
    /**
     * btn3- przycisk, który wyswietla NIE lub NO
     */
    private JButton btn3;
    /**
     * btn2-przycisk, który wyswietla Tak lub YES
     */
    private JButton btn2;
    /**
     * btn1- przycisk, który wyświetla zmieniającą się treść ( kolor tła, kolor
     * przycisku, tekst)
     */
    private JButton btn1;
    /**
     * deklaracja obiektu kolorTlaPrzycisku typu wyliczeniowego, od niego zależy
     * wyglad (kolor) przycisku, na którym znajduje się tekst
     */
    private Kolory kolorTlaPrzycisku;
    /**
     * deklaracja obiektu kolorNapisu typu wyliczeniowego,od niego zależy wyglad
     * (kolor) tekstu
     */
    private KolorTekstu kolorNapisu;
    /**
     * deklaracja obiektu tekst klasy String, do którego przypisany będzie tekst
     * (NIEBIESKI, CZERWONY,ZIELONY,FIOLETOWY)
     */
    private String tekst;
    /**
     * deklaracja zmiennej statycznej typu int,
     */
    private static int punkty;
    /**
     * deklaracja zmiennej typu int, która przechowuje wartość punktów, którą
     * należy zdobyć aby ukończyć podpoziom
     */
    private int pktKonca;
    /**
     * deklaracja obiektu klasy Timer, który steruje aplikacją,generując metodę
     * actionPerformed
     */
    private Timer timer;
    /**
     * deklaracja zmiennej typu int, do której przypisywany jest czas gry
     * użytkownika
     */
    private int czas;
    /**
     * deklaracja zmiennej typu int, która przechowuje czas, po którym następuje
     * zakończenie podpoziomu
     */
    private int czasKonca;
    /**
     * deklaracja obiektu klasy JProgressBar, który przedstawia zmianę postępu
     * (czas)
     */
    private JProgressBar pb;
    /**
     * utworzenie nowego obiektu klasy JPanel, do którego, będa dodawane
     * komponenty znajdujące się w oknie gry
     */
    private JPanel tlo = new JPanel();
    /**
     * Pobranie parametrów ekranu uzytkownika
     */
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); //Pobieranie parametrów ekranu
    /**
     * deklaracja i inicjalizacja zmiennej statycznej typu int,w której
     * przechowywany juest wynik użytkownika
     */
    static int bonusT = 0;
    /**
     * deklaracja obiektu stan klasy Stan
     */
    private Stan stan;
    /**
     * zmienna boolean odrozniająca konstruktor gry w języku polskim od
     * angielskiego
     */
    public boolean c;

    /**
     * Konstruktor klasy OknoGry - tryb gry w języku polskim, który przyjmuje
     * jako parametr obiekt stan klasy Stan (cechy każdego poziomu)
     *
     * @param stan
     * @throws InterruptedException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public OknoGry(Stan stan) throws InterruptedException, IOException, ClassNotFoundException {
        //Polski
        /**
         * zmiennej boolean przypisuje wartość false, tzn. tryb gry w języku
         * polskim
         */
        b = false;
        /**
         * odróznienie parametru stan od atrybutu klasy stan i przypisujący
         * właśnie ten parametr wejściowy stan do klasy Stan
         */
        this.stan = stan;
        /**
         * instrukacja warunkowa, w której znajdują się cechy danego podpoziomu
         * (punkty do zdobycia i czas gry)
         */
        if (stan.poziom == 1) {
            czasKonca = 100;
            pktKonca = 5;
        }
        if (stan.poziom == 2) {
            czasKonca = 100;
            pktKonca = 7;
        }
        if (stan.poziom == 3) {
            czasKonca = 110;
            pktKonca =  9;
        }
        if (stan.poziom == 4) {
            czasKonca = 110;
            pktKonca = 11;

        }
        if (stan.poziom == 5) {
            czasKonca = 120;
            pktKonca = 13;

        }
        if (stan.poziom == 6) {
            czasKonca = 120;
            pktKonca = 15;

        }
        if (stan.poziom == 7) {
            czasKonca = 130;
            pktKonca =17;

        }
        if (stan.poziom == 8) {
            czasKonca = 130;
            pktKonca = 19;

        }
        if (stan.poziom == 9) {
            czasKonca = 130;
            pktKonca =  20;

        }
        if (stan.poziom == 10) {
            czasKonca = 145;
            pktKonca = 21;

        }

        /**
         * pobieranie za pomocą metody wylosuj() obiektu nazwa (tekst
         * pojawiajacy sie na przycisku) klasy String i przypisanie go do
         * obiektu tekst klasy String
         */
        tekst = LosujKolor.wylosuj().getNazwa();
        /**
         * wywołanie metody
         */
        ustaw();

    }

    /**
     * Konstruktor klasy OknoGry - tryb gry w języku angielskim który przyjmuje
     * jako parametr obiekt stan klasy Stan i zmienna boolean c (cechy każdego
     * poziomu)
     *
     * @param c
     * @param stan
     * @throws InterruptedException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public OknoGry(boolean c, Stan stan) throws InterruptedException, IOException, ClassNotFoundException {
        /**
         * zmiennej boolean przypisuje wartość true, tzn. tryb gry w języku
         * angielskim
         */
        b = true;
        /**
         * odróznienie parametru stan od atrybutu klasy stan i przypisujący
         * właśnie ten parametr wejściowy stan do klasy Stan
         */
        this.stan = stan;
        /**
         * instrukacja warunkowa, w której znajdują się cechy danego podpoziomu
         * (punkty do zdobycia i czas gry)
         */
        if (stan.poziom == 1) {
            czasKonca = 100;
            pktKonca = 5;
        }
        if (stan.poziom == 2) {
            czasKonca = 100;
            pktKonca = 7;
        }
        if (stan.poziom == 3) {
            czasKonca = 110;
            pktKonca = 9;
        }
        if (stan.poziom == 4) {
            czasKonca = 110;
            pktKonca = 11;

        }
        if (stan.poziom == 5) {
            czasKonca = 120;
            pktKonca = 13;

        }
        if (stan.poziom == 6) {
            czasKonca = 120;
            pktKonca = 15;

        }
        if (stan.poziom == 7) {
            czasKonca = 130;
            pktKonca = 17;

        }
        if (stan.poziom == 8) {
            czasKonca = 130;
            pktKonca = 19;

        }
        if (stan.poziom == 9) {
            czasKonca = 130;
            pktKonca = 20;

        }
        if (stan.poziom == 10) {
            czasKonca = 145;
            pktKonca = 21;
        }
        /**
         * pobieranie za pomocą metody wylosuj() obiektu nazwa (tekst
         * pojawiajacy sie na przycisku) klasy String i przypisanie go do
         * obiektu tekst klasy String
         */
        tekst = LosujKolor.wylosuj().getNazwa();
        /**
         * wywołanie metody
         */
        ustaw();
        /**
         * wywołanie metody
         */
        zmienKolory();

    }

    /**
     * metoda która wyświetla okno gry na środku ekranu w zależności od
     * parametórw pobrancyh od uzytkownika, bez możliwości zmiany rozmiaru okna,
     * ustawia kolor tła,
     */
    @Override
    public void ustaw() {
        add(tlo);//dodanie JPanel
        tlo.setLayout(null);//mozliwość własnego ustawienia komponentów
        tlo.setBackground(new Color(255, 240, 245)); // ustawienie koloru tła
        PanelGlowny();//wywołanie metody, w kótrej dodawane są komponenty i metody nasłuchujące
        setResizable(false); // brak mozliwosci zmiany rozmiaru okna
        setSize(d.width / 2, d.height / 2); // ustawienie rozmiaru okna
        setLocationRelativeTo(null); //żeby okno było na środk
        setVisible(true);// aby okno było widoczne
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // zamkniecie okna i zwolnienie zasobow

    }

    /**
     * metoda, w której nastepuje dodanie komponentów OknaGry
     */
    public void PanelGlowny() {
        /**
         * pobieranie za pomocą metody wylosuj() typu wyliczeniowego enum Kolory
         * (kolor) pojawiajacy sie na przycisku)i przypisanie go do obiektu
         * kolorTlaPrzycisku klasy Kolory
         */

        kolorTlaPrzycisku = LosujKolor.wylosuj().getKolory();
        /**
         * pobieranie za pomocą metody wylosuj() typu wyliczeniowego enum
         * KolorTekstu (kolor) pojawiajacy sie na przycisku)i przypisanie go do
         * obiektu kolorNapisu klasy KolorTekstu
         */
        kolorNapisu = LosujKolor.wylosuj().getKolorTekstu();
        /**
         * utworzenie nowego obiektu JLabel i dodanie do niego pobranego z pliku
         * obrazu .jpg
         */
        JLabel bg = new JLabel(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\tlo2.jpg"));
        /**
         * połozenie i rozmiar JLabel bg
         */
        bg.setBounds(0, 0, d.width / 2, d.height / 2);

        btn1 = new JButton(); //utworzenie nowego obiektu klasy JButton
        btn1.setBounds(280, 120, 400, 200);//ustawienie położenia i rozmiaru przycisku
        btn1.setText(tekst); // ustawienie tekstu, znajdującego się na przycisku
        btn1.setFont(new Font("droid", Font.BOLD, 40));// ustawienie czcionki 
        btn1.setForeground(kolorNapisu.getColor()); //ustawienie koloru napisu
        btn1.setBackground(kolorTlaPrzycisku.getColor());//ustawienie koloru tla przycisku
        /**
         * instrukcja warunkowa wyswietlająca w zaleznosci od trybu inny
         * przycisk
         */
        if (b == false) {
            btn2 = new JButton(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\button_TAK.png"));
        } else {
            btn2 = new JButton(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\button_YES.png"));
        }

        btn2.setBounds(360, 340, 124, 83);//ustawienie położenia i rozmiaru przycisku
        btn2.addActionListener(this);//dodanie metody nasłuchującej
        /**
         * instrukcja warunkowa wyswietlająca w zaleznosci od trybu inny
         * przycisk
         */
        if (b == false) {
            btn3 = new JButton(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\button_NIE.png"));
        } else {
            btn3 = new JButton(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\button_NO.png"));
        }

        btn3.setBounds(490, 340, 116, 83);//ustawienie położenia i rozmiaru przycisku
        btn3.addActionListener(this);//dodanie metody nasłuchującej

        btn4 = new JButton();
        btn4.setBounds(750, 25, 57, 57);//ustawienie położenia i rozmiaru przycisku
        btn4.setFont(new Font("arial", Font.BOLD, 20));// ustawienie czcionki 
        btn4.setBackground(new Color(175, 238, 238));//ustawienie tla przycisku
        btn4.setText("" + punkty);//ustawienie tekstu ( wartośc zdobytych punktów)

        btn5 = new JButton(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\poziom.png"));
        btn5.setBounds(60, 27, 134, 57);//ustawienie położenia i rozmiaru przycisku

        btn6 = new JButton(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\pozostalo.png"));
        btn6.setBounds(500, 25, 250, 25);//ustawienie położenia i rozmiaru przycisku

        btn7 = new JButton();
        btn7.setBounds(193, 27, 58, 58);//ustawienie położenia i rozmiaru przycisku
        btn7.setFont(new Font("arial", Font.BOLD, 20));// ustawienie czcionki 
        btn7.setBackground(new Color(255, 228, 225));//ustawienie tla przycisku
        btn7.setText("" + stan.poziom);//ustawienie tekstu- poziomu, na którym aktualnie gracz się znajduje

        btn8 = new JButton(new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\button_menu.png"));
        btn8.setBounds(780, 410, 118, 69);//ustawienie położenia i rozmiaru przycisku
        btn8.addActionListener(this);//dodanie metody nasłuchującej

        pb = new JProgressBar();//utworzenie nowego obiektu klasy JProgressBar
        pb.setBounds(500, 50, 250, 30);//ustawienie położenia i rozmiaru paska postępu
        pb.setValue(0);//ustawienie poczatkowej wartości

        /**
         * utworzenie klasy wewnętrznej i utworzenie nowego obiektu klasy
         * implementującej ActionListener
         */
        ActionListener actionListenerTimer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                pb.setValue(czas);//ustawienie na pasku postępu aktualnego czasu

                pb.setMaximum(czasKonca);//ustawienie końca paska postępu

                try {
                    /**
                     * wywołanie metody
                     */
                    poziom();
                } catch (InterruptedException | IOException | ClassNotFoundException ex) {
                    Logger.getLogger(OknoGry.class.getName()).log(Level.SEVERE, null, ex);
                }
                /**
                 * inkrementacja zmiennej czas
                 */
                ++czas;

            }
        };
        /**
         * utowrzenie nowego obiektu klasy Timer o okresie zmiany 100ms ( co
         * taki czas będzie wywoływał metodę nasłuchującą) metodzie
         * nasłuchującej
         */
        timer = new Timer(100, actionListenerTimer);
        /**
         * mozliwosc wielokrotnego powtarzania
         */
        timer.setRepeats(true);
        /**
         * rozpoczecie działania obiektu timer
         */
        timer.start();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException ex) {
            Logger.getLogger(OknoGry.class.getName()).log(Level.SEVERE, null, ex);
        }
        /**
         * dodanie komponentów przycisków i pól etykiety do JPanel
         */
        tlo.add(btn1);
        tlo.add(btn2);
        tlo.add(btn3);
        tlo.add(btn4);
        tlo.add(btn5);
        tlo.add(btn6);
        tlo.add(btn7);
        tlo.add(btn8);
        tlo.add(bg);
        tlo.add(pb);

    }

    /**
     * metoda przyjmująca parametr przechowujący informację o źrodle, tzn.
     * wciśniety przycisk. W zalezności od wciśnietego przycisku, sprawdzana
     * jest zgodność odpowiedzi i dodawane punkty, jeżeli odpowiedź będzie
     * niezgodna stan gry uzytkownika zostaje zapamiętany, gra zatryzmana a
     * użytkownik ma wybór czy chce spróbowac grać dalej czy zakończyc gre(
     * wyswietlanie okna Komunikatu)
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();  // pobieranie źródła ae

        if (source == btn3 || source == btn2) {
            /**
             * Przypisanie zmiennej boolean wartości którą zwraca metoda
             * czyTakieSame
             */
            boolean czyTakieSame = czyTakieSame(tekst, kolorNapisu.name());
            //dobra odpowiedź
            if (czyTakieSame && source == btn2) {
                punkty++;
                dobraOdpowiedz();// wywolanie metody odtwarzajacej dźwięk
                //zla odpowiedz
            } else if (!czyTakieSame && source == btn3) {
                punkty++;
                dobraOdpowiedz();// wywolanie metody odtwarzajacej dźwięk
                //zla odpowiedz
            } else {
                zlaOdpowiedz();// wywolanie metody odtwarzajacej dźwięk
                punkty = 0;
                stan.zapiszStan("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\danegracza.txt");//zapisanie stanu użytkownika
                s = s.czytajStan("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\danegracza.txt");//odczytanie stanu użytkownika
                try {
                    new Komunikat(s).setVisible(true); //wyswietlanie okna z mozliwoscia wyboru opcji ponownej gry
                } catch (InterruptedException ex) {
                    Logger.getLogger(OknoGry.class.getName()).log(Level.SEVERE, null, ex);
                }
                timer.stop();//zatrzymanie czasu
                OknoGry.this.dispose(); //ukrycie okna

            }
            btn4.setText("" + punkty);//ustawienie wartości punktów
            zmienKolory();//wywołanie metody

            //zapisanie stanu  i powót do MENU
        } else if (source == btn8) {

            stan.zapiszStan("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\danegracza.txt"); //zapisanie stanu użytkownika
            new Start().setVisible(true);// otowrzenie okna startowego
            OknoGry.this.dispose();//ukrycie okna
            timer.stop();//zatrzymanie czasu
        }

    }

    /**
     * metoda zwracająca zmienną typu boolean w zalezności czy wartości obiektów
     * są sobie równe
     *
     * @param tekst
     * @param KolorNapisu
     * @return
     */
    private boolean czyTakieSame(String tekst, String KolorNapisu) {
        return tekst.equals(KolorNapisu);
    }

    /**
     * metoda, która zmienia pojawiającą się zawartośc( tekst, kolor tła
     * przycisku, kolor napisu) Gdy wybrano tryb angielski tekst wyswietlany w
     * języku polskim jest szybko zamieniany na tekst wyświetlany w języku
     * angielskim ( instrukcja switch)
     */
    private void zmienKolory() {
        /**
         * pobieranie za pomocą metody wylosuj() typu wyliczeniowego enum Kolory
         * (kolor) pojawiajacy sie na przycisku)i przypisanie go do obiektu
         * kolorTlaPrzycisku klasy Kolory
         */
        kolorTlaPrzycisku = LosujKolor.wylosuj().getKolory();
        /**
         * pobieranie za pomocą metody wylosuj() typu wyliczeniowego enum
         * KolorTekstu (kolor)napisu i przypisanie go do obiektu kolorNapisu
         * klasy KolorTekstu
         */
        kolorNapisu = LosujKolor.wylosuj().getKolorTekstu();
        /**
         * pobieranie za pomocą metody wylosuj() obiektu nazwa (tekst
         * pojawiajacy sie na przycisku) klasy String i przypisanie go do
         * obiektu tekst klasy String
         */
        tekst = LosujKolor.wylosuj().getNazwa();
        //instrukcja warunkowa w zalezności od trybu gry wyświetlane są przycisku w odpowiednim języku
        if (b == false) {
            btn1.setText(tekst);

        } else if (b == true) {

            switch (tekst) {
                case "NIEBIESKI":
                    System.out.println("Tekst napisu to " + tekst + "kolor napisu to " + kolorNapisu);
                    btn1.setText("BLUE");
                    tekst = "NIEBIESKI";

                    break;
                case "ZIELONY":
                    System.out.println("Tekst napisu to " + tekst + "kolor napisu to " + kolorNapisu);
                    btn1.setText("GREEN");
                    tekst = "ZIELONY";
                    break;
                case "FIOLETOWY":
                    System.out.println("Tekst napisu to " + tekst + "kolor napisu to " + kolorNapisu);
                    btn1.setText("PURPLE");
                    tekst = "FIOLETOWY";
                    break;
                case "CZERWONY":
                    System.out.println("Tekst napisu to " + tekst + "kolor napisu to " + kolorNapisu);
                    btn1.setText("RED");
                    tekst = "CZERWONY";
                    break;

                default:
                    break;
            }

        }
        btn1.setForeground(kolorNapisu.getColor());//ustawienie koloru tekstu 
        btn1.setBackground(kolorTlaPrzycisku.getColor()); //ustawienie koloru tla przycisku

    }

    /**
     * metoda, która decyduje czy użytkownik przechodzi dany podpoziom czy też
     * nie ( w zależności od czasu i zdobytych punktów)
     *
     * @throws InterruptedException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void poziom() throws InterruptedException, IOException, ClassNotFoundException {
        //kazdy poziom oprócz ostatniego
        if (punkty == pktKonca && punkty != 21) {
            bonus_czas(); //wywołanie funkcji zliczającej sume punktów
            timer.stop(); //zatrzymanie czasu
            punkty = 0; //zerowanie punktów

            String[] options = {"TAK, CHCĘ ĆWICZYĆ", "WYJDŹ"};
            JPanel panel = new JPanel();//dodanie nowego obiektu klasy JPanel
            JLabel lbl = new JLabel((new ImageIcon("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\tuptam.gif")));
            panel.add(lbl);//dodanie lbl do JPanel
            /**
             * zmiennna typu int, do której przypisana jest metoda
             * showOptionDialog zwracająca liczbę całkowitą, odpowiadającą
             * wyborowi dokonanego przez użytkownika
             */
            int selectedOption = JOptionPane.showOptionDialog(lbl, panel,//
                    "Brawo, czy chcesz kontynouwać?", JOptionPane.NO_OPTION,//
                    JOptionPane.QUESTION_MESSAGE, //
                    null, options, options[0]);
            //użytkownik wybrał opcje "Tak CHCE ĆWICZYĆ
            if (selectedOption == 0) {
                OknoGry.this.dispose();// ukrycie okna

                przejdz_do_poziomu(); //wywołanie metody, która przechodzi do nastepnego poziomu

            } else {
                System.exit(0);//wyjscie z aplikacji
            }
            //ostatni poziom
        } else if (punkty == pktKonca) {
            stan.zakonczenie = true;
            OknoGry.this.dispose();// ukrycie okna
            new PrzejsciePoziomu().setVisible(true); //otowrzenie okna, po ukończeniu ostatniego poziomu
            bonus_czas();//wywołanie funkcji zliczającej sume punktów
            timer.stop(); //zatrzymanie czasu
            punkty = 0; //zerowanie punktów
            //koniec czasu
        } else if (czas == czasKonca) {
            OknoGry.this.dispose();// ukrycie okna
            timer.stop(); //zatrzymanie czasu
            punkty = 0; //zerowanie punktów

            stan.zapiszStan("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\danegracza.txt");// zapisanie stanu
            s = s.czytajStan("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\danegracza.txt");//odczytanie stanu
            new Komunikat(s).setVisible(true);//otowrzenie okna; użytkownik ma możliwość ponownej póby

        }

    }

    /**
     * metoda, dzieki której mozliwe jest przechodzenie poziomów
     *
     * @throws InterruptedException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void przejdz_do_poziomu() throws InterruptedException, IOException, ClassNotFoundException {

        switch (stan.poziom) {
            case 1:
                stan.poziom = 2;

                if (b == false) {
                    new OknoGry(stan);
                } else {
                    new OknoGry(true, stan);
                }
                break;

            case 2:
                stan.poziom = 3;
                if (b == false) {
                    new OknoGry(stan);
                } else {
                    new OknoGry(true, stan);
                }
                break;
            case 3:
                stan.poziom = 4;
                if (b == false) {
                    new OknoGry(stan);
                } else {
                    new OknoGry(true, stan);
                }

                break;
            case 4:
                stan.poziom = 5;
                if (b == false) {
                    new OknoGry(stan);
                } else {
                    new OknoGry(true, stan);
                }
                break;
            case 5:
                stan.poziom = 6;
                if (b == false) {
                    new OknoGry(stan);
                } else {
                    new OknoGry(true, stan);
                }
                break;
            case 6:
                stan.poziom = 7;
                if (b == false) {
                    new OknoGry(stan);
                } else {
                    new OknoGry(true, stan);
                }
                break;
            case 7:
                stan.poziom = 8;
                if (b == false) {
                    new OknoGry(stan);
                } else {
                    new OknoGry(true, stan);
                }
                break;
            case 8:
                stan.poziom = 9;
                if (b == false) {
                    new OknoGry(stan);
                } else {
                    new OknoGry(true, stan);
                }
                break;
            case 9:
                stan.poziom = 10;
                if (b == false) {
                    new OknoGry(stan);
                } else {
                    new OknoGry(true, stan);
                }
                if (punkty == pktKonca) {
                    stan.zakonczenie = true;

                }
                break;

            default:

                new PrzejsciePoziomu().setVisible(true);// wyswietlenie okna, ktore świadczy o ukończeniu gry

                dzwiekWow(); //wywołanie metody odtwarzającej dźwięk

        }

        bonus_czas();//wywłoanie metody obliczającej sumę punktów
    }

    /**
     * metoda zwracająca sume punktów zdobytych przez użytkownika, suma ta jest
     * uzalezniona od czasu jaki pozostał użytkownikowi do końca czasu danego
     * podpoziomu
     *
     * @return
     */
    public int bonus_czas() {
        s.czytajStan("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\danegracza.txt");//odczytanie stanu użytkownika
        bonusT = stan.bonus;//przypisanie do zmiennej bonusT wartości odpowiadającej zmiennej bonus odczytanej z pliku
        bonusT += (czasKonca - czas) * 2; // Dopisanie kolejnych punktów
        stan.bonus = bonusT; //przypisanie obliczonej zmiennej bonusT do zmiennej bonus w obiekcie stan

        stan.zapiszStan("C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\danegracza.txt");//zapisanie stanu do pliku
        return bonusT;
    }

}
