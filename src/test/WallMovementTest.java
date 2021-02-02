package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import unsw.dungeon.*;

public class WallMovementTest {
    @Test
    public void WallMoveUpTest1(){
        Dungeon d = new Dungeon(3, 3);
        Player player = new Player(d, 1, 1);
        d.setPlayer(player);
        Wall wall = new Wall(1,0);
        d.addEntity(wall);
        player.moveUp();
        assertEquals(player.getX(),1);
        assertEquals(player.getY(),1);
    }
    @Test
    public void WallMoveUpTest2(){
        Dungeon d = new Dungeon(3, 3);
        Player player = new Player(d, 1, 1);
        d.setPlayer(player);
        Wall wall = new Wall(0,1);
        d.addEntity(wall);
        player.moveUp();
        assertEquals(player.getX(),1);
        assertEquals(player.getY(),0);
    }
    @Test
    public void MoveDownTest1(){
        Dungeon d = new Dungeon(3, 3);
        Player player = new Player(d, 1, 1);
        d.setPlayer(player);
        Wall wall = new Wall(1,2);
        d.addEntity(wall);
        player.moveDown();
        assertEquals(player.getX(),1);
        assertEquals(player.getY(),1);
    }
    @Test
    public void MoveDownTest2(){
        Dungeon d = new Dungeon(3, 3);
        Player player = new Player(d, 1, 1);
        d.setPlayer(player);
        Wall wall = new Wall(1,0);
        d.addEntity(wall);
        player.moveDown();
        assertEquals(player.getX(),1);
        assertEquals(player.getY(),2);
    }

    @Test
    public void MoveLeftTest1(){
        Dungeon d = new Dungeon(3, 3);
        Player player = new Player(d, 1, 1);
        d.setPlayer(player);
        Wall wall = new Wall(0,1);
        d.addEntity(wall);
        player.moveLeft();
        assertEquals(player.getX(),1);
        assertEquals(player.getY(),1);
    }
    @Test
    public void MoveLeftTest2(){
        Dungeon d = new Dungeon(3, 3);
        Player player = new Player(d, 1, 1);
        d.setPlayer(player);
        Wall wall = new Wall(2,2);
        d.addEntity(wall);
        player.moveLeft();
        assertEquals(player.getX(),0);
        assertEquals(player.getY(),1);
    }
    @Test
    public void MoveRightTest1(){
        Dungeon d = new Dungeon(3, 3);
        Player player = new Player(d, 1, 1);
        d.setPlayer(player);
        Wall wall = new Wall(2,1);
        d.addEntity(wall);
        player.moveRight();
        assertEquals(player.getX(),1);
        assertEquals(player.getY(),1);
    }
    @Test
    public void MoveRightTest2(){
        Dungeon d = new Dungeon(3, 3);
        Player player = new Player(d, 1, 1);
        Wall wall = new Wall(2,2);
        d.addEntity(wall);
        d.setPlayer(player);
        player.moveRight();
        assertEquals(player.getX(),2);
        assertEquals(player.getY(),1);
    }
}

