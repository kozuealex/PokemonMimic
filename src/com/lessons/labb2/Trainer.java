package com.lessons.labb2;

import java.util.Scanner;

// Mainklassen som man ska mata in info.
public class Trainer {
    private static Scanner scanner = new Scanner(System.in);
    private static PokemonList pokemonList = new PokemonList("Charamander");

    private static Fire charamander = new Fire("Charamander", 30, 80, "Fire Blast");
    private static Electric pikachu = new Electric("Pikachu", 25, 73, "Thunderbolt");
    private static Fire magby = new Fire("Magby", 18, 46, "Ember");
    private static Electric jolteon = new Electric("Jolteon", 35, 92, "Discharge");

    public static void main(String[] args) {
        boolean quit = false;
        startGame();
        printActions();
        pokemonList.addNew(charamander);

        while (!quit) {
            System.out.println("Enter the number (7 to show menu).");
            int number = scanner.nextInt();
            scanner.nextLine();

            switch (number) {
                case 0:
                    System.out.println("Zzz-zzz-zzz...");
                    System.out.println("OK, see you next time!");
                    System.out.println("========== * ==========");
                    quit = true;
                    break;

                case 1:
                    pokemonList.print();
                    break;

                case 2:
                    catchPokemon();
                    break;

                case 3:
                    tradePokemon();
                    break;

                case 4:
                    releasePokemon();
                    break;

                case 5:
                    pokemonBattle();
                    break;

                case 6:
                    goToCenter();
                    break;

                case 7:
                    printActions();
                    break;
            }
        }
    }

    private static void catchPokemon() {
        Pokemon existing = pokemonList.search(pikachu.getName());
        Pokemon existing2 = pokemonList.search(magby.getName());
        if (existing == null) {
            Pokemon newPokemon = pikachu;
            System.out.println("A wild " + pikachu.getName() + " appeared! Use a Poke Ball!");
            pokemonList.addNew(pikachu);
            System.out.println("You caught " + pikachu.getName() + "!\n" + pikachu.getName() + " is added to your party.");
        } else if (existing2 == null) {
            Pokemon newPokemon = magby;
            System.out.println("A wild " + magby.getName() + " appeared! Use a Poke Ball!");
            pokemonList.addNew(magby);
            System.out.println("You caught " + magby.getName() + "!\n" + magby.getName() + " is added to your party.");
        } else {
            System.out.println("No more catch for today...");
        }
    }

    private static void tradePokemon() {
        System.out.println("Your friend is willing to trade Jolteon.\nWhich Pokemon do you send in exchange?");
        pokemonList.print();
        System.out.println("Enter a name:");
        String name = scanner.nextLine();
        Pokemon existing = pokemonList.search(name);
        pokemonList.update(existing, jolteon);
    }

    private static void releasePokemon() {
        System.out.println("Which Pokemon do you want to release?\nEnter a name:");
        pokemonList.print();
        String name = scanner.nextLine();
        Pokemon existing = pokemonList.search(name);
        if (existing == null) {
            System.out.println("You don´t have " + name + ".");
            return;
        }
        pokemonList.delete(existing);
    }

    private static void goToCenter() {
        System.out.println("Welcome to the Pokemon Center.");
        System.out.println("Would you like to rest your Pokemon? (1. Yes / 2. No)");
        int input = scanner.nextInt();
        boolean answer;
        if (input == 1) {
            answer = true;
        } else {
            answer = false;
        }
        pokemonList.pokemonCenter(answer);
    }

    private static void pokemonBattle() {
        System.out.println("A wild Caterpie appeared!");
        System.out.println("1. Fight / 2. Run");
        int input = scanner.nextInt();
        scanner.nextLine();

        if (input == 1) {
            System.out.println("Choose a Pokemon:");
            pokemonList.print();
            System.out.println("Enter a name:");
            String name = scanner.nextLine();
            Pokemon existing = pokemonList.search(name);
            if (existing == null) {
                System.out.println("You don´t have " + name + ".");
                return;
            }

            pokemonList.search(name).fight(pokemonList.search(name));

        } else {
            System.out.println("You got away safely.");
        }
    }

    private static void startGame() {
        System.out.println("Zzz-zzz-zzz...");
        System.out.println("Welcome to the world of Pokemon, friend!");
        System.out.println("I´m Rotom in the Pokedex here.\nWhat´s your name?");
        String name = scanner.nextLine();
        System.out.println("OK, " + name + "! You´ve got Charamander with you! \nLet´s go for the adventure!");
    }

    private static void printActions() {
        System.out.println("Zzz-zzz-zzz..." + "\nWhat shall we do?");
        System.out.println("\t0 - Quit\n" +
                "\t1 - My Pokemon\n" +
                "\t2 - Go catch Pokemon\n" +
                "\t3 - Trade with Friend\n" +
                "\t4 - Release Pokemon\n" +
                "\t5 - Pokemon Battle\n" +
                "\t6 - Pokemon Center\n" +
                "\t7 - Show Menu");
    }
}
