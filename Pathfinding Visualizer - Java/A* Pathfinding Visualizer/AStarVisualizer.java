import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.PriorityQueue;
public class AStarVisualizer extends JFrame {
    private final int ROWS = 50;
    private final int COLS = 50;
    private final int NODE_SIZE = 20;
    private final int GRID_SIZE = NODE_SIZE * ROWS;

    private final JPanel gridPanel;
    private final Grid grid;
    private Node startNode;
    private Node endNode;

    public AStarVisualizer() {
        /*
         * Initialize JFrame
         */
        setTitle("A* Algorithm Visualizer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        /*
         * Initialize JPanel
         */
        gridPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int row = 0; row < ROWS; row++) {
                    for (int col = 0; col < COLS; col++) {
                        Node node = grid.getNode(row, col);
                        g.setColor(getNodeColor(node));
                        g.fillRect(col * NODE_SIZE, row * NODE_SIZE, NODE_SIZE, NODE_SIZE);

                    }
                }
            }
        };
        gridPanel.setPreferredSize(new Dimension(GRID_SIZE, GRID_SIZE));
        gridPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = e.getY() / NODE_SIZE;
                int col = e.getX() / NODE_SIZE;
                Node node =  grid.getNode(row, col);
                if (SwingUtilities.isLeftMouseButton(e)) {
                    if (node != startNode && node != endNode) {
                        node.setWall(!node.isWall());
                        gridPanel.repaint();
                    }
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    if (node != startNode && node != endNode) {
                        if (startNode == null) {
                            startNode = node;
                            node.setStart(true);
                            gridPanel.repaint();
                        } else if (endNode == null) {
                            endNode = node;
                            node.setEnd(true);
                            gridPanel.repaint();
                        }
                    }
                }
            }
        });
        add(gridPanel, BorderLayout.CENTER);
        /*
         * Initialize grid
         */
        grid = new Grid(ROWS, COLS);
        /*
         * Set up buttons
         */
        JPanel buttonPanel = new JPanel();
        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> startPathFinding());
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> reset());
        buttonPanel.add(startButton);
        buttonPanel.add(resetButton);
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void startPathfinding() {
        if (startNode != null && endNode != null) {
            AStar aStar = new AStar(grid);
            PathfindingResult result = aStar.findPath(startNode, endNode);
            if (result.getPath() != null) {
                /*
                 * Animate the pathfinding process
                 */
                for (Node node : result.getVisitedNodes()) {
                    if (!node.isStart() && !node.isEnd()) {
                        node.setVisited(true);
                        gridPanel.repaint();
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                for (Node node : result.getPath()) {
                    if (!node.isStart() && !node.isEnd()) {
                        node.setPath(true);
                        gridPanel.repaint();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}