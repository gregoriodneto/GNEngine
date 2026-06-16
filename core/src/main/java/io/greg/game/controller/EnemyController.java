package io.greg.game.controller;

import com.badlogic.gdx.math.Vector2;
import io.greg.engine.controller.Controller;
import io.greg.game.entity.Enemy;
import io.greg.game.entity.Player;

import java.util.Vector;

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
            Vector2 direction = new Vector2(
                player.getTransform().getX()
                    - enemy.getTransform().getX(),
                player.getTransform().getY()
                    - enemy.getTransform().getY()
            );

            if (!direction.isZero()) {
                direction.nor();
            }

            enemy.move(direction, delta);
        } else {
            if (enemy.getTransform().getX() >= 800) {
                directionX = -1f;
            }
            if (enemy.getTransform().getX() <= 200) {
                directionX = 1f;
            }
            Vector2 direction = new Vector2(directionX, directionY);
            enemy.move(direction, delta);

        }
    }
}
