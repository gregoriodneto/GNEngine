package io.greg.game.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import io.greg.engine.collision.Collision;
import io.greg.engine.entity.Entity;
import io.greg.engine.transform.Transform;
import io.greg.engine.world.World;

public class Enemy extends Entity {
    private final float speed;

    public Enemy(Transform transform, World world, float speed) {
        this.transform = transform;
        this.collision = new Collision();
        this.world = world;
        this.speed = speed;
    }

    @Override
    public void move(float x, float y, float delta) {
        float dx = x * speed * delta;
        float dy = y * speed * delta;
        translate(dx,dy);
    }

    @Override
    public void onCollision(Entity other) {
        if (other instanceof Player) {
            Player player = (Player) other;
            player.decrementLife(1);
        }
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
}
