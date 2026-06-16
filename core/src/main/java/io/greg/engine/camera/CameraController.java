package io.greg.engine.camera;

import com.badlogic.gdx.graphics.OrthographicCamera;
import io.greg.engine.entity.Entity;
import io.greg.engine.world.World;

public class CameraController {
    private final OrthographicCamera camera;
    private Entity target;
    private World world;

    public CameraController(OrthographicCamera camera, World world) {
        this.camera = camera;
        this.world = world;
    }

    public void follow(Entity target) {
        this.target = target;
    }

    public void update() {
        if (target == null) return;

        float x =
            target.getTransform().getX()
            + target.getTransform().getWidth() / 2f;

        float y =
            target.getTransform().getY()
                + target.getTransform().getHeight() / 2f;

        float halfWidth = camera.viewportWidth / 2f;
        float halfHight = camera.viewportHeight / 2f;

        x = Math.max(
            halfWidth,
            Math.min(
                x,
                world.getWidth() - halfWidth
            )
        );

        y = Math.max(
            halfHight,
            Math.min(
                y,
                world.getHeight() - halfHight
            )
        );

        camera.position.set(x, y, 0);

        camera.update();
    }
}
