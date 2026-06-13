package io.greg.game.controller;

import java.util.ArrayList;
import java.util.List;

public class ControllerManager {
    private final List<Controller> controllers = new ArrayList<>();

    public void add(Controller controller) {
        controllers.add(controller);
    }

    public void update(float delta) {
        for (Controller controller : controllers) {
            controller.update(delta);
        }
    }
}
