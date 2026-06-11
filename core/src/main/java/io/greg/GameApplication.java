package io.greg;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import io.greg.game.screen.MainMenuScreen;

public class GameApplication extends Game {

    @Override
    public void create() {
        setScreen(new MainMenuScreen());
        Gdx.app.log("INFO","Hello World!");
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {

    }
}
