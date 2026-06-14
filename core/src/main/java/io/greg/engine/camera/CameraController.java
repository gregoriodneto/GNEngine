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

        camera.position.set(
            target.getTransform().getX()
                + target.getTransform().getWidth() / 2f,
            target.getTransform().getY()
                + target.getTransform().getHeight() / 2f,
            0
        );

        camera.update();
    }
}
