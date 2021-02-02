package unsw.dungeon;
import java.util.ArrayList;

public class Boulder extends Entity implements Subject{
    private ArrayList<Observer> listObservers = new ArrayList<Observer>();
    private Dungeon dungeon;

    public Boulder(Dungeon dungeon,int x, int y) {
        super(x, y);
        super.setBlock(true);
        this.dungeon = dungeon;
        updateSwitches();
        notifyObservers();
    }
    @Override
	public void attach(Observer o) {
		if(! listObservers.contains(o)) { listObservers.add(o); }
    }
    @Override
	public void detach(Observer o) {
		listObservers.remove(o);
    }   
    @Override
	public void notifyObservers() {
		for( Observer obs : listObservers) {
			obs.update(this);
		}
	}

    public void moveBoulderUp(){
        updateSwitches();
        y().set(getY() - 1);
        notifyObservers();
    }
    public void moveBoulderDown(){
        updateSwitches();
        y().set(getY() + 1);
        notifyObservers();
    }
    public void moveBoulderLeft(){
        updateSwitches();
        x().set(getX() - 1);
        notifyObservers();
    }
    public void moveBoulderRight(){
        updateSwitches();
        x().set(getX() + 1);
        notifyObservers();
    }
    public void updateSwitches(){
        for (Entity entity : dungeon.getEntities()){
            if (entity instanceof FloorSwitch){
                attach((Observer) entity);
            }
        }
        for(Objectives o : this.dungeon.getObjectivesList()){
            attach((Observer)o);
            for(ObjectiveComposite oc : o.getObjectives()){
                attach((Observer)oc);
            }
        }
    }
}
