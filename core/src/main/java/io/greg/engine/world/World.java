package io.greg.engine.world;

public class World {
    private final float width;
    private final float height;

    public World(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
