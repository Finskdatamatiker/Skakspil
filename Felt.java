public class Felt {
    private int x;
    private int y;
    //boolean erTom; - dette kan erstattes med at tjekke, om feltet er instance af Tom

    public Felt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public void setX(int x) { this.x = x;}
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
}
