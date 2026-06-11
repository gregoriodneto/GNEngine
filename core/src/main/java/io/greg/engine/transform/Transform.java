package io.greg.engine.transform;

public class Transform {
    private float x;
    private float y;

    private final float width;
    private final float height;

    public Transform(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public void translate(float dx, float dy) {
        this.x += dx;
        this.y += dy;
    }
}
