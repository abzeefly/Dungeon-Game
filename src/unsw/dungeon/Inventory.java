package unsw.dungeon;


import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import java.util.ArrayList;

public class Inventory implements Observer {
    private ArrayList<Entity> inventory;
    private BooleanProperty Key;
    private IntegerProperty Sword;
    private Integer numSword;
    private IntegerProperty Potion;
    private Integer numPotion;
    private IntegerProperty treasure;
    private Integer numTreasure;

    public Inventory(){
        this.inventory = new ArrayList<Entity>();
        Key = new SimpleBooleanProperty();
        Key.set(false);
        numSword = 0;
        Sword = new SimpleIntegerProperty();
        Sword.set(numSword);
        numPotion = 0;
        Potion = new SimpleIntegerProperty();
        Potion.set(numPotion);
        numTreasure = 0;
        treasure = new SimpleIntegerProperty();
        treasure.setValue(numTreasure);
        this.inventory = new ArrayList<Entity>();
    }

    public void addInventory(Entity entity){
        inventory.add(entity);
        if (entity instanceof Key){
            Key.set(true);
        }
        if (entity instanceof Sword){
            Sword sword = (Sword) entity;
            numSword = sword.getNumAttack();
            Sword.set(numSword);
        }
        if (entity instanceof Potion){
            Potion potion = (Potion) entity;
            numPotion = potion.getSteps();
            Potion.set(numPotion);
        }
        if (entity instanceof Treasure){
            numTreasure++;
            treasure.set(numTreasure);
        }
    }
    public void removeInventory(Entity entity){
        this.inventory.remove(entity);
    }
    public IntegerProperty getInventoryTreasure(){
        return treasure;
    }
    public IntegerProperty getInventorySword(){
        return Sword;
    }
    public IntegerProperty getInventoryPotion(){
        return Potion;
    }
    public BooleanProperty getInventoryKey(){
        return Key;
    }
    public boolean contains(Object obj){
        return this.inventory.contains(obj);
    }

    public ArrayList<Entity> getInventory() {
        return this.inventory;
    }

    public void setInventory(ArrayList<Entity> inventory) {
        this.inventory = inventory;
    }

    public void update(Subject obj){
        if (obj instanceof Sword){
            update((Sword) obj);
        }
        if (obj instanceof Potion){
            update((Potion) obj);
        }
    }
    public void update(Sword sword){
        numSword = sword.getNumAttack();
        Sword.set(numSword);
    }
    public void update(Potion potion){
        numPotion = potion.getSteps();
        Potion.set(numPotion);
    }
}