package io.greg.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import io.greg.engine.entity.EntityManager;
import io.greg.engine.transform.Transform;
import io.greg.engine.screen.BaseScreen;
import io.greg.engine.config.GameConfig;
import io.greg.game.controller.EnemyController;
import io.greg.game.controller.PlayerController;
import io.greg.game.entity.Enemy;
import io.greg.game.entity.Player;

public class MainMenuScreen extends BaseScreen {
    private ShapeRenderer shape;
    private OrthographicCamera camera;

    private EntityManager entityManager;

    private PlayerController playerController;
    private EnemyController enemyController;

    private Player player;
    private Enemy enemy;

    @Override
    public void show() {
        shape = new ShapeRenderer();

        Transform playerTransform = new Transform(
            100f,
            100f,
            100f,
            100f
        );
        player = new Player(
            playerTransform,
            150f
        );

        Transform enemyTransform = new Transform(
            300f,
            300f,
            100f,
            100f
        );
        enemy = new Enemy(
            enemyTransform,
            100f
        );

        entityManager = new EntityManager();
        entityManager.add(player);
        entityManager.add(enemy);

        playerController = new PlayerController(player);
        enemyController = new EnemyController(enemy);

        camera = new OrthographicCamera();
        camera.setToOrtho(
            false,
            GameConfig.WIDTH,
            GameConfig.HEIGHT
        );

        camera.position.set(
            player.getTransform().getX(),
            player.getTransform().getY(),
            0
        );

        camera.update();

        Gdx.app.log("CAMERA", camera.viewportWidth + " x " + camera.viewportHeight);
    }

    @Override
    public void render(float delta) {
        camera.position.set(
            player.getTransform().getX() + player.getTransform().getWidth() / 2f,
            player.getTransform().getY() + player.getTransform().getWidth() / 2f,
            0
        );

        camera.update();

        shape.setProjectionMatrix(camera.combined);

        ScreenUtils.clear(
            0.1f,
            0.2f,
            0.4f,
            1f
        );

        playerController.update(delta);
        enemyController.update(delta);

        entityManager.update(delta);
        entityManager.render(shape);
    }

    @Override
    public void dispose() {
        shape.dispose();
    }
}
