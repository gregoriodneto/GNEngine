package io.greg.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import io.greg.engine.camera.CameraController;
import io.greg.engine.collision.CollisionManager;
import io.greg.engine.entity.EntityManager;
import io.greg.engine.entity.Health;
import io.greg.engine.transform.Transform;
import io.greg.engine.screen.BaseScreen;
import io.greg.engine.config.GameConfig;
import io.greg.engine.controller.ControllerManager;
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

    private CollisionManager collisionManager;

    private ControllerManager controllerManager;

    private CameraController cameraController;

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
            150f,
            new Health(10)
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

        controllerManager = new ControllerManager();

        playerController = new PlayerController(player);
        enemyController = new EnemyController(enemy);

        controllerManager.add(playerController);
        controllerManager.add(enemyController);

        collisionManager = new CollisionManager();

        camera = new OrthographicCamera();
        camera.setToOrtho(
            false,
            GameConfig.WIDTH,
            GameConfig.HEIGHT
        );

        cameraController = new CameraController(camera);
        cameraController.follow(player);

        Gdx.app.log("CAMERA", camera.viewportWidth + " x " + camera.viewportHeight);
    }

    @Override
    public void render(float delta) {
        cameraController.update();

        shape.setProjectionMatrix(camera.combined);

        ScreenUtils.clear(
            0.1f,
            0.2f,
            0.4f,
            1f
        );

        controllerManager.update(delta);

        entityManager.update(delta);

        collisionManager.checkAll(entityManager);

        entityManager.render(shape);
    }

    @Override
    public void dispose() {
        shape.dispose();
    }
}
