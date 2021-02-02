package unsw.dungeon;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.util.ArrayList;
/**
 * The player entity
 * @author Robert Clifton-Everest
 *
 */
public class Player extends Entity implements Subject {
    private ArrayList<Observer> listObservers = new ArrayList<Observer>();

    private Dungeon dungeon;
    private BooleanProperty isAlive;
    private Inventory inventory;
    /**
     * Create a player positioned in square (x,y)
     * @param x
     * @param y
     */
    public Player(Dungeon dungeon, int x, int y) {
        super(x, y);
        super.setBlock(false);
        this.dungeon = dungeon;
        this.isAlive = new SimpleBooleanProperty();
        this.isAlive.set(true);
        this.inventory = new Inventory();
        this.dungeon.addEntity(this);
        updateSteps();
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

    public void moveUp() {
        updateSteps();
        if (getY() > 0){
            boolean move = true;
            if (dungeon.checkBlockXY(getX(), getY()-1)){
                if (dungeon.checkBoulderXY(getX(), getY()-1)){
                    if (getY() > 1){
                        if (dungeon.checkBlockXY(getX(), getY()-2)){
                            move = false;
                        }
                        else{
                            Boulder moveBoulder = dungeon.getBoulderXY(getX(), getY()-1);
                            moveBoulder.moveBoulderUp();
                        }
                    }
                    else
                        move = false;
                }
                else 
                    move = false;
            }
            if (move){
                y().set(getY() - 1);
            }
        }
        notifyObservers();
    }

    public void moveDown() {
        updateSteps();
        if (getY() < dungeon.getHeight() - 1){
            boolean move = true;
            if (dungeon.checkBlockXY(getX(), getY()+1)){
                if (dungeon.checkBoulderXY(getX(), getY()+1)){
                    if (getY() < dungeon.getHeight() - 2){
                        if (dungeon.checkBlockXY(getX(), getY() + 2)){
                            move = false;
                        }
                        else{
                            Boulder moveBoulder = dungeon.getBoulderXY(getX(), getY()+1);
                            moveBoulder.moveBoulderDown();
                        }
                    }
                    else
                        move = false;
                }
                else 
                    move = false;
            }
            if (move){
                y().set(getY() + 1);
            }
        }
        notifyObservers();   
    }

    public void moveLeft() {
        updateSteps();
        if (getX() > 0){
            boolean move = true;
            if (dungeon.checkBlockXY(getX()-1, getY())){
                if (dungeon.checkBoulderXY(getX()-1, getY())){
                    if (getX() > 1){
                        if (dungeon.checkBlockXY(getX()-2, getY())){
                            move = false;
                        }
                        else{
                            Boulder moveBoulder = dungeon.getBoulderXY(getX()-1, getY());
                            moveBoulder.moveBoulderLeft();
                        }
                    }
                    else
                        move = false;
                }
                else 
                    move = false;
            }
            if (move){
                x().set(getX() - 1);
            }
        }
        notifyObservers();   
    }

    public void moveRight() {
        updateSteps();
        if (getX() < dungeon.getWidth() - 1){
            boolean move = true;
            if (dungeon.checkBlockXY(getX()+1, getY())){
                if (dungeon.checkBoulderXY(getX()+1, getY())){
                    if (getX() < dungeon.getWidth() - 2){
                        if (dungeon.checkBlockXY(getX()+2, getY())){
                            move = false;
                        }
                        else{
                            Boulder moveBoulder = dungeon.getBoulderXY(getX()+1, getY());
                            moveBoulder.moveBoulderRight();
                        }
                    }
                    else
                        move = false;
                }
                else 
                    move = false;
            }
            if (move){
                x().set(getX() + 1);
            }
        }
        notifyObservers();   
    }
    public void teleport( int xp , int yp){
        updateSteps();
        x().set(xp);
        y().set(yp);
        notifyObservers();   
    }
    //prevMove is used to indicate the way the player is facing and make interact more realistic.
    public void interact(){
        if (dungeon.checkInteractableXY(getX(), getY()-1)){
            Entity interactEnt = dungeon.getInteractableXY(getX(), getY()-1);
            if (interactEnt instanceof Key){
                Key key = (Key) interactEnt;
                key.interact();
            }
            if (interactEnt instanceof Door){
                Door door = (Door) interactEnt;
                door.interact();
            }
            if (interactEnt instanceof Sword){
                Sword sword = (Sword) interactEnt;
                sword.interact();
            }
            if (interactEnt instanceof Treasure){
                Treasure treasure = (Treasure) interactEnt;
                treasure.interact();
            }
            if (interactEnt instanceof Potion){
                Potion potion = (Potion) interactEnt;
                potion.interact();
            }
            if (interactEnt instanceof Portal){
                Portal portal = (Portal) interactEnt;
                portal.interact();
            }
        }
        if (dungeon.checkInteractableXY(getX()-1, getY())){
            Entity interactEnt = dungeon.getInteractableXY(getX()-1, getY());
            if (interactEnt instanceof Key){
                Key key = (Key) interactEnt;
                key.interact();
            }
            if (interactEnt instanceof Door){
                Door door = (Door) interactEnt;
                door.interact();
            }
            if (interactEnt instanceof Sword){
                Sword sword = (Sword) interactEnt;
                sword.interact();
            }
            if (interactEnt instanceof Treasure){
                Treasure treasure = (Treasure) interactEnt;
                treasure.interact();
            }
            if (interactEnt instanceof Potion){
                Potion potion = (Potion) interactEnt;
                potion.interact();
            }
            if (interactEnt instanceof Portal){
                Portal portal = (Portal) interactEnt;
                portal.interact();
            }
        }
        if (dungeon.checkInteractableXY(getX()+1, getY())){
            Entity interactEnt = dungeon.getInteractableXY(getX()+1, getY());
            if (interactEnt instanceof Key){
                Key key = (Key) interactEnt;
                key.interact();
            }
            if (interactEnt instanceof Door){
                Door door = (Door) interactEnt;
                door.interact();
            }
            if (interactEnt instanceof Sword){
                Sword sword = (Sword) interactEnt;
                sword.interact();
            }
            if (interactEnt instanceof Treasure){
                Treasure treasure = (Treasure) interactEnt;
                treasure.interact();
            }
            if (interactEnt instanceof Potion){
                Potion potion = (Potion) interactEnt;
                potion.interact();
            }
            if (interactEnt instanceof Portal){
                Portal portal = (Portal) interactEnt;
                portal.interact();
            }
        }
        if (dungeon.checkInteractableXY(getX(), getY()+1)){
            Entity interactEnt = dungeon.getInteractableXY(getX(), getY()+1);
            if (interactEnt instanceof Key){
                Key key = (Key) interactEnt;
                key.interact();
            }
            if (interactEnt instanceof Door){
                Door door = (Door) interactEnt;
                door.interact();
            }
            if (interactEnt instanceof Sword){
                Sword sword = (Sword) interactEnt;
                sword.interact();
            }
            if (interactEnt instanceof Treasure){
                Treasure treasure = (Treasure) interactEnt;
                treasure.interact();
            }
            if (interactEnt instanceof Potion){
                Potion potion = (Potion) interactEnt;
                potion.interact();
            }
            if (interactEnt instanceof Portal){
                Portal portal = (Portal) interactEnt;
                portal.interact();
            }
        }
    }
    public void addInventory(Entity entity){
        inventory.addInventory(entity);
    }
    public void removeEntity(Entity entity){
        inventory.removeInventory(entity);
    }

    public Inventory getInventory(){
        return inventory;
    }

    public void updateSteps(){
        for (Entity entity : dungeon.getEntities()){
            if (entity instanceof Potion){
                attach((Observer) entity);
            }
            if (entity instanceof Enemy){
                attach((Observer) entity);
            }
        }
        for (Entity entity :this.inventory.getInventory()){
            if (entity instanceof Potion){
                attach((Observer)entity);
            }
        }

        for(Objectives o : this.dungeon.getObjectivesList()){
            attach((Observer)o);
            for(ObjectiveComposite oc : o.getObjectives()){
                attach((Observer)oc);
            }
        }
    }

    public BooleanProperty getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(BooleanProperty isALive) {
        this.isAlive = isALive;
    }
}
