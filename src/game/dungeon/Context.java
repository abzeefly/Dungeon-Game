package unsw.dungeon;

public class Context {
    private EnemyStrategy strategy;

    public Context(EnemyStrategy strategy){
        this.strategy = strategy;
    }
    
    public int[] executeStrategy(Enemy e, Player p){
        return strategy.doOperation(e,p);
    }
    
    public int[] executeStrategy(Ghost g, Player p){
        return strategy.doOperation(g,p);
    }
    
}