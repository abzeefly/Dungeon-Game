package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import unsw.dungeon.*;

public class CornerMovementTest {
    @Test
    public void MoveUpTest1(){
        Dungeon d = new Dungeon(3, 3);
        Player player = new Player(d, 0, 0);
        d.setPlayer(player);
        player.moveUp();
        assertEquals(player.getX(),0);
        assertEquals(player.getY(),0);
    }
    @Test
    public void MoveUpTest2(){
        Dungeon d = new Dungeon(3, 3);
        Player player = new Player(d, 1, 0);
        d.setPlayer(player);
        player.moveUp();
        assertEquals(player.getX(),1);
        assertEquals(player.getY(),0);
    }
    @Test
    public void MoveDownTest1(){
        Dungeon d = new Dungeon(3, 3);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        player.moveDown();
        assertEquals(player.getX(),2);
        assertEquals(player.getY(),2);
    }

    @Test
    public void MoveDownTest2(){
        Dungeon d = new Dungeon(3, 3);
        Player player = new Player(d, 1, 2);
        d.setPlayer(player);
        player.moveDown();
        assertEquals(player.getX(),1);
        assertEquals(player.getY(),2);
    }

    @Test
    public void MoveLeftTest1(){
        Dungeon d = new Dungeon(3, 3);
        Player player = new Player(d, 0, 0);
        d.setPlayer(player);
        player.moveLeft();
        assertEquals(player.getX(),0);
        assertEquals(player.getY(),0);
    }
    @Test
    public void MoveLeftTest2(){
        Dungeon d = new Dungeon(3, 3);
        Player player = new Player(d, 0, 1);
        d.setPlayer(player);
        player.moveLeft();
        assertEquals(player.getX(),0);
        assertEquals(player.getY(),1);
    }
    @Test
    public void MoveRightTest1(){
        Dungeon d = new Dungeon(3, 3);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        player.moveRight();
        assertEquals(player.getX(),2);
        assertEquals(player.getY(),2);
    }
    @Test
    public void MoveRightTest2(){
        Dungeon d = new Dungeon(3, 3);
        Player player = new Player(d, 2, 1);
        d.setPlayer(player);
        player.moveRight();
        assertEquals(player.getX(),2);
        assertEquals(player.getY(),1);
    }
}

