package com.lessons.labb2;

// Subklassen
public class Fire extends Pokemon {
    private String fireMove;

    public Fire(String name, int lv, int hp, String fireMove) {
        super(name, "Fire", lv, hp);
        this.fireMove = fireMove;
    }

    public String getFireMove() {
        return fireMove;
    }

    @Override
    public void fight(Pokemon pokemon) {
        super.fight(pokemon);
        System.out.println(pokemon.getName() + " used " + fireMove + "!");
        System.out.println("It´s effective! I knew you can do it!");
        setLv(this.getLv() + 1);
        System.out.println(pokemon.getName() + " is now level " + pokemon.getLv() + "!");
    }

}
