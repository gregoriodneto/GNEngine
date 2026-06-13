package io.greg.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import io.greg.engine.controller.Controller;
import io.greg.game.entity.Player;

public class PlayerController implements Controller {
    private final Player player;

    public PlayerController(Player player) {
        this.player = player;
    }

    public void update(float delta) {
        float x = 0, y = 0;
        if (Gdx.input.isKeyPressed(Input.Keys.W)) y++;
        if (Gdx.input.isKeyPressed(Input.Keys.S)) y--;
        if (Gdx.input.isKeyPressed(Input.Keys.D)) x++;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) x--;

        player.move(x, y, delta);
    }
}
