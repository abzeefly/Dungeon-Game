package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import unsw.dungeon.*;

public class SwitchTest {
    @Test
    public void PlaceSwitchTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        Boulder boulder1 = new Boulder(d,2, 3);
        d.addEntity(boulder1);
        FloorSwitch fswitch = new FloorSwitch(d, 2, 4);
        d.addEntity(fswitch);
        assertEquals(fswitch.getSwitchStatus(), false);
        Boulder boulder2 = new Boulder(d,2,4);
        d.addEntity(boulder2);
        assertEquals(fswitch.getSwitchStatus(), true);
    }
    @Test
    public void SimpleBoulderMoveTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        Boulder boulder = new Boulder(d,2, 3);
        d.addEntity(boulder);
        FloorSwitch fswitch = new FloorSwitch(d, 2, 4);
        d.addEntity(fswitch);
        assertEquals(fswitch.getSwitchStatus(), false);
        player.moveDown();
        assertEquals(fswitch.getSwitchStatus(), true);
        player.moveLeft();
        player.moveDown();
        player.moveRight();
        assertEquals(fswitch.getSwitchStatus(), false);
        assertEquals(boulder.getX(),3);
        assertEquals(boulder.getY(),4);
    }
    @Test
    public void MultipleSwitchesTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        FloorSwitch fswitch1 = new FloorSwitch(d, 4, 2);
        FloorSwitch fswitch2 = new FloorSwitch(d, 2, 4);
        d.addEntity(fswitch1);
        d.addEntity(fswitch2);
        assertEquals(fswitch1.getSwitchStatus(), false);
        assertEquals(fswitch2.getSwitchStatus(), false);
        Boulder boulder1 = new Boulder(d,3,2);
        d.addEntity(boulder1);
        Boulder boulder2 = new Boulder(d,2,3);
        d.addEntity(boulder2);
        player.moveRight();
        assertEquals(fswitch1.getSwitchStatus(), true);
        player.moveLeft();
        player.moveDown();
        assertEquals(fswitch1.getSwitchStatus(), true);
        assertEquals(fswitch2.getSwitchStatus(), true);
    }
    @Test
    public void OneBoulderMultiSwitchesTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        Boulder boulder = new Boulder(d,3,2);
        d.addEntity(boulder);
        FloorSwitch fswitch1 = new FloorSwitch(d, 3, 2);
        FloorSwitch fswitch2 = new FloorSwitch(d, 4, 2);
        FloorSwitch fswitch3 = new FloorSwitch(d, 4, 3);
        d.addEntity(fswitch1);
        d.addEntity(fswitch2);
        d.addEntity(fswitch3);
        assertEquals(fswitch1.getSwitchStatus(), true);
        assertEquals(fswitch2.getSwitchStatus(), false);
        assertEquals(fswitch3.getSwitchStatus(), false);
        player.moveRight();
        assertEquals(fswitch1.getSwitchStatus(), false);
        assertEquals(fswitch2.getSwitchStatus(), true);
        assertEquals(fswitch3.getSwitchStatus(), false);
        player.moveUp();
        player.moveRight();
        player.moveDown();
        assertEquals(fswitch1.getSwitchStatus(), false);
        assertEquals(fswitch2.getSwitchStatus(), false);
        assertEquals(fswitch3.getSwitchStatus(), true);
        player.moveDown();
        assertEquals(fswitch1.getSwitchStatus(), false);
        assertEquals(fswitch2.getSwitchStatus(), false);
        assertEquals(fswitch3.getSwitchStatus(), false);
    }
}

