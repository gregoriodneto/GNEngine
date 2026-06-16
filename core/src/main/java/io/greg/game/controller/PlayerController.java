package io.greg.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import io.greg.engine.controller.Controller;
import io.greg.game.entity.Player;

public class PlayerController implements Controller {
    private final Player player;

    public PlayerController(Player player) {
        this.player = player;
    }

    public void update(float delta) {
        Vector2 direction = new Vector2();
        float x = 0, y = 0;
        if (Gdx.input.isKeyPressed(Input.Keys.W)) direction.y++;
        if (Gdx.input.isKeyPressed(Input.Keys.S)) direction.y--;
        if (Gdx.input.isKeyPressed(Input.Keys.D)) direction.x++;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) direction.x--;

        player.move(direction, delta);
    }
}
