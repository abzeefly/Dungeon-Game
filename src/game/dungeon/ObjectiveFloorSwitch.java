package unsw.dungeon;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class ObjectiveFloorSwitch implements ObjectiveComposite, Observer{
    private Dungeon dungeon;
    private BooleanProperty isCompleted;

    public ObjectiveFloorSwitch(Dungeon dungeon){
        this.dungeon = dungeon;
        this.isCompleted = new SimpleBooleanProperty();
        isCompleted.set(false);
    }

    public void update(Subject obj){
        if (obj instanceof Player){
            update((Player) obj);
        }
        if (obj instanceof Boulder){
            update((Boulder) obj);
        }
    }
    public void update(Player p){
        isCompleted();
    }

    public void update(Boulder b){
        isCompleted();
    }

    @Override
    public BooleanProperty isCompleted(){
        for(Entity e :dungeon.getEntities()){
            if(e instanceof FloorSwitch){
                FloorSwitch t = (FloorSwitch)e;
                if(!(t.getSwitchStatus())){
                    this.isCompleted.set(false);
                    return this.isCompleted;
                }
            }
        }
        this.isCompleted.set(true);
        return isCompleted;
    }

    public BooleanProperty getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(BooleanProperty isCompleted) {
        this.isCompleted = isCompleted;
    }

    
}