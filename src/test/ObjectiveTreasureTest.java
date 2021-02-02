package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import unsw.dungeon.*;

public class ObjectiveTreasureTest {
    @Test
    public void SimpleObjectiveTreasureTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        Treasure treasure = new Treasure(d,3,2);
        d.addEntity(treasure);
        Objectives obs = new Objectives();
        ObjectiveTreasure ot = new ObjectiveTreasure(d);
        obs.addObjective(ot);
        assertEquals(ot.isCompleted().get(), false);
        assertEquals(obs.isCompleted().get(), false);
        player.moveRight();
        player.interact();
        assertEquals(ot.isCompleted().get(), true);
        assertEquals(obs.isCompleted().get(), true);
    }
    
    @Test
    public void RepeatMoveObjectiveTreasureTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        Treasure treasure = new Treasure(d,3,2);
        d.addEntity(treasure);
        Objectives obs = new Objectives();
        ObjectiveTreasure ot = new ObjectiveTreasure(d);
        obs.addObjective(ot);

        assertEquals(ot.isCompleted().get(), false);
        assertEquals(obs.isCompleted().get(), false);
        player.moveRight();
        player.interact();
        assertEquals(ot.isCompleted().get(), true);
        assertEquals(obs.isCompleted().get(), true);
        player.moveRight();
        player.moveLeft();
        player.moveRight();
        player.moveLeft();
        assertEquals(ot.isCompleted().get(), true);
        assertEquals(obs.isCompleted().get(), true);
    }
    @Test
    public void MultipleObjectiveTreasureTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        Treasure treasure1 = new Treasure(d,3,2);
        d.addEntity(treasure1);
        Treasure treasure2 = new Treasure(d,2,3);
        d.addEntity(treasure2);
        Objectives obs = new Objectives();
        ObjectiveTreasure ot = new ObjectiveTreasure(d);
        obs.addObjective(ot);
        assertEquals(ot.isCompleted().get(), false);
        assertEquals(obs.isCompleted().get(), false);
        player.moveRight();
        player.interact();
        player.moveDown();
        player.interact();
        assertEquals(ot.isCompleted().get(), true);
        assertEquals(obs.isCompleted().get(), true);
    }
}

