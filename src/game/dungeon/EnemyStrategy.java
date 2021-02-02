package unsw.dungeon;

public interface EnemyStrategy {
    public int[] doOperation(Enemy e, Player p);
    public int[] doOperation(Ghost g, Player p);
}