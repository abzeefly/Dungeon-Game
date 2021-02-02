package unsw.dungeon;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Portal extends Entity {
    private int key;
    Dungeon dungeon;
    BooleanProperty isfound ;
    public Portal(Dungeon dungeon, int x, int y)  {
        super(x, y);
        this.dungeon = dungeon;
        if(dungeon.getAvailablePortalKey().isEmpty()){
            this.key = dungeon.getUnusedPortalKey().get(0);
            dungeon.getAvailablePortalKey().add(dungeon.getUnusedPortalKey().get(0));
            dungeon.getUnusedPortalKey().remove(0);
        }
        else if((!dungeon.getAvailablePortalKey().isEmpty())){
            this.key = dungeon.getAvailablePortalKey().get(0);
            dungeon.getAvailablePortalKey().remove(0);
        }
        else if (dungeon.getUnusedPortalKey().isEmpty()){
            System.err.println("No more portals allowed");
        }
        this.isfound = new SimpleBooleanProperty();
        this.isfound.set(false);
        this.dungeon.addEntity(this);
    }

    public void interact(){
        for (Entity e : dungeon.getEntities()){
            if(e instanceof Portal){
                Portal p = (Portal)e;
                if(p.getKey() == this.key){
                    isfound.set(true);
                    dungeon.getPlayer().teleport(p.getX(), p.getY());
                }
            }
        }
    }


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public BooleanProperty getIsfound() {
        return isfound;
    }

    public void setIsfound(BooleanProperty isfound) {
        this.isfound = isfound;
    }

}