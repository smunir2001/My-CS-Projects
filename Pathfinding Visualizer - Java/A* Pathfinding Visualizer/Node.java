public class Node {
    private int row;
    private int col;
    private int fScore;
    private int gScore;
    private int hScore;
    private boolean isObstacle;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
        this.fScore = Integer.MAX_VALUE;
        this.gScore = Integer.MAX_VALUE;
        this.hScore = 0;
        this.isObstacle = false;
    }
}