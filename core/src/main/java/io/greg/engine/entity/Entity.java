package io.greg.engine.entity;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import io.greg.engine.collision.Collision;
import io.greg.engine.transform.Transform;
import io.greg.engine.world.World;

public abstract class Entity {
    protected Transform transform;
    protected Collision collision;
    protected World world;

    public Transform getTransform() {
        return transform;
    }

    public Collision getCollision() {
        return collision;
    }

    public World getWorld() {
        return world;
    }

    public abstract void update(float delta);

    public abstract  void render(ShapeRenderer shape);

    public abstract void move(Vector2 direction, float delta);

    public abstract void onCollision(Entity other);

    protected void translate(float dx,float dy) {
        transform.translate(
            dx,
            dy,
            0,
            0,
            world.getWidth() - transform.getWidth(),
            world.getHeight() - transform.getHeight()
        );
    }

}
