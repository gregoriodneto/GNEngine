package io.greg.engine.entity;

public class Health {
    private int hp;

    public Health(int hp) {
        this.hp = hp;
    }

    public void damage(int amount) {
        hp -= amount;
    }

    public int getHp() {
        return hp;
    }
}
