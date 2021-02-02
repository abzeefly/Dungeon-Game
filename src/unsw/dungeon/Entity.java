package unsw.dungeon;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * An entity in the dungeon.
 * @author Robert Clifton-Everest
 *
 */
public class Entity {

    // IntegerProperty is used so that changes to the entities position can be
    // externally observed.
    private IntegerProperty x, y;
    private boolean block;

    /**
     * Create an entity positioned in square (x,y)
     * @param x
     * @param y
     */
    public Entity(int x, int y) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
    }

    public IntegerProperty x() {
        return x;
    }

    public IntegerProperty y() {
        return y;
    }

    public int getY() {
        return y().get();
    }

    public int getX() {
        return x().get();
    }
    public boolean getBlock(){
        return block;
    }
    public void setBlock(boolean block){
        this.block = block;
    }
    public String getType(){
        if (this instanceof Wall){
            return "Wall";
        }
        if (this instanceof Exit){
            return "Exit";
        }
        if (this instanceof Boulder){
            return "Boulder";
        }
        if (this instanceof FloorSwitch){
            return "FloorSwitch";
        }
        if (this instanceof Sword){
            return "Sword";
        }
        if (this instanceof Portal){
            return "Portal";
        }
        if (this instanceof Potion){
            return "Potion";
        }
        if (this instanceof Enemy){
            return "Enemy";
        }
        return "Dirt";
    }

    public Entity(){

    };

}
