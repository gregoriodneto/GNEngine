package io.greg.game.controller;

import io.greg.engine.controller.Controller;
import io.greg.game.entity.Enemy;

public class EnemyController implements Controller {
    private final Enemy enemy;

    private float directionX;
    private final float directionY;

    public EnemyController(Enemy enemy) {
        this.enemy = enemy;

        this.directionX = 1f;
        this.directionY = 0f;
    }

    public void update(float delta) {
        if (enemy.getTransform().getX() >= 800) {
            directionX = -1f;
        }
        if (enemy.getTransform().getX() <= 200) {
            directionX = 1f;
        }
        enemy.move(directionX, directionY, delta);
    }
}
