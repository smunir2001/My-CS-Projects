public class Node implements Comparable<Node> {
    private final int row;
    private final int col;
    private boolean isWall;
    private boolean isStart;
    private boolean isEnd;
    private boolean isVisited;
    private boolean isPath;
    private double gScore;
    private double hScore;
    private double fScore;
    private Node cameFrom;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
        isWall = false;
        isStart = false;
        isEnd = false;
        isVisited = false;
        isPath = false;
        gScore = Double.POSITIVE_INFINITY;
        hScore = Double.POSITIVE_INFINITY;
        fScore = Double.POSITIVE_INFINITY;
        cameFrom = null;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public boolean isWall() {
        return this.isWall;
    }

    public void setWall(boolean wall) {
        this.isWall = wall;
    }

    public boolean isStart() {
        return this.isStart;
    }

    public void setStart(boolean start) {
        this.isStart = start;
    }

    public boolean isEnd() {
        return this.isEnd;
    }

    public void setEnd(boolean end) {
        this.isEnd = end;
    }

    public boolean isVisited() {
        return this.isVisited;
    }

    public void setVisited(boolean visited) {
        this.isVisited = visited;
    }

    public boolean isPath() {
        return this.isPath;
    }

    public void setPath(boolean path) {
        this.isPath = path;
    }

    public double getGScore() {
        return this.gScore;
    }

    public void setGScore(double gScore) {
        this.gScore = gScore;
    }

    public double getHScore() {
        return this.hScore;
    }

    public void setHScore(double hScore) {
        this.hScore = hScore;
    }

    public double getFScore() {
        return this.fScore;
    }

    public void setFScore(double fScore) {
        this.fScore = fScore;
    }

    public Node getCameFrom() {
        return this.cameFrom;
    }

    public void setCameFrom(Node cameFrom) {
        this.cameFrom = cameFrom;
    }

    @Override
    public int compareTo(Node other) {
        return Double.compare(this.getFScore(), other.getFScore());
    }

    @Override
    public String toString() {
        return "[" + row + ", " + col + "]";
    }
}