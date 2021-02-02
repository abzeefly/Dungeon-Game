package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;

import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.File;

/**
 * A JavaFX controller for the dungeon.
 * @author Robert Clifton-Everest
 *
 */
public class DungeonController {

    @FXML
    private GridPane squares;

    @FXML
    private GridPane helpers;

    private List<ImageView> initialEntities;

    private Player player;

    private Dungeon dungeon;

    public DungeonController(Dungeon dungeon, List<ImageView> initialEntities) {
        this.dungeon = dungeon;
        this.player = dungeon.getPlayer();
        this.initialEntities = new ArrayList<>(initialEntities);
    }

    @FXML
    public void initialize() {
        Image ground = new Image((new File("images/dirt_0_new.png")).toURI().toString());

        // Add the ground first so it is below all other entities
        for (int x = 0; x < dungeon.getWidth(); x++) {
            for (int y = 0; y < dungeon.getHeight(); y++) {
                squares.add(new ImageView(ground), x, y);
            }
        }

        for (ImageView entity : initialEntities)
            squares.getChildren().add(entity);
        intializeHelpers();
    }

    @FXML
    public void handleKeyPress(KeyEvent event) {
        switch (event.getCode()) {
        case UP:
            player.moveUp();
            break;
        case DOWN:
            player.moveDown();
            break;
        case LEFT:
            player.moveLeft();
            break;
        case RIGHT:
            player.moveRight();
            break;
        case I:
            player.interact();
            break;
        default:
            break;
        }
    }

    @FXML
    public void intializeHelpers(){
        Text ControlIntro = new Text("Controls:");
        ControlIntro.setStyle("-fx-font-weight: bold;");
        helpers.add(ControlIntro,0,0);
        Text ControlMovement = new Text("Movement = Arrow Keys");
        helpers.add(ControlMovement,0,1);
        Text ControlInteract = new Text("Interact = I");
        helpers.add(ControlInteract,0,2);
        Text InventoryIntro = new Text("Inventory:");
        InventoryIntro.setStyle("-fx-font-weight: bold;");
        helpers.add(InventoryIntro,0,3);
        Text InventoryTreasure = new Text("Treasure: Number of collected Treasure");
        helpers.add(InventoryTreasure,0,4);
        Text NumTreasure = new Text();
        NumTreasure.textProperty().bindBidirectional(dungeon.getPlayer().getInventory().getInventoryTreasure(), new NumberStringConverter());
        helpers.add(NumTreasure,0,5);       
        Text InventorySword = new Text("Sword: Number of Attacks");
        helpers.add(InventorySword,0,6);
        Text NumSword = new Text();
        NumSword.textProperty().bindBidirectional(dungeon.getPlayer().getInventory().getInventorySword(), new NumberStringConverter());
        helpers.add(NumSword,0,7);     
        Text InventoryPotion = new Text("Potion: Number of Steps");
        helpers.add(InventoryPotion,0,8);
        Text NumPotion = new Text();
        NumPotion.textProperty().bindBidirectional(dungeon.getPlayer().getInventory().getInventoryPotion(), new NumberStringConverter());
        helpers.add(NumPotion,0,9);     
    }
}

