package unsw.dungeon;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class ObjectiveExit implements ObjectiveComposite, Observer{
    private Dungeon dungeon;
    private BooleanProperty isCompleted;
    public ObjectiveExit(Dungeon dungeon){
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
        Player p = dungeon.getPlayer();
        for(Entity e :dungeon.getEntities()){
            if(e instanceof Exit){
                Exit t = (Exit)e;
                if(p.getX() == t.getX() && p.getY() == t.getY()){
                    this.isCompleted.set(true);
                    return this.isCompleted;
                }
            }
        }
        return this.isCompleted;
    }

    public BooleanProperty getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(BooleanProperty isCompleted) {
        this.isCompleted = isCompleted;
    }

    



}