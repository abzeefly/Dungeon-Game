/**
 *
 */
package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;


/**
 * A dungeon in the interactive dungeon player.
 *
 * A dungeon can contain many entities, each occupy a square. More than one
 * entity can occupy the same square.
 *
 * @author Robert Clifton-Everest
 *
 */
public class Dungeon {

    private int width, height;
    private List<Entity> entities;
    private Player player;
    private int potion_size = 5;
    private final String[] keyCodes = {"abc123","def456", "ghi789"};
    private final String[] doorCodes = {"abc123","def456", "ghi789"};
    private int keyNum = 0;
    private int doorNum = 0;
    private ArrayList<Integer> availablePortalKey = new ArrayList<Integer>();
    private ArrayList<Integer> unusedPortalKey = new ArrayList<Integer>();
    private ArrayList<Objectives> objectivesList;


    public Dungeon(int width, int height) {
        this.width = width;
        this.height = height;
        this.entities = new ArrayList<>();
        this.player = null;
        this.unusedPortalKey.add(0);
        this.unusedPortalKey.add(1);
        this.unusedPortalKey.add(2);
        this.objectivesList = new ArrayList<Objectives>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void removeEntity(Entity entity){
        entities.remove(entity);
    }
    public boolean checkBlockXY(int x,int y){
        for (Entity entity : entities){
            if (entity.getX() == x && entity.getY() == y && entity.getBlock() == true){
                return true;
            }
        }
        return false;
    }
    public boolean checkBoulderXY(int x,int y){
        for (Entity entity : entities){
            if (entity.getX() == x && entity.getY() == y && entity instanceof Boulder){
                return true;
            }
        }
        return false;
    }
    public Boulder getBoulderXY(int x,int y){
        for (Entity entity : entities){
            if (entity.getX() == x && entity.getY() == y && entity instanceof Boulder){
                return (Boulder) entity;
            }
        }
        return null;
    }
    public Boolean checkInteractableXY(int x,int y){
        for (Entity entity : entities){
            if (entity.getX() == x && entity.getY() == y){
                if (entity instanceof Key || entity instanceof Door || entity instanceof Treasure 
                || entity instanceof Sword || entity instanceof Potion){
                    return true;
                }
            }
        }
        return false;
    }
    public Entity getInteractableXY(int x,int y){
        for (Entity entity : entities){
            if (entity.getX() == x && entity.getY() == y){
                if (entity instanceof Key || entity instanceof Door || entity instanceof Treasure 
                || entity instanceof Sword || entity instanceof Potion){
                    return entity;
                }
            }
        }
        return null;
    }
    public List<Entity> getEntities(){
        return entities;
    }

    public int getPotionSize() {
        return potion_size;
    }

    public String[] getKeyCodes() {
        return keyCodes;
    }

    public String[] getDoorCodes() {
        return doorCodes;
    }

    public int getKeyNum() {
        return keyNum;
    }

    public void setKeyNum(int keyNum) {
        this.keyNum = keyNum;
    }

    public int getDoorNum() {
        return doorNum;
    }

    public void setDoorNum(int doorNum) {
        this.doorNum = doorNum;
    }

    public ArrayList<Integer> getAvailablePortalKey() {
        return availablePortalKey;
    }

    public void setAvailablePortalKey(ArrayList<Integer> availablePortalKey) {
        this.availablePortalKey = availablePortalKey;
    }

    public ArrayList<Integer> getUnusedPortalKey() {
        return unusedPortalKey;
    }

    public void setUnusedPortalKey(ArrayList<Integer> unusedPortalKey) {
        this.unusedPortalKey = unusedPortalKey;
    }

    public ArrayList<Objectives> getObjectivesList() {
        return objectivesList;
    }

    public void setObjectivesList(ArrayList<Objectives> objectivesList) {
        this.objectivesList = objectivesList;
    }

    public void addObjectives(Objectives o){
        this.objectivesList.add(o);
    }



    
}
    