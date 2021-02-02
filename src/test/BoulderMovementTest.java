package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import unsw.dungeon.*;

public class BoulderMovementTest {
    @Test
    public void BoulderMoveUpTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        Boulder boulder = new Boulder(d,2,1);
        d.addEntity(boulder);
        player.moveUp();
        assertEquals(boulder.getX(), 2);
        assertEquals(boulder.getY(), 0);
        assertEquals(player.getX(),2);
        assertEquals(player.getY(),1);
    }
    @Test
    public void BoulderWallMoveUpTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d,2,2);
        d.setPlayer(player);
        Boulder boulder = new Boulder(d,2,1);
        d.addEntity(boulder);
        Wall wall = new Wall(2,0);
        d.addEntity(wall);
        player.moveUp();
        assertEquals(boulder.getX(), 2);
        assertEquals(boulder.getY(), 1);
        assertEquals(player.getX(),2);
        assertEquals(player.getY(),2);
    }
    @Test
    public void BoulderCornerMoveUpTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d,2,1);
        d.setPlayer(player);
        Boulder boulder = new Boulder(d,2,0);
        d.addEntity(boulder);
        player.moveUp();
        assertEquals(boulder.getX(), 2);
        assertEquals(boulder.getY(), 0);
        assertEquals(player.getX(),2);
        assertEquals(player.getY(),1);
    }
    @Test
    public void TwoBoulderMoveUpTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        Boulder boulder1 = new Boulder(d,2,1);
        d.addEntity(boulder1);
        Boulder boulder2 = new Boulder(d,2,0);
        d.addEntity(boulder2);
        player.moveUp();
        assertEquals(boulder1.getX(), 2);
        assertEquals(boulder1.getY(), 1);
        assertEquals(boulder2.getX(), 2);
        assertEquals(boulder2.getY(), 0);
        assertEquals(player.getX(),2);
        assertEquals(player.getY(),2);
    }
    @Test
    public void BoulderMoveDownTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        Boulder boulder = new Boulder(d,2,3);
        d.addEntity(boulder);
        player.moveDown();
        assertEquals(boulder.getX(), 2);
        assertEquals(boulder.getY(), 4);
        assertEquals(player.getX(),2);
        assertEquals(player.getY(),3);
    }
    @Test
    public void BoulderWallMoveDownTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        Boulder boulder = new Boulder(d,2,3);
        d.addEntity(boulder);
        Wall wall = new Wall(2,4);
        d.addEntity(wall);
        player.moveDown();
        assertEquals(boulder.getX(), 2);
        assertEquals(boulder.getY(), 3);
        assertEquals(player.getX(),2);
        assertEquals(player.getY(),2);
    }
    @Test
    public void BoulderCornerMoveDownTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 3);
        d.setPlayer(player);
        Boulder boulder = new Boulder(d,2,4);
        d.addEntity(boulder);
        player.moveDown();
        assertEquals(boulder.getX(), 2);
        assertEquals(boulder.getY(), 4);
        assertEquals(player.getX(),2);
        assertEquals(player.getY(),3);
    }
    @Test
    public void TwoBoulderMoveDownTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        Boulder boulder1 = new Boulder(d,2,3);
        d.addEntity(boulder1);
        Boulder boulder2 = new Boulder(d,2,4);
        d.addEntity(boulder2);
        player.moveDown();
        assertEquals(boulder1.getX(), 2);
        assertEquals(boulder1.getY(), 3);
        assertEquals(boulder2.getX(), 2);
        assertEquals(boulder2.getY(), 4);
        assertEquals(player.getX(),2);
        assertEquals(player.getY(),2);
    }
    @Test
    public void BoulderMoveLeftTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        Boulder boulder = new Boulder(d,1,2);
        d.addEntity(boulder);
        player.moveLeft();
        assertEquals(boulder.getX(), 0);
        assertEquals(boulder.getY(), 2);
        assertEquals(player.getX(),1);
        assertEquals(player.getY(),2);
    }
    @Test
    public void BoulderWallMoveLeftTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        Boulder boulder = new Boulder(d,1,2);
        d.addEntity(boulder);
        Wall wall = new Wall(0,2);
        d.addEntity(wall);
        player.moveLeft();
        assertEquals(boulder.getX(), 1);
        assertEquals(boulder.getY(), 2);
        assertEquals(player.getX(),2);
        assertEquals(player.getY(),2);
    }
    @Test
    public void BoulderCornerMoveLeftTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 1, 2);
        d.setPlayer(player);
        Boulder boulder = new Boulder(d,0,2);
        d.addEntity(boulder);
        player.moveLeft();
        assertEquals(boulder.getX(), 0);
        assertEquals(boulder.getY(), 2);
        assertEquals(player.getX(),1);
        assertEquals(player.getY(),2);
    }
    @Test
    public void TwoBoulderMoveLeftTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        Boulder boulder1 = new Boulder(d,1,2);
        d.addEntity(boulder1);
        Boulder boulder2 = new Boulder(d,0,2);
        d.addEntity(boulder2);
        player.moveLeft();
        assertEquals(boulder1.getX(), 1);
        assertEquals(boulder1.getY(), 2);
        assertEquals(boulder2.getX(), 0);
        assertEquals(boulder2.getY(), 2);
        assertEquals(player.getX(),2);
        assertEquals(player.getY(),2);
    }
    @Test
    public void BoulderMoveRightTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        Boulder boulder = new Boulder(d,3,2);
        d.addEntity(boulder);
        player.moveRight();
        assertEquals(boulder.getX(), 4);
        assertEquals(boulder.getY(), 2);
        assertEquals(player.getX(),3);
        assertEquals(player.getY(),2);
    }
    @Test
    public void BoulderWallMoveRightTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        Boulder boulder = new Boulder(d,3,2);
        d.addEntity(boulder);
        Wall wall = new Wall(4,2);
        d.addEntity(wall);
        player.moveRight();
        assertEquals(boulder.getX(), 3);
        assertEquals(boulder.getY(), 2);
        assertEquals(player.getX(),2);
        assertEquals(player.getY(),2);
    }
    @Test
    public void BoulderCornerMoveRightTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 3, 2);
        d.setPlayer(player);
        Boulder boulder = new Boulder(d,4,2);
        d.addEntity(boulder);
        player.moveRight();
        assertEquals(boulder.getX(), 4);
        assertEquals(boulder.getY(), 2);
        assertEquals(player.getX(),3);
        assertEquals(player.getY(),2);
    }
    @Test
    public void TwoBoulderMoveRightTest(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 2);
        d.setPlayer(player);
        Boulder boulder1 = new Boulder(d,3,2);
        d.addEntity(boulder1);
        Boulder boulder2 = new Boulder(d,4,2);
        d.addEntity(boulder2);
        player.moveRight();
        assertEquals(boulder1.getX(), 3);
        assertEquals(boulder1.getY(), 2);
        assertEquals(boulder2.getX(), 4);
        assertEquals(boulder2.getY(), 2);
        assertEquals(player.getX(),2);
        assertEquals(player.getY(),2);
    }
}

