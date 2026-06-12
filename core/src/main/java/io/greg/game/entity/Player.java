package io.greg.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import io.greg.engine.collision.Collision;
import io.greg.engine.entity.Entity;
import io.greg.engine.transform.Transform;

public class Player extends Entity {
    private final float speed;
    private int life;

    public Player(Transform transform, float speed, int life) {
        this.transform = transform;
        this.collision = new Collision();
        this.speed = speed;
        this.life = life;
    }

    @Override
    public void decrementLife(int damage) {
        if (life <= 0) {
            return;
        }
        life -= damage;
        Gdx.app.log("DAMAGE", "Vida do Jogador: " + String.valueOf(life));
    }

    @Override
    public void move(float x, float y, float delta) {
        float dx = x * speed * delta;
        float dy = y * speed * delta;
        transform.translate(dx, dy);
    }

    @Override
    public void onCollision(Entity other) {

    }

    @Override
    public void update(float delta) {
        collision.update(transform.getX(), transform.getY(), transform.getWidth(), transform.getHeight());
    }

    @Override
    public void render(ShapeRenderer shape) {
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.WHITE);
        shape.rect(transform.getX(), transform.getY(), transform.getWidth(), transform.getHeight());
        shape.end();
    }
}
