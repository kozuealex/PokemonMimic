package com.lessons.labb2;

// Subklassen
public class Electric extends Pokemon {
    private String electricMove;

    public Electric(String name, int lv, int hp, String electricMove) {
        super(name, "Electric", lv, hp);
        this.electricMove = electricMove;
    }

    public String getElectricMove() {
        return electricMove;
    }

    @Override
    public void fight(Pokemon pokemon) {
        super.fight(pokemon);
        System.out.println(pokemon.getName() + " used " + electricMove + "!");
        System.out.println("It´s effective! I knew you can do it!");
        setLv(this.getLv() + 1);
        System.out.println(pokemon.getName() + " is now level " + pokemon.getLv() + "!");
    }
}