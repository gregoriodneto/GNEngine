package io.greg.engine.collision;

import com.badlogic.gdx.Gdx;
import io.greg.engine.entity.Entity;
import io.greg.engine.entity.EntityManager;

public class CollisionManager {
    public boolean check(Entity a, Entity b) {
        return a.getCollision()
            .getBounds()
            .overlaps(
                b.getCollision()
                    .getBounds()
            );
    }

    public void checkAll(EntityManager entityManager) {
        var entities = entityManager.getEntities();
        for (int i = 0; i < entities.size(); i++) {
            for (int j = i + 1; j < entities.size(); j++) {
                Entity entity1 = entities.get(i);
                Entity entity2 = entities.get(j);

                if (check(entity1, entity2)) {
                    entity1.onCollision(entity2);
                    entity2.onCollision(entity1);
                }
            }
        }
    }
}
