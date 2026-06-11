package io.greg.engine.collision;

import io.greg.engine.entity.Entity;

public class CollisionManager {
    public boolean check(Entity a, Entity b) {
        return a.getCollision()
            .getBounds()
            .overlaps(
                b.getCollision()
                    .getBounds()
            );
    }
}
