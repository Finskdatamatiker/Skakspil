/**
 * @author Paivi
 * @since 18.9.19
 */
public class Felt {
    private int x;
    private int y;

    public Felt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public void setX(int x) { this.x = x;}
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    @Override
    public String toString() {
        return "Felt{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
