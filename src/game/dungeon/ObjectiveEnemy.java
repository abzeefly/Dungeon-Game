package unsw.dungeon;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class ObjectiveEnemy implements ObjectiveComposite, Observer{
    private Dungeon dungeon;
    private BooleanProperty isCompleted;

    public ObjectiveEnemy(Dungeon dungeon){
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
        for(Entity e :dungeon.getEntities()){
            if(e instanceof Enemy){
                Enemy t = (Enemy)e;
                if(t.getIsALive().get()){
                    this.isCompleted.set(false);
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