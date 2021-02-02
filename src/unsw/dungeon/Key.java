package unsw.dungeon;
import java.util.ArrayList;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Key extends Entity implements Subject{
    private ArrayList<Observer> listObservers = new ArrayList<Observer>();
    private String password;
    private BooleanProperty isUsed;
    private BooleanProperty isEquipped;
    private Dungeon dungeon;
    
    public Key(int x, int y, Dungeon dungeon) {
        super(x, y);
        super.setBlock(false);
        this.password = dungeon.getKeyCodes()[dungeon.getKeyNum()];
        dungeon.setKeyNum(dungeon.getKeyNum() + 1);
        isUsed = new SimpleBooleanProperty();
        isUsed.set(false);
        isEquipped = new SimpleBooleanProperty();
        isEquipped.set(false);
        this.dungeon = dungeon;
        this.dungeon.addEntity(this);
        updateLock();
        notifyObservers();;

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
    
    public void interact(){
        Player player = dungeon.getPlayer();
        if(((player.getX() == this.getX()+1) && (player.getY() == this.getY()))
        ||((player.getX() == this.getX()-1) && (player.getY() == this.getY()))
        ||((player.getY() == this.getY()+1) && (player.getX() == this.getX()))
        ||((player.getY() == this.getY()-1) && (player.getX() == this.getX()))
        ){
            updateLock();
            player.addInventory(this);
            isEquipped.set(true);
            dungeon.removeEntity(this);
            notifyObservers();
        }
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BooleanProperty getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(BooleanProperty isUsed) {
        this.isUsed = isUsed;
    }
    public void updateLock(){
        for (Entity entity : dungeon.getEntities()){
            if (entity instanceof Door){
                attach((Observer) entity);
            }
        }
    }
    
}


