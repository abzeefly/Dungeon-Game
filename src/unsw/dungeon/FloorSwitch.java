package unsw.dungeon;

public class FloorSwitch extends Entity implements Observer{
    private boolean activate;
    private Dungeon dungeon;
    public FloorSwitch(Dungeon dungeon,int x, int y) {
        super(x, y);
        super.setBlock(false);
        this.dungeon = dungeon;
        if (dungeon.checkBoulderXY(x, y)){
            activateSwitch();
        }
        else{
            deActivateSwitch();
        }
    }
    public void update(Subject obj){
        if (obj instanceof Boulder){
            update((Boulder) obj);
        }
    }
    public void update (Boulder boulder){
        if (dungeon.checkBoulderXY(getX(), getY())){
            activateSwitch();
            return;
        }
        else{
            if (boulder.getX() == getX() && boulder.getY() == getY()){
                activateSwitch();
                return;
            }
            else{
                deActivateSwitch();
            }
        }
    }
    public void activateSwitch(){
        activate = true;
    }
    public void deActivateSwitch(){
        activate = false;
    }
    public boolean getSwitchStatus(){
        return activate;
    }
}
