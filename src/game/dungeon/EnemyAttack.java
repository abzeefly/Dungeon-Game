package unsw.dungeon;
public class EnemyAttack implements EnemyStrategy {
    @Override
    public int[] doOperation(Enemy e, Player p) {
        
        int ex = e.getX();
        int ey = e.getY();
        int px = p.getX();
        int py = p.getY();
        int moveX = 0;
        int moveY = 0;

        if(ex == px && ey == py){
            moveX = ex;
            moveY = ey;
            int[] move = {moveX, moveY};
            return move;
        }
        float distance = (float) Math.sqrt((ex - px) * (ex - px) + (ey - py) * (ey - py));
        for(int i = -1 ; i <= 1 ; i++){
            for(int j = -1 ; j <= 1 ; j++){
                if(Math.abs(i) + Math.abs(j) < 2){
                    int eX = ex + i;
                    int eY = ey + j;
                    float newDistance = (float) Math.sqrt(((eX - px) * (eX - px)) + ((eY - py) * (eY - py)));
                    if(newDistance < distance){
                        distance = newDistance;
                        moveX = eX;
                        moveY = eY;
                    }
                }
            }
        }
        int[] move = {moveX, moveY};
        return move;
    } 

    @Override
    public int[] doOperation(Ghost g, Player p){
        int move[] = {};
        return move;
    }

    
}