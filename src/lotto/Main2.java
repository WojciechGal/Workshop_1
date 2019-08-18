package lotto;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        System.out.println("Lotto. Wprowadź 6 niepowtarzających się liczb od 1 do 49 oddzielając je pojedyńczą spacją.");

        lotto();

    }

    static void lotto() {

        Scanner scan = new Scanner(System.in);

        String nums = scan.nextLine();

        String[] numbers = nums.split(" ");

        int x = 0;

        while (x < 6) {

            int y = 0;

            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i].equals(numbers[x])) {
                    y++;
                }
            }

            if (numbers.length != 6 || (isNotNumberFrom1to49(numbers[x])) || (y > 1) || needTrim(nums)) {
                x = 0;
                System.out.println("Źle wprowadzone dane. Wprowadź jeszcze raz.");
                nums = scan.nextLine();
                numbers = nums.split(" ");
            } else {
                x++;
            }
        }

        int[] parsedNumbers = new int[6];

        for (int i = 0; i < parsedNumbers.length; i++) {
            parsedNumbers[i] = Integer.parseInt(numbers[i]);
        }

        int[] numbersComputer = new int[6];

        int z = 0;
        while (z < 6) {
            numbersComputer[z] = new Random().nextInt(49) + 1;

            int q = 0;

            for (int i = 0; i < numbersComputer.length; i++) {
                if (numbersComputer[z] == numbersComputer[i]) {
                    q++;
                }
            }
            if (q < 2) {
                z++;
            }
        }

        int result = 0;

        for (int i = 0; i < parsedNumbers.length; i++) {
            for (int j = 0; j < numbersComputer.length; j++) {
                if (numbersComputer[j] == parsedNumbers[i]) {
                    result++;
                }
            }
        }

        Arrays.sort(parsedNumbers);
        Arrays.sort(numbersComputer);

        System.out.println("Wybrane przez ciebie liczby: " + Arrays.toString(parsedNumbers));
        System.out.println("Wybrane przez komputer liczby: " + Arrays.toString(numbersComputer));

        switch (result) {
            case 6:
                System.out.println("Trafiłeś szóstkę! Jesteś milionerem!!!");
                break;
            case 5:
                System.out.println("Trafiłeś piątkę! Wygrałeś bardzo dużo pieniędzy...");
                break;
            case 4:
                System.out.println("Trafiłeś czwórkę. Gratulacje.");
                break;
            case 3:
                System.out.println("Trafiłeś trójkę. To dobry wynik.");
                break;
            default:
                System.out.println("Nie trafiłeś nawet trójki...");
                break;
        }

        System.out.println("Czy chcesz zagrać jeszcze raz? Odpowiedz T/N.");

        String answer = scan.nextLine();

        while (!answer.equals("T") && !answer.equals("N")) {
            System.out.println("Niepoprawny format odpowiedzi. Wpisz jeszcze raz.");
            answer = scan.nextLine();
        }

        if (answer.equals("T")) {
            System.out.println("Witamy ponownie w Lotto. Wprowadź 6 niepowtarzających się liczb od 1 do 49 oddzielając je pojedyńczą spacją.");
            lotto();
        } else {
            System.out.println("Do zobaczenia.");
            scan.close();
        }

    }

    static boolean isNotNumberFrom1to49(String str) {
        try {
            int x = Integer.parseInt(str);
            if (x > 0 && x < 50) {
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            return true;
        }
    }

    static boolean needTrim(String str) {
        String afterTrim = str.trim();
        if (str.equals(afterTrim)) {
            return false;
        } else {
            return true;
        }
    }
}
