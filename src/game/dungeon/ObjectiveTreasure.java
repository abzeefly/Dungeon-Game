package unsw.dungeon;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class ObjectiveTreasure implements ObjectiveComposite, Observer{
    private Dungeon dungeon;
    private BooleanProperty isCompleted;

   
    public ObjectiveTreasure(Dungeon dungeon){
        this.dungeon = dungeon;
        this.isCompleted = new SimpleBooleanProperty();
        isCompleted.set(false);
    }

    public void update(Subject obj){
        if (obj instanceof Player){
            update((Player) obj);
        }
    }
    public void update(Player p){
        isCompleted();
    }
    @Override
    public BooleanProperty isCompleted(){
        for(Entity e : dungeon.getEntities()){
            if(e instanceof Treasure){
                this.isCompleted.set(false);
                return this.isCompleted;
            }
        }
        this.isCompleted.set(true);
        return this.isCompleted;
    }
}