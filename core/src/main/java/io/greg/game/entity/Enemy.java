package io.greg.game.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import io.greg.engine.collision.Collision;
import io.greg.engine.entity.Entity;
import io.greg.engine.transform.Transform;

public class Enemy extends Entity {
    private final Transform transform;
    private final Collision collision;
    private final float speed;

    public Enemy(Transform transform, float speed) {
        this.transform = transform;
        this.collision = new Collision();
        this.speed = speed;
    }

    @Override
    public void move(float x, float y, float delta) {
        float dx = x * speed * delta;
        float dy = y * speed * delta;
        transform.translate(dx, dy);
    }

    @Override
    public void update(float delta) {
        collision.update(transform.getX(), transform.getY(), transform.getWidth(), transform.getHeight());
    }

    @Override
    public void render(ShapeRenderer shape) {
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.RED);
        shape.rect(transform.getX(), transform.getY(), transform.getWidth(), transform.getHeight());
        shape.end();
    }

    public Transform getTransform() {
        return transform;
    }

    @Override
    public Collision getCollision() {
        return collision;
    }
}
