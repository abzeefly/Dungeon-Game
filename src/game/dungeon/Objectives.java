package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Objectives implements ObjectiveComposite, Observer {
    private List<ObjectiveComposite> objectives = new ArrayList<ObjectiveComposite>(); 
    private BooleanProperty isCompleted;

   
    public Objectives(){
        this.isCompleted = new SimpleBooleanProperty();
        this.isCompleted.set(false);
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
        if(objectives.isEmpty()){
            return this.isCompleted;
        }
        for(ObjectiveComposite o : objectives){
            if(!(o.isCompleted().get())){
                return this.isCompleted;
            }
        }
        this.isCompleted.set(true);
        return this.isCompleted;
    }

    public void addObjective(ObjectiveComposite oc){
        objectives.add(oc);
    }
    public void removeObjective(ObjectiveComposite oc){
        objectives.remove(oc);
    }

    public List<ObjectiveComposite> getObjectives() {
        return objectives;
    }

    public void setObjectives(List<ObjectiveComposite> objectives) {
        this.objectives = objectives;
    }

    public BooleanProperty getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(BooleanProperty isCompleted) {
        this.isCompleted = isCompleted;
    }

}