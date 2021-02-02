
package unsw.dungeon;

import java.util.ArrayList;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Potion extends Entity implements Observer,Subject {
    
    private ArrayList<Observer> listObservers = new ArrayList<Observer>();

    private int steps;
    private Dungeon dungeon;
    private BooleanProperty isActivated;
    
    public Potion(Dungeon dungeon ,int x, int y) {
        super(x, y);
        super.setBlock(false);
        this.steps = dungeon.getPotionSize();
        this.isActivated = new SimpleBooleanProperty();
        this.isActivated.set(false);
        this.dungeon = dungeon;
        updateEnemy();
        notifyObservers();
    }

    public void update(Subject obj){
        if (obj instanceof Player){
            update((Player) obj);
            notifyObservers();
        }
    }
    
    public void update(Player p){
        if(this.steps == 0){
            updateEnemy();
            this.isActivated.set(false);
            p.removeEntity(this);
            notifyObservers();
        }
        setSteps(getSteps() -1);
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
    
    public void reduce_steps(){
        setSteps(getSteps() -1);
    }

    public void interact(){
        updateEnemy();
        Player player = dungeon.getPlayer();
        if(((player.getX() == this.getX()+1) && (player.getY() == this.getY()))
        ||((player.getX() == this.getX()-1) && (player.getY() == this.getY()))
        ||((player.getY() == this.getY()+1) && (player.getX() == this.getX()))
        ||((player.getY() == this.getY()-1) && (player.getX() == this.getX()))
        ){
            
            player.addInventory(this);
            this.isActivated.set(true);
            dungeon.removeEntity(this);
            notifyObservers();
        }
        notifyObservers();
    }
    
    public void updateEnemy(){
        for(Entity e : dungeon.getEntities()){
            if(e instanceof Enemy){
                attach((Observer) e);
            }
        }
    }

    public BooleanProperty getIsActivated() {
        return isActivated;
    }

    public void setIsActivated(BooleanProperty isActivated) {
        this.isActivated = isActivated;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    
}