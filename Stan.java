
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

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
 * Klasa implementująca interfejs Serializable
 */
public class Stan implements Serializable {

    /**
     * deklaracja obiektu klasy String przyjmującej pseudonim uzytkownika
     */
    public String name;
    /**
     * deklaracja zmiennej typu int przyjmującej poziom uzytkownika
     */
    public int poziom;
    /**
     * deklaracja zmiennej typu int przyjmującej sumę punktów użytkownika
     */
    public int bonus;
    /**
     * deklaracja zmiennej typu boolean, której wartośc true oznacza ukończenie gry
     */
    public boolean zakonczenie;
    /**
     * deklaracja zmiennej typu boolean, której wartość true oznacza tryb gry w języku
     * angielskim natomiast false- tryb gry w języku polskim
     */
    public boolean tryb;
    /**
     *deklaracja obiektu klasy String, do którego przypisana jest ścieżka pliku, w którym
     * zapisywany i z którego odczytywany jest stan gry użytkownika
     */
    public String sciezka = "C:\\Users\\Katherine\\Documents\\NetBeansProjects\\JavaProject1\\danegracza.txt";

    /**
     * Konstruktor klasy Stan z pierwotnymi wartościami zmiennych
     */
    public Stan() {
        name = "test";
        poziom = 0;
        bonus = 0;
        zakonczenie = false;
        tryb = false;

    }

    /**
     * serializacja 
     * metoda przyjmująca jako parametr sciezkę -obiekt klasy String  i
     * wykorzystująca strumień wyjściowy, by móc zapisać dane binarne 
     * 
     *
     * @param sciezka
     */
    public void zapiszStan(String sciezka) {
        try {
            /**
             * tworzymy strumień do zapisu i w konstruktorze przekazujemy adres
             * do pliku
             */
            FileOutputStream fos = new FileOutputStream(sciezka);
            /**
             * tworzymy strumień do zapisu obietku i w konstruktorze
             * przekazujemy strumień do odczytu pliku
             */
            ObjectOutputStream os = new ObjectOutputStream(fos);
            /**
             * zapisanie obiektu
             */
            os.writeObject(this);
            /**
             * zamknięcie strumienia
             */
            os.close();
            /**
             * zamknięcie strumienia
             */
            fos.close();
        } catch (Exception e) {

        }

    }

    /**
     * deserializacja metoda przyjmująca jako parametr zmienną String sciezka i
     * wykorzystująca strumień wejściowy, by móc wczytywać dane binarne oraz
     * zwrocić interesujący nas stan
     *
     * @param sciezka
     * @return
     */
    public static Stan czytajStan(String sciezka) {
        /**
         * domyślna zawartość obiektu
         */
        Stan s = null;
        try {
            /**
             * tworzymy strumień do odczytu i w konstruktorze przekazujemy adres
             * do pliku
             */
            FileInputStream fos = new FileInputStream(sciezka);
            /**
             * tworzymy strumień do odczytu obietku i w konstruktorze
             * przekazujemy strumień do odczytu pliku
             */
            ObjectInputStream os = new ObjectInputStream(fos);
            /**
             * odczyt obiektu ze strumienia
             */
            s = (Stan) os.readObject();
            /**
             *  zamknięcie strumienia
             */
            os.close();
            /**
             * zamknięcie strumienia
             */
            fos.close();
        } catch (Exception e) {

        }

        return s;
    }

}
