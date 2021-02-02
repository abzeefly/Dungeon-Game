package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import unsw.dungeon.*;

public class ObjectiveExitTest {
    @Test
    public void SimpleObjectiveExitTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        Exit exit = new Exit(3,2);
        d.addEntity(exit);
        Objectives obs = new Objectives();
        d.addObjectives(obs);
        ObjectiveExit oe = new ObjectiveExit(d);
        obs.addObjective(oe);
        assertFalse(oe.getIsCompleted().get());
        assertFalse(obs.getIsCompleted().get());
        player.moveRight();
        assertEquals(d.getPlayer().getX(), exit.getX());
        assertEquals(d.getPlayer().getY(), exit.getY());;
        assertTrue(oe.getIsCompleted().get());
    }
}

