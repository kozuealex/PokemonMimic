package com.lessons.labb2;

import java.util.ArrayList;

// Klassen för att göra en array list.
public class PokemonList {
    private String myPokemon;
    private ArrayList<Pokemon> myPokemonList;

    public PokemonList(String myPokemon) {
        this.myPokemon = myPokemon;
        this.myPokemonList = new ArrayList<Pokemon>();
    }

    public void print() {
        System.out.println("Current Pokemon with you.");
        for (int i = 0; i < myPokemonList.size(); i++) {
            System.out.println((i + 1) + ". " +
                    this.myPokemonList.get(i).getName() + "\nType: " +
                    this.myPokemonList.get(i).getType() + "\nLevel: " +
                    this.myPokemonList.get(i).getLv() + "\nHP: " +
                    this.myPokemonList.get(i).getHp());
            System.out.println("========== * ==========");
        }
    }

    public boolean addNew(Pokemon pokemon) {
        myPokemonList.add(pokemon);
        System.out.print("Gotcha! ");
        return true;
    }

    public boolean update(Pokemon mine, Pokemon yours) {
        int foundPosition = find(mine);
        if (foundPosition < 0) {
            System.out.println("You don´t have " + mine.getName() + ".");
            return false;
        }
        this.myPokemonList.set(foundPosition, yours);
        System.out.println("You are sending " + mine.getName() + " and receiving Jolteon...");
        System.out.println("Good bye " + mine.getName() + " and welcome to my party Jolteon!");
        return true;
    }

    public boolean delete(Pokemon pokemon) {
        int foundPosition = find(pokemon);
        this.myPokemonList.remove(foundPosition);
        System.out.println("You released " + pokemon.getName() + ".");
        System.out.println("Good bye " + pokemon.getName() + "!");
        return true;
    }

    private int find(Pokemon pokemon) {
        return this.myPokemonList.indexOf(pokemon);
    }

    private int find(String pokemonName) {
        for (int i = 0; i < myPokemonList.size(); i++) {
            Pokemon pokemon = this.myPokemonList.get(i);
            if (pokemon.getName().equals(pokemonName)) {
                return i;
            }
        }
        return -1;
    }

    public Pokemon search(String pokemonName) {
        int position = find(pokemonName);
        if (position >= 0) {
            return this.myPokemonList.get(position);
        }
        return null;
    }

    public void pokemonCenter(boolean answer) {
        if (!answer) {
            System.out.println("We hope to see you again!");
        } else {
            if (myPokemonList.size() <= 0) {
                System.out.println("You don´t have any Pokomon.");
                return;
            }
            System.out.println("I´ll take your Pokemon for a few seconds, then.");
            System.out.println("Thank you for waiting!\nWe´ve restored your Pokemon to full health.");
        }
    }

}
