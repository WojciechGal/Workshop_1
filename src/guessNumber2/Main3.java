package guessNumber2;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {

        System.out.println("Pomyśl liczbę od 1 do 1000, a ja zgadnę w max. 10 próbach. Odpowiadaj mi \"za dużo\", \"za mało\", lub \"zgadłeś\".");

        int min = 1;
        int max = 1001;
        int round = 0;
        int[] scores = new int[10];

        int guess = 500;

        scores[0] = guess;

        int duplicates = 0;

        System.out.println("Zgaduję " + guess + ".");

        Scanner scan = new Scanner(System.in);

        String answer = scan.nextLine();

        while ((!answer.equals("zgadłeś")) && (round < 10) && (duplicates < 2)) {
            duplicates = 0;


            if ((answer.equals("za dużo")) || (answer.equals("za mało"))) {
                if (answer.equals("za dużo")) {
                    max = guess;
                } else {
                    min = guess;
                }

                round++;
                guess = ((max - min) / 2) + min;

                if (round < 10) {
                    scores[round] = guess;
                    for (int i = 0; i < scores.length; i++) {
                        if (scores[round] == scores[i]) {
                            duplicates++;
                        }

                    }
                }

                if (duplicates > 1 || round >= 10) {
                } else {
                    System.out.println("Runda: " + (round + 1) + ". Zgaduję " + guess + ".");
                    answer = scan.nextLine();
                }

            } else {
                System.out.println("Pisz dokładnie!");

                answer = scan.nextLine();
            }

        }

        if (answer.equals("zgadłeś")) {
            System.out.println("Wygrałem!!!");
        } else {
            System.out.println("Oszustwo!!!");
        }

    }

}
