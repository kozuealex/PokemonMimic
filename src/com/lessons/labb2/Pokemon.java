package com.lessons.labb2;

// Superklassen
public abstract class Pokemon {
    private String name;
    private String type;
    private int lv;
    private int hp;

    public Pokemon(String name, String type, int lv, int hp) {
        this.name = name;
        this.type = type;
        this.lv = lv;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getLv() {
        return lv;
    }

    public int getHp() {
        return hp;
    }

    public void setLv(int lv) {
        this.lv = lv;
    }

    public void fight(Pokemon pokemon) {
        System.out.println(pokemon.getName() + ", I choose you!");
    }

}
