package unsw.dungeon;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * Loads a dungeon from a .json file.
 *
 * By extending this class, a subclass can hook into entity creation. This is
 * useful for creating UI elements with corresponding entities.
 *
 * @author Robert Clifton-Everest
 *
 */
public abstract class DungeonLoader {

    private JSONObject json;

    public DungeonLoader(String filename) throws FileNotFoundException {
        json = new JSONObject(new JSONTokener(new FileReader("dungeons/" + filename)));
    }

    /**
     * Parses the JSON to create a dungeon.
     * @return
     */
    public Dungeon load() {
        int width = json.getInt("width");
        int height = json.getInt("height");

        Dungeon dungeon = new Dungeon(width, height);

        JSONArray jsonEntities = json.getJSONArray("entities");

        JSONObject goalCond = json.getJSONObject("goal-conditions");

        for (int i = 0; i < jsonEntities.length(); i++) {
            loadEntity(dungeon, jsonEntities.getJSONObject(i));
        }
        Objectives obs = new Objectives();
        loadObjective(dungeon,obs, goalCond);
        return dungeon;
    }

    private void loadEntity(Dungeon dungeon, JSONObject json) {
        String type = json.getString("type");
        int x = json.getInt("x");
        int y = json.getInt("y");


        Entity entity = null;
        switch (type) {
        case "player":
            Player player = new Player(dungeon, x, y);
            dungeon.setPlayer(player);
            onLoad(player);
            entity = player;
            break;
        case "wall":
            Wall wall = new Wall(x, y);
            onLoad(wall);
            entity = wall;
            break;
        case "portal":
            Portal portal = new Portal(dungeon,x,y);
            onLoad(portal);
            entity = portal;
            break;
        case "sword":
            Sword sword = new Sword(dungeon,x, y);
            onLoad(sword);
            entity = sword;
            break;
        case "enemy":
            Enemy enemy = new Enemy(dungeon, x, y);
            onLoad(enemy);
            entity = enemy;
            break;
        case "potion":
            Potion potion = new Potion(dungeon,x, y);
            onLoad(potion);
            entity = potion;
            break;

        // TODO Handle other possible entities
        case "exit":
            Exit exit = new Exit(x,y);
            onLoad(exit);
            entity = exit;
            break;
        case "boulder":
            Boulder boulder = new Boulder(dungeon,x, y);
            onLoad(boulder);
            entity = boulder;
            break;
        case "switch":
            FloorSwitch fSwitch = new FloorSwitch(dungeon, x, y);
            onLoad(fSwitch);
            entity = fSwitch;
            break;
        case "treasure":
            Treasure treasure = new Treasure(dungeon, x, y);
            onLoad(treasure);
            entity = treasure;
            break;

        case "key":
            Key key = new Key(x, y, dungeon);
            onLoad(key);
            entity = key;
            break;
        case "door":
            Door door = new Door(x, y, dungeon);
            onLoad(door);
            entity = door;
            break;
        case "ghost":
            Ghost ghost = new Ghost(dungeon, x, y);
            onLoad(ghost);
            entity = ghost;
            break;

        }
        dungeon.addEntity(entity);

    }

    public void loadObjective(Dungeon dungeon,Objectives obs, JSONObject json){
        //and -> add to objective
        // or -> create new objective
        String goal =json.getString("goal");
        JSONArray subgoal = json.getJSONArray("subgoal");
        
        switch(goal){
            case "exit":
            ObjectiveExit oe = new ObjectiveExit(dungeon);
            obs.addObjective(oe);
            dungeon.addObjectives(obs);

            case "enemies":
            ObjectiveEnemy oen = new ObjectiveEnemy(dungeon);
            obs.addObjective(oen);
            dungeon.addObjectives(obs);

            case "boulders":
            ObjectiveFloorSwitch ofs = new ObjectiveFloorSwitch(dungeon);
            obs.addObjective(ofs);
            dungeon.addObjectives(obs);

            case "treasure":
            ObjectiveTreasure ot = new ObjectiveTreasure(dungeon);
            obs.addObjective(ot);
            dungeon.addObjectives(obs);
            
            case "AND":
            loadSubObj(dungeon,obs, subgoal);

            case "OR":
            Objectives obs1 = new Objectives();
            dungeon.addObjectives(obs1);
            loadSubObj(dungeon,obs1, subgoal);
        }
        
    }
    public void loadSubObj(Dungeon dungeon, Objectives obs, JSONArray subgoal){
        
        for (int i = 0; i < subgoal.length(); i++) {
            loadObjective(dungeon, obs, subgoal.getJSONObject(i));
        }
           
    }


    public abstract void onLoad(Entity player);
    public abstract void onLoad(Wall wall);
    public abstract void onLoad(Sword sword);
    public abstract void onLoad(Enemy enemy);
    public abstract void onLoad(Potion potion);
    public abstract void onLoad(Portal portal);
    public abstract void onLoad(Exit exit);
    public abstract void onLoad(Boulder boulder);
    public abstract void onLoad(FloorSwitch fswitch);
    public abstract void onLoad(Treasure treasure);
    public abstract void onLoad(Key key);
    public abstract void onLoad(Door door);
    public abstract void onLoad(Ghost ghost);





    // TODO Create additional abstract methods for the other entities


}
