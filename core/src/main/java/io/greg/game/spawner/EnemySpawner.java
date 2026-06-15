package io.greg.game.spawner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import io.greg.engine.controller.ControllerManager;
import io.greg.engine.entity.EntityManager;
import io.greg.engine.transform.Transform;
import io.greg.engine.world.World;
import io.greg.game.controller.EnemyController;
import io.greg.game.entity.Enemy;

public class EnemySpawner {
    private final EntityManager entityManager;
    private final World world;
    private final ControllerManager controllerManager;

    private float timer = 0;

    public EnemySpawner(EntityManager entityManager, World world, ControllerManager controllerManager) {
        this.entityManager = entityManager;
        this.world = world;
        this.controllerManager = controllerManager;
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

            controllerManager.add(new EnemyController(enemy));

            Gdx.app.log("TIMER", String.valueOf(timer));
            timer = 0;
        }
    }
}
