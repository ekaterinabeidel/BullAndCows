package org.example;

import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String originWord = "physics";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вам предлагается угадать слово длиною " + originWord.length());
        while (true) {
            System.out.println("Введите слово");
            String usersWord = scanner.nextLine().toLowerCase(Locale.ROOT);
            if (usersWord.length() != originWord.length()) {
                System.out.println("Длина введенного вами слова " +
                        "не соответствует заданной длине " + originWord.length() +
                        ". Повторите попытку.");
                continue;
            }

            if (!usersWord.matches("[a-zA-Z]+")) {
                System.out.println("Вы ввели недопустимый символ. Повторите попытку.");
                continue;
            }

            if (originWord.equals(usersWord)) {
                System.out.println("Отлично! Вы угадали слово!");
                break;
            }

            System.out.println("Быки: " + countBulls(originWord, usersWord) +
                    " Коровы: " + countCows(originWord, usersWord));
        }
    }

    public static int countBulls(String originWord, String usersWord) {
        int bulls = 0;
        for (int i = 0; i < originWord.length(); i++) {
            if (originWord.charAt(i) == usersWord.charAt(i)) bulls++;
        }
        return bulls;
    }

    public static int countCows(String originWord, String usersWord) {
        int cows = 0;
        for (char letter : usersWord.toCharArray()) {
            if (originWord.contains(Character.toString(letter))) cows++;
        }
        return cows;
    }
}