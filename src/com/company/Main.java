/*--------------------------------------------------
HangMan

A hangman game

28-08-2017

 ---------------------------------------------------*/




package com.company;

import java.util.Scanner;

public class Main {

    public static void clearConsole() {
        // Print new lines to clean the console
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static void printTheMan(int hangState) {
        // Print the hangman in different states

        System.out.println("       +----+\n       |    |");

        switch (hangState) {
            case 0:
                System.out.println("            |\n            |\n            |");
                break;
            case 1:
                System.out.println("       0    |\n            |\n            |");
                break;
            case 2:
                System.out.println("       0    |\n       |    |\n            |");
                break;
            case 3:
                System.out.println("       0    |\n      /|    |\n            |");
                break;
            case 4:
                System.out.println("       0    |\n      /|\\   |\n            |");
                break;
            case 5:
                System.out.println("       0    |\n      /|\\   |\n      /     |");
                break;
            case 6:
                System.out.println("       0    |\n      /|\\   |\n      / \\   |");
                break;
        }

        System.out.println("            |\n    =========");
    }

    public static void main(String[] args) {

        // Declare some variables
        char[] theWordToGuess = new char[]{'t','e','s','t'};
        int sizeOfWord = theWordToGuess.length;
        char[] correctChars = new char[sizeOfWord];
        char[] missedChars = new char[6];
        char guessedChar;
        boolean letterExists = false;
        int correctGuesses = 0;
        int wrongGuesses = 0;
        int totalGuesses = 0;
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < sizeOfWord; i++) {
            correctChars[i] = '_';
        }

        // Print the game start screen
        clearConsole();
        System.out.println("       0     \n      /|\\    \n      / \\");
        System.out.println("This man is in trouble.");
        System.out.println("It's your job to save him.");
        System.out.println("Guess the right word to stop the man from getting hanged.\n");
        System.out.print("Press \"ENTER\" to play..");

        // Wait for enter to continue
        sc.nextLine();

        // Guess loop
        while ((wrongGuesses < 6) && (correctGuesses != sizeOfWord)) {

            clearConsole();
            printTheMan(wrongGuesses);

            // Print correct letters
            System.out.print("Correct: ");
            for (int i = 0; i < sizeOfWord; i++) {
                System.out.print(correctChars[i] + " ");
            }

            // Print missed letters
            System.out.print("\nMissed:  ");
            for (int i = 0; i < wrongGuesses; i++) {
                System.out.print(missedChars[i] + " ");
            }

            // Ask for a letter
            System.out.println("\nGuess a letter: ");
            guessedChar = sc.next().charAt(0);
            totalGuesses++;

            letterExists = false;
            for (int i = 0; i < sizeOfWord; i++) {
                if (guessedChar == theWordToGuess[i]) {
                    letterExists = true;
                    correctChars[i] = guessedChar;
                    correctGuesses++;
                }
            }
            if (!letterExists) {
                missedChars[wrongGuesses] = guessedChar;
                wrongGuesses++;
            }
        }

        clearConsole();

        if (wrongGuesses == 6) {
            printTheMan(wrongGuesses);
            System.out.println("GAME OVER!\nThe man got hanged :(\n");
        } else {
            System.out.println("       0     \n      /|\\    \n      / \\");
            System.out.println("YOU WON!\nYou saved the man :)\n");
        }

        System.out.print("The word was: ");
        for (int i = 0; i < sizeOfWord; i++) {
            System.out.print(theWordToGuess[i]);
        }

        System.out.println("\nTotal guesses:   " + totalGuesses);
        System.out.println("Correct guesses: " + correctGuesses);
        System.out.println("Wrong guesses:   " + wrongGuesses);

    }
}
