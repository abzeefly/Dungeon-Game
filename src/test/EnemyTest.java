package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import unsw.dungeon.*;
public class EnemyTest {

    @Test
    public void SimpleEnemyTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 1, 2);
        d.setPlayer(player);
        assertEquals(d.getEntities().contains(player), true);
        Enemy enemy = new Enemy(d,2,2);
        player.moveRight();
        assertEquals(d.getEntities().contains(enemy), true);
        assertEquals(d.getEntities().contains(player), false);
        assertEquals(player.getIsAlive().get(),false);
    }
    @Test
    public void EnemyWalkTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 3);
        d.setPlayer(player);
        assertEquals(d.getEntities().contains(player), true);
        Enemy enemy = new Enemy(d,2,2);
        assertEquals(d.getEntities().contains(enemy), true);
        player.moveRight();
        assertTrue(enemy.isStrat());
        assertEquals(enemy.getX(),2);
        assertEquals(enemy.getY(),3);
        player.moveRight();
        assertEquals(enemy.getX(),3);
        assertEquals(enemy.getY(),3);
        player.moveLeft();
        assertEquals(enemy.getX(),3);
        assertEquals(enemy.getY(),3);
        assertEquals(d.getEntities().contains(player), false);
        assertEquals(player.getIsAlive().get(),false);
    }
    
}