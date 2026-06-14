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

    public void translate(
        float dx,
        float dy,
        float minX,
        float minY,
        float maxX,
        float maxY
    ) {
        x += dx;
        y += dy;

        x = Math.max(minX, Math.min(x, maxX));
        y = Math.max(minY, Math.min(y, maxY));
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
