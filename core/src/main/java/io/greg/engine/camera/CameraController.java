package io.greg.engine.camera;

import com.badlogic.gdx.graphics.OrthographicCamera;
import io.greg.engine.entity.Entity;

public class CameraController {
    private final OrthographicCamera camera;
    private Entity target;

    public CameraController(OrthographicCamera camera) {
        this.camera = camera;
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
