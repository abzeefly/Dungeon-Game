package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import unsw.dungeon.*;


public class PotionTest{

    @Test
    public void SimplePotionTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        Enemy enemy = new Enemy(d,2,3);
        assertEquals(d.getEntities().contains(enemy), true);
        Potion potion = new Potion(d,3,2);
        potion.interact();
        assertEquals(player.getInventory().contains(potion), true);
        assertEquals(potion.getIsActivated().get(), true);
        assertEquals(enemy.getIsPotionActivated().get(), true);
        player.moveDown();
        assertEquals(d.getEntities().contains(enemy), false);
        assertEquals(enemy.getIsALive().get(), false);
    }
    @Test
    public void PotionSteps(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        Potion potion = new Potion(d,3,2);
        assertEquals(potion.getIsActivated().get(), false);
        potion.interact();
        assertEquals(potion.getIsActivated().get(), true);
        player.moveDown();
        player.moveDown();
        player.moveDown();
        player.moveDown();
        player.moveUp();
        assertEquals(potion.getSteps(),0);
        player.moveUp();
        assertEquals(potion.getIsActivated().get() ,false);
    }

};
