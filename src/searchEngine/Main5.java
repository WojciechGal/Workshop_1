package searchEngine;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {

        Connection connect = Jsoup.connect("http://www.onet.pl");

        try {
            Document document = connect.get();

            Elements links = document.select("span.title");

            FileWriter fileWriter = new FileWriter("popular_words.txt", true);

            for (Element elem : links) {
                String text = elem.text();
                String[] parts = text.split(" ");

                for (String part : parts) {
                    if (part.length() > 3) {
                        fileWriter.append(part + "\n");
                    }
                }

            }

            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        String[] wordsToAbandon = {"i", "albo", "oraz", "ponieważ", "lub", "zarazem", "bo", "nawet", "mimo", "z", "w", "na", "po", "przed", "także", "pod", "bez", "kiedy", "gdy"};


        try {
            FileWriter fileWriter2 = new FileWriter("filtered_popular_words.txt", true);

            File file = new File("popular_words.txt");

            try {
                Scanner scan = new Scanner(file);

                while (scan.hasNextLine()) {
                    String line = scan.nextLine();

                    int check = 0;

                    for (String element : wordsToAbandon) {
                        if (line.equals(element)) {
                            check++;
                        }
                    }

                    if (check == 0) {
                        fileWriter2.append(line + "\n");
                    }

                }
                scan.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
