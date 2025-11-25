package lab6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Translator translator = new Translator();

        translator.addWord("hello", "привіт");
        translator.addWord("my", "мій");
        translator.addWord("friend", "друг");
        translator.addWord("brother", "брат");
        translator.addWord("is", "це");

        while (true) {
            System.out.println("\n~~~~~ Menu ~~~~~");
            System.out.println("1. Add new pair of words");
            System.out.println("2. Translate");
            System.out.println("3. Exit");
            System.out.print("Choose the option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("\n~~ Adding words to dictionary ~~");
                    System.out.println("Enter word in English or 'stop' to finish");

                    while (true) {
                        System.out.print("EN: ");
                        String en = scanner.nextLine().trim();

                        if (en.equalsIgnoreCase("stop"))
                            break;

                        System.out.print("UA: ");
                        String ua = scanner.nextLine().trim();

                        translator.addWord(en, ua);
                        System.out.println("Successfully added");
                    }
                    break;
                case "2":
                    System.out.println("\n~~ Translator ~~");
                    System.out.println("Enter phrase in English: ");
                    String phrase = scanner.nextLine();
                    String translated = translator.translatePhrase(phrase);
                    System.out.println("Translation: " + translated);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Incorrect option. Try again.");
            }
        }
    }
}