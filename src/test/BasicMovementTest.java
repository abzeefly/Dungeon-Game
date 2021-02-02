package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import unsw.dungeon.*;

public class BasicMovementTest {
    @Test
    public void MoveUpTest(){
        Dungeon d = new Dungeon(3, 3);
        Player player = new Player(d, 1, 1);
        d.setPlayer(player);
        player.moveUp();
        assertEquals(player.getX(),1);
        assertEquals(player.getY(),0);
    }
    @Test
    public void MoveDownTest(){
        Dungeon d = new Dungeon(3, 3);
        Player player = new Player(d, 1, 1);
        d.setPlayer(player);
        player.moveDown();
        assertEquals(player.getX(),1);
        assertEquals(player.getY(),2);
    }

    @Test
    public void MoveLeftTest(){
        Dungeon d = new Dungeon(3, 3);
        Player player = new Player(d, 1, 1);
        d.setPlayer(player);
        player.moveLeft();
        assertEquals(player.getX(),0);
        assertEquals(player.getY(),1);
    }
    @Test
    public void MoveRightTest(){
        Dungeon d = new Dungeon(3, 3);
        Player player = new Player(d, 1, 1);
        d.setPlayer(player);
        player.moveRight();
        assertEquals(player.getX(),2);
        assertEquals(player.getY(),1);
    }
}

