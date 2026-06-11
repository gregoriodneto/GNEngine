package io.greg.engine.entity;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import io.greg.engine.collision.Collision;

public abstract class Entity {

    public abstract void update(float delta);

    public abstract  void render(ShapeRenderer shape);

    public abstract void move(float x, float y, float delta);

    public abstract Collision getCollision();

}
