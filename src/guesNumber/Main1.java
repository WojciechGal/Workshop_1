package guesNumber;

import java.util.Random;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        System.out.println("Zgadnij liczbę od 1 do 100.");

        int x = new Random().nextInt(100) + 1;

        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();

        while (isNotNumber(line)) {
            System.out.println("Wprowadź pojedyńczo liczbę całkowitą.");
            line = scan.nextLine();
        }

        int num = Integer.parseInt(line);

        while (num > x || num < x ) {
            if (num > x && num <= 100) {
                System.out.println("Za dużo.");

                line = scan.nextLine();
                while (isNotNumber(line)) {
                    System.out.println("Wprowadź pojedyńczo liczbę całkowitą.");
                    line = scan.nextLine();
                }
                num = Integer.parseInt(line);

            } else if (num < x && num >= 1) {
                System.out.println("Za mało.");

                line = scan.nextLine();
                while (isNotNumber(line)) {
                    System.out.println("Wprowadź pojedyńczo liczbę całkowitą.");
                    line = scan.nextLine();
                }
                num = Integer.parseInt(line);
            } else if (num < 1) {
                System.out.println("Co najmniej 1!");

                line = scan.nextLine();
                while (isNotNumber(line)) {
                    System.out.println("Wprowadź pojedyńczo liczbę całkowitą.");
                    line = scan.nextLine();
                }
                num = Integer.parseInt(line);
            } else if (num > 100) {
                System.out.println("Maksymalnie 100!");

                line = scan.nextLine();
                while (isNotNumber(line)) {
                    System.out.println("Wprowadź pojedyńczo liczbę całkowitą.");
                    line = scan.nextLine();
                }
                num = Integer.parseInt(line);
            }
        }

        System.out.println("Zgadłeś.");
        scan.close();
    }

    static boolean isNotNumber(String str) {
        try {
           Integer.parseInt(str);
           return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}
