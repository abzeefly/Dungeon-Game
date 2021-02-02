package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import unsw.dungeon.*;

public class SwordTest{
    @Test
    public void SimpleSwordTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        Enemy enemy = new Enemy(d,2,3);
        assertEquals(d.getEntities().contains(enemy), true);
        Sword sword = new Sword(d,3,2);
        player.interact();
        assertEquals(player.getInventory().contains(sword), true);
        sword.swordAttack(); 
        assertEquals(d.getEntities().contains(enemy), false);
    }

    @Test
    public void SwordTurns(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        Enemy enemy = new Enemy(d,2,3);
        assertEquals(d.getEntities().contains(enemy), true);
        Sword sword = new Sword(d,3,2);
        player.interact();
        assertEquals(player.getInventory().contains(sword), true);
        sword.swordAttack(); 
        assertEquals(d.getEntities().contains(enemy), false);
        sword.swordAttack(); 
        sword.swordAttack(); 
        sword.swordAttack(); 
        sword.swordAttack(); 
        Enemy enemy1 = new Enemy(d,2,3);
        assertEquals(d.getEntities().contains(enemy1), true);
        sword.swordAttack(); 
        assertEquals(d.getEntities().contains(enemy1), true);
    }
};
