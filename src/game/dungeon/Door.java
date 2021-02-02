package unsw.dungeon;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Door extends Entity implements Observer {
    private String password;
    private BooleanProperty isLocked;
    private Dungeon dungeon;
    private String lockPassword;
    public Door(int x, int y, Dungeon dungeon) {
        super(x, y);
        super.setBlock(true);
        this.dungeon = dungeon;
        this.dungeon.addEntity(this);
        this.password = dungeon.getDoorCodes()[dungeon.getDoorNum()];
        dungeon.setDoorNum(dungeon.getDoorNum() + 1);
        isLocked = new SimpleBooleanProperty();
        isLocked.set(true);
        this.lockPassword = "notapassword";
    }

    public void update(Subject obj){
        if (obj instanceof Key){
            update((Key) obj);
        }
    }

    public void update(Key key){
        this.lockPassword = key.getPassword();
        interact();
    }

    public void interact(){
        Player p = this.dungeon.getPlayer();
        if(p.getX() == getX() -1 && p.getY() == getY()){
            if(this.password.equals(this.lockPassword)){
                super.setBlock(false);
                isLocked.set(false);
            }
        }
    }

    public BooleanProperty getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(BooleanProperty isLocked) {
        this.isLocked = isLocked;
    }

}

