package unsw.dungeon;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Treasure extends Entity {
	private Dungeon dungeon;
	private BooleanProperty isEquipped;
    public Treasure(Dungeon dungeon, int x, int y) {
		super(x, y);
		super.setBlock(true);
		this.dungeon = dungeon;
		isEquipped = new SimpleBooleanProperty();
		isEquipped.set(false);
    }

    public void interact(){
		Player player = dungeon.getPlayer();
		player.addInventory(this);
		isEquipped.set(true);
		dungeon.removeEntity(this);
	}
}