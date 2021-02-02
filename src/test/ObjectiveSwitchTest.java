package test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import unsw.dungeon.*;

public class ObjectiveSwitchTest {
    @Test
    public void SimpleObjectiveFloorSwitchTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        FloorSwitch fs = new FloorSwitch(d, 4, 2);
        d.addEntity(fs);
        Boulder boulder = new Boulder(d,3,2);
        d.addEntity(boulder);
        Objectives obs = new Objectives();
        d.addObjectives(obs);
        ObjectiveFloorSwitch ofs = new ObjectiveFloorSwitch(d);
        obs.addObjective(ofs);
        assertFalse(ofs.getIsCompleted().get());
        assertFalse(obs.getIsCompleted().get());
        player.moveRight();
        assertTrue(ofs.getIsCompleted().get());
        assertTrue(obs.getIsCompleted().get());

    }
    @Test
    public void PlaceObjectiveFloorSwitchTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        Objectives obs = new Objectives();
        d.addObjectives(obs);
        ObjectiveFloorSwitch ofs = new ObjectiveFloorSwitch(d);
        obs.addObjective(ofs);
        FloorSwitch fs = new FloorSwitch(d, 4, 2);
        d.addEntity(fs);
        Boulder boulder = new Boulder(d,4,2);
        d.addEntity(boulder);
        assertTrue(ofs.getIsCompleted().get());
        assertTrue(obs.getIsCompleted().get());
    }
    @Test
    public void ComplexObjectiveFloorSwitchTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        FloorSwitch fs1 = new FloorSwitch(d, 4, 2);
        d.addEntity(fs1);
        FloorSwitch fs2 = new FloorSwitch(d, 2, 4);
        d.addEntity(fs2);
        Boulder boulder1 = new Boulder(d,3,2);
        d.addEntity(boulder1);
        Boulder boulder2 = new Boulder(d,2,3);
        d.addEntity(boulder2);
        Objectives obs = new Objectives();
        d.addObjectives(obs);
        ObjectiveFloorSwitch ofs = new ObjectiveFloorSwitch(d);
        obs.addObjective(ofs);
        assertEquals(ofs.getIsCompleted().get(), false);
        assertEquals(obs.getIsCompleted().get(), false);
        player.moveRight();
        assertEquals(fs1.getSwitchStatus(), true);
        assertEquals(ofs.getIsCompleted().get(), false);
        assertEquals(obs.getIsCompleted().get(), false);
        player.moveLeft();
        player.moveDown();
        assertEquals(fs2.getSwitchStatus(), true);
        assertTrue(ofs.getIsCompleted().get());
        assertTrue(obs.getIsCompleted().get());
    }
}

