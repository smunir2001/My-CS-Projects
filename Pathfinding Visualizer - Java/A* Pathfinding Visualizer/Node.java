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

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setFScore(int fScore) {
        this.fScore = fScore;
    }

    public int getFScore() {
        return fScore;
    }

    public void setGScore(int gScore) {
        this.gScore = gScore;
    }

    public int getGScore() {
        return gScore;
    }

    public void setHScore(int hScore) {
        this.hScore = hScore;
    }

    public int getHScore() {
        return hScore;
    }

    public void setObstacle(boolean obstacle) {
        isObstacle = obstacle;
    }

    public boolean isObstacle() {
        return isObstacle;
    }

    public int getDistance(Node other) {
        int dx = Math.abs(this.row - other.getRow());
        int dy = Math.abs(this.col - other.getCol());
        return dx + dy;
    }

    @Override
    public String toString() {
        return "Node{row = " + row + ", col = " + col + "}";
    }
}