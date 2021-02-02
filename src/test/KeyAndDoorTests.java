package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import unsw.dungeon.*;

public class KeyAndDoorTests{
    @Test
    public void simpleKeyAndDoor(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 1, 2);
        d.setPlayer(player);
        assertEquals(d.getEntities().contains(player), true);
        Key k = new Key(2,2,d);
        Door door = new Door(4, 4, d);
        assertEquals(d.getEntities().contains(k), true);
        assertEquals(d.getEntities().contains(door), true);
        player.interact();
        assertEquals(d.getEntities().contains(k), false);
        assertEquals(player.getInventory().contains(k), true);
        player.moveDown();
        player.moveDown();
        player.moveRight();
        player.moveRight();
        player.interact();
        assertEquals(player.getX(), 3);
        assertEquals(player.getY(), 4);
        assertEquals(door.getIsLocked().get(), false);
        player.moveUp();
        player.moveUp();
    }

}