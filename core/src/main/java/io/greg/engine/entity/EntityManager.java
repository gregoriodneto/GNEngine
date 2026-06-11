package io.greg.engine.entity;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;
import java.util.List;

public class EntityManager {
    private final List<Entity> entities;

    public EntityManager() {
        this.entities = new ArrayList<>();
    }

    public void add(Entity entity) {
        this.entities.add(entity);
    }

    public void remove(Entity entity) {
        this.entities.remove(entity);
    }

    public void update(float delta) {
        for (Entity entity : entities) {
            entity.update(delta);
        }
    }

    public void render(ShapeRenderer shape) {
        for (Entity entity : entities) {
            entity.render(shape);
        }
    }
}
