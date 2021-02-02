package unsw.dungeon;

public class Exit extends Entity {
    private int x ;
    private int y ;

    public Exit(int x, int y) {
        super(x, y);
        super.setBlock(false);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    

}
