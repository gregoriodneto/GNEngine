package io.greg.engine.collision;

import com.badlogic.gdx.math.Rectangle;

public class Collision {
    private Rectangle bounds;

    public Collision() {
        this.bounds = new Rectangle();
    }

    public void update(float x, float y, float width, float height) {
        bounds.set(x, y, width, height);
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
