import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
public class AStarPathfindingVisualizer extends JFrame {
    private static final int ROWS = 20;
    private static final int COLS = 20;
    private static final Color NODE_COLOR = Color.WHITE;
    private static final Color START_COLOR = Color.GREEN;
    private static final Color END_COLOR = Color.RED;
    private static final Color PATH_COLOR = Color.YELLOW;

    private Node[][] nodes = new Node[ROWS][COLS];
    private JLabel[][] labels = new JLabel[ROWS][COLS];
    private Node startNode;
    private Node endNode;

    public AStarPathfindingVisualizer() {
        setTitle("A* Pathfinding Visualizer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }
}