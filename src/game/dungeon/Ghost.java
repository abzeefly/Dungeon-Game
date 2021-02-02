package unsw.dungeon;

public class Ghost extends Entity implements Observer {
    private Dungeon dungeon;
    public Ghost(Dungeon dungeon, int x, int y) {
        super(x, y);
        this.dungeon = dungeon;
        this.dungeon.addEntity(this);
    }
    public void update(Subject obj){
        if (obj instanceof Player){
            update((Player) obj);
        }
    }
    public void update(Player p){

        Context strategy = new Context(new GhostAttack());
        int move [] = strategy.executeStrategy(this,p);
        ghostMove(move[0], move[1]);
        checkLife(p);
    }
    public void ghostMove(int x, int y){
            x().set(x);
            y().set(y);
            
    }
    public void checkLife(Player p){
        if(p.getX() == getX() && p.getY() == getY()){
            p.getIsAlive().set(false);
            dungeon.removeEntity(p);
        }
    }
}
