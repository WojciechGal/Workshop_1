package dice;


import java.util.Random;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {

        System.out.println("Ile rzutów?");

        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();

        while (isNotPositiveNumber(line)) {
            System.out.println("Jeszcze raz.");
            line = scan.nextLine();
        }

        int rzut = Integer.parseInt(line);

        System.out.println("Ile ścian kostki?");

        String line2 = scan.nextLine();

        while (isNotPositiveNumber(line2)) {
            System.out.println("Jeszcze raz.");
            line2 = scan.nextLine();
        }

        int sciany = Integer.parseInt(line2);

        System.out.println("Wartość dodana do wyniku? Jeśli odjąć napisz z minusem.");

        String line3 = scan.nextLine();

        while (isNotNumber(line3)) {
            System.out.println("Jeszcze raz.");
            line3 = scan.nextLine();
        }

        int wartosc = Integer.parseInt(line3);

        int[] tab = new int[rzut];

        for (int i = 0; i < tab.length; i++) {
            tab[i] = new Random().nextInt(sciany) + 1;
        }

        int wynik = 0;

        for (int i = 0; i < tab.length; i++) {
            wynik += tab[i];
        }

        wynik += wartosc;

        System.out.println("Twój wynik to: " + wynik);

    }

    static boolean isNotNumber(String str) {
        try {
            Integer.parseInt(str);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    static boolean isNotPositiveNumber(String str) {
        try {
            int x = Integer.parseInt(str);
            if (x > 0) {
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            return true;
        }
    }

}
