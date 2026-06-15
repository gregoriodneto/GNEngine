package io.greg.game.spawner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import io.greg.engine.controller.ControllerManager;
import io.greg.engine.entity.EntityManager;
import io.greg.engine.transform.Transform;
import io.greg.engine.world.World;
import io.greg.game.controller.EnemyController;
import io.greg.game.entity.Enemy;
import io.greg.game.entity.Player;

public class EnemySpawner {
    private final EntityManager entityManager;
    private final World world;
    private final ControllerManager controllerManager;
    private final Player player;

    private float timer = 0;

    public EnemySpawner(
        EntityManager entityManager,
        World world,
        ControllerManager controllerManager,
        Player player
    ) {
        this.entityManager = entityManager;
        this.world = world;
        this.controllerManager = controllerManager;
        this.player = player;
    }

    public void update(float delta) {
        timer += delta;

        if (timer >= 2f) {
            Transform transform = new Transform(
                MathUtils.random(300f, 800f),
                MathUtils.random(300f, 800f),
                32f,
                32f
            );
            Enemy enemy = new Enemy(transform, world, 100f);

            entityManager.add(enemy);

            controllerManager.add(new EnemyController(enemy, player, true));

            Gdx.app.log("TIMER", String.valueOf(timer));
            timer = 0;
        }
    }
}
