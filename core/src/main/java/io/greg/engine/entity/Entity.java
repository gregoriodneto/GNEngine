package io.greg.engine.entity;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import io.greg.engine.collision.Collision;
import io.greg.engine.transform.Transform;

public abstract class Entity {
    protected Transform transform;
    protected Collision collision;

    public Transform getTransform() {
        return transform;
    }

    public Collision getCollision() {
        return collision;
    }

    public abstract void update(float delta);

    public abstract  void render(ShapeRenderer shape);

    public abstract void move(float x, float y, float delta);

    public abstract void onCollision(Entity other);

    public abstract void decrementLife(int damage);

}
