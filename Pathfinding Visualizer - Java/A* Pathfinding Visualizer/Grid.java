public class Grid {
    private final Node[][] nodes;

    public Grid(int numRows, int numCols) {
        nodes = new Node[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                nodes[row][col] = new Node(row, col);
            }
        }
    }

    public Node getNode(int row, int col) {
        return this.nodes[row][col];
    }

    public Node[] getNeighbors(Node node) {
        int row = node.getRow();
        int col = node.getCol();
        Node[] neighbors = new Node[8];
        int count = 0;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (r == row && c == col) {
                    continue;
                }
                if (r < 0 || r >= nodes.length || c < 0 || c >= nodes[0].length) {
                    continue;
                }
                neighbors[count] = nodes[r][c];
                count++;
            }
        }
        return neighbors;
    }
}