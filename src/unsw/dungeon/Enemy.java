package unsw.dungeon;


import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Enemy extends Entity implements Observer{
    private Dungeon dungeon;
    private BooleanProperty isALive;
    private BooleanProperty isPotionActivated;
    private boolean isStrat = false;
    public int enemymovex;
    public int enemymovey;
    
    public Enemy(Dungeon dungeon, int x, int y) {
        super(x, y);
        this.dungeon = dungeon;
        this.isALive = new SimpleBooleanProperty();
        this.isALive.set(true);
        this.dungeon.addEntity(this);
        this.isPotionActivated = new SimpleBooleanProperty();
        this.isPotionActivated.set(false);
        this.isStrat = false;
    }
    
    public void update(Subject obj){
        if (obj instanceof Potion){
            update((Potion) obj);
        }
        if (obj instanceof Player){
            update((Player) obj);
        }
    }

    public void update(Potion p){
        
        if(p.getIsActivated().get()){
            this.isPotionActivated.set(true);
        }
        else{
            this.isPotionActivated.set(false);
        }
    }

    public void update(Player p){
        isStrat = true;
        if(this.isPotionActivated.get()){
            Context strategy = new Context(new EnemyDefend());
            int move [] = strategy.executeStrategy(this, p);
            enemymovex = move[0];
            enemymovey = move[1];
            enemyMove(move[0], move[1]);
            
        }else{
            Context strategy = new Context(new EnemyAttack());
            int move [] = strategy.executeStrategy(this,p);
            enemymovex = move[0];
            enemymovey = move[1];
            enemyMove(move[0], move[1]);
        }
    }

    public void enemyMove(int x, int y){
        if(!dungeon.checkBoulderXY(x, y) && !dungeon.checkBlockXY(x, y) ){
            x().set(x);
            y().set(y);
        }else if(!dungeon.checkBoulderXY(x + 1, y) && !dungeon.checkBlockXY(x + 1, y) ) {
            x().set(getX()+1);
        }else if(!dungeon.checkBoulderXY(x, y + 1) && !dungeon.checkBlockXY(x, y + 1)){
            y().set(getY()+1);
        }
        checkLife();
    }

    public void checkLife(){
        Player p = dungeon.getPlayer();
        if(p.getX() == getX() && p.getY() == getY()){
            if(this.isPotionActivated.get()){
                this.isALive.set(false);
                dungeon.removeEntity(this);

            }else{
                p.getIsAlive().set(false);
                dungeon.removeEntity(p);
            }
        }
    }

    public BooleanProperty getIsALive() {
        return isALive;
    }

    public void setIsALive(BooleanProperty isALive) {
        this.isALive = isALive;
    }

    public BooleanProperty getIsPotionActivated() {
        return isPotionActivated;
    }

    public void setIsPotionActivated(BooleanProperty isPotionActivated) {
        this.isPotionActivated = isPotionActivated;
    }

    public boolean isStrat() {
        return isStrat;
    }

    public void setStrat(boolean isStrat) {
        this.isStrat = isStrat;
    }
    
    
}
