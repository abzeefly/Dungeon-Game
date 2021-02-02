package test;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import unsw.dungeon.*;

public class PortalTests {
    @Test
    public void simplePortal(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 1, 2);
        d.setPlayer(player);
        Portal portal1 = new Portal(d, 2, 2);
        Portal portal2 = new Portal(d, 3, 3);
        assertEquals(portal1.getKey(), 0);
        assertEquals(portal2.getKey(), 0);
        player.interact();
        assertEquals(portal1.getIsfound().get(), true);
        assertEquals(player.getX(),3);
        assertEquals(player.getY(),3);
    }
    
}