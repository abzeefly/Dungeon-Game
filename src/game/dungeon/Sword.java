package unsw.dungeon;

import java.util.ArrayList;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Sword extends Entity {
    private int numAttacks;
    private Dungeon dungeon;
    private BooleanProperty isEquipped;
    public Sword(Dungeon dungeon,int x, int y) {
        super(x, y);
        super.setBlock(true);
        this.numAttacks = 5;
        this.dungeon = dungeon;
        isEquipped = new SimpleBooleanProperty();
        isEquipped.set(false);
        this.dungeon.addEntity(this);
    }

    public void swordAttack(){
        Player player = dungeon.getPlayer();
        if(this.numAttacks == 1){
            attack();
            this.numAttacks = this.numAttacks - 1;
            player.removeEntity(this);
        }

        else if(this.numAttacks > 1){
            attack();
            this.numAttacks = this.numAttacks - 1;
        }

    }

    public void interact(){
        Player player = dungeon.getPlayer();
        if(((player.getX() == this.getX()+1) && (player.getY() == this.getY()))
        ||((player.getX() == this.getX()-1) && (player.getY() == this.getY()))
        ||((player.getY() == this.getY()+1) && (player.getX() == this.getX()))
        ||((player.getY() == this.getY()-1) && (player.getX() == this.getX()))
        ){
            player.addInventory(this);
            isEquipped.set(true);
            dungeon.removeEntity(this);
        }
	}

    public void attack(){
        Enemy t = null;
        for(Entity e: dungeon.getEntities()){
            if(e instanceof Enemy){
                t = (Enemy)e;
                Player p = dungeon.getPlayer();
                if((t.getX() ==(p.getX() + 1) && (t.getY() == p.getY()))  
                || (t.getX() ==(p.getX() - 1) && (t.getY() == p.getY()))
                || (t.getY() ==(p.getY() + 1) && (t.getX() == p.getX()))
                || (t.getY() ==(p.getY() - 1) && (t.getX() == p.getX()))){
                    break;
                }
            }
        }
        if(t != null){
            dungeon.removeEntity(t);
        }
    }
    public int getNumAttack(){
        return numAttacks;
    }
    
}