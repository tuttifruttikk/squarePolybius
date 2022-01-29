package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class squarePolybius {
    char[][] alphabet = new char[5][5];
    ArrayList<Character> encAlpha = new ArrayList<>();
    ArrayList<Character> decAlpha = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String words = scanner.nextLine();

        squarePolybius square = new squarePolybius();
        square.createAlpha();
        square.createSquare(words);
        square.encryption ();
        System.out.println(square);
    }

    public void createSquare(String words) {
        for (char c : words.toCharArray()) {
            encAlpha.add(c);
            decAlpha.add(c);
        }
    }

    public void createAlpha() {
        int i = 65;
        for (int row = 0; row < alphabet.length; ++row) {
            for (int column = 0; column < alphabet[0].length; ++column) {
                if (i == 74) {
                    i++;
                }
                alphabet[row][column] = (char) (i);
                i++;
            }
        }
    }

    public void encryption () {
        for (int i = 0; i < encAlpha.size(); ++i) {
            next:
            for (int row = 0; row < alphabet.length; ++row) {
                for (int column = 0; column < alphabet[0].length; ++column) {
                    if (encAlpha.get(i) == alphabet[row][column]) {
                        char word;
                        if (row + 1 == alphabet.length) {
                            word = alphabet[0][column];
                        } else {
                            word = alphabet[row + 1][column];
                        }
                        encAlpha.set(i, word);
                        break next;
                    }
                }
            }
        }
    }

    public void decryption() {
        for (int i = 0; i < decAlpha.size(); ++i) {
            next:
            for (int row = 0; row < alphabet.length; ++row) {
                for (int column = 0; column < alphabet[0].length; ++column) {
                    if (decAlpha.get(i) == alphabet[row][column]) {
                        char word;
                        if (row + 1 == alphabet.length) {
                            word = alphabet[row][column];
                        } else {
                            word = alphabet[row - 1][column];
                        }
                        decAlpha.set(i, word);
                        break next;
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "squarePolybius \n" +
                "alphabet=" + Arrays.deepToString(alphabet) +
                ",\nencAlpha=" + encAlpha +
                ",\ndecAlpha=" + decAlpha;
    }
}
