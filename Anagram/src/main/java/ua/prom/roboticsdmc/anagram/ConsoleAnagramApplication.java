package ua.prom.roboticsdmc.anagram;

import java.util.Scanner;

public class ConsoleAnagramApplication {

    public static void main(String[] args) {

        AnagramCreater anagramCreater = new AnagramCreater();

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Enter sentance: ");
            String source = scanner.nextLine();
            anagramCreater.createAllSentenceAnagram(source);
            System.out.println(anagramCreater.createAllSentenceAnagram(source));
        }
    }
}
