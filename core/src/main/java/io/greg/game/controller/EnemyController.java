package io.greg.game.controller;

import io.greg.engine.controller.Controller;
import io.greg.game.entity.Enemy;
import io.greg.game.entity.Player;

public class EnemyController implements Controller {
    private final Enemy enemy;
    private final Player player;

    private float directionX;
    private float directionY;

    private boolean followPlayer;

    public EnemyController(Enemy enemy, Player player, boolean followPlayer) {
        this.enemy = enemy;
        this.player = player;
        this.followPlayer = followPlayer;

        this.directionX = 1f;
        this.directionY = 0f;
    }

    public void update(float delta) {
        if (followPlayer) {
            float dx =
                player.getTransform().getX()
                    - enemy.getTransform().getX();

            float dy =
                player.getTransform().getY()
                    - enemy.getTransform().getY();

            float length = (float) Math.sqrt(dx * dx + dy * dy);

            if (length > 0) {
                dx /= length;
                dy /= length;
            }

            enemy.move(dx, dy, delta);
        } else {
            if (enemy.getTransform().getX() >= 800) {
                directionX = -1f;
            }
            if (enemy.getTransform().getX() <= 200) {
                directionX = 1f;
            }
            enemy.move(directionX, directionY, delta);

        }
    }
}
