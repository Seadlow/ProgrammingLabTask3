package Logic;

public class Figures {
    private int x;
    private int y;
    private final int diam = 35;

    Figures(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDiam() {
        return diam;
    }


    public void setY(int y) {
        this.y = y;
    }

    public void move(int direction) {
        y += direction;
    }
}