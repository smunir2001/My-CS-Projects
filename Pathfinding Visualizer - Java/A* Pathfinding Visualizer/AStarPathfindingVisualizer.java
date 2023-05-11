import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.w3c.dom.Node;
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

        JPanel gridPanel = new JPanel(new GridLayout(ROWS, COLS));
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                Node node = new Node(i, j);
                nodes[i][j] = node;
                JLabel label = new JLabel();
                label.setOpaque(true);
                label.setBackground(NODE_COLOR);
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        JLabel clickedLabel = (JLabel) e.getSource();
                        Node clickedNode = getNode(clickedLabel);
                        if (SwingUtilities.isLeftMouseButton(e)) {
                            if (startNode != null) {
                                setNodeColor(startNode, NODE_COLOR);
                            }
                            startNode = clickedNode;
                            setNodeColor(startNode, START_COLOR);
                        } else if (SwingUtilities.isRightMouseButton(e)) {
                            if (endNode != null) {
                                setNodeColor(endNode, NODE_COLOR);
                            }
                            endNode = clickedNode;
                            setNodeColor(endNode, END_COLOR);
                        }
                    }
                });
                labels[i][j] = label;
                gridPanel.add(label);
            }
        }
        add(gridPanel, BorderLayout.CENTER);
        
        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (startNode != null & endNode != null) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            AStarPathfindingVisualizer.this.findPath();
                        }
                    }).start();
                } else {
                    JOptionPane.showMessageDialog(AStarPathfindingVisualizer.this, "Please select a start and end node.");
                }
            }
        });
    }

    public List<Node> findPath(Node start, Node end) {
        PriorityQueue<Node> openSet = new PriorityQueue<>();
        Set<Node> closedSet = new HashSet<>();
        Map<Node, Node> cameFrom = new HashMap<>();
        Map<Node, Integer> gScore = new HashMap<>();
        gScore.put(start, 0);
        start.setFValue(heuristic(start, end));
        openSet.add(start);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();
            if (current.equals(end)) {
                return reconstructPath(cameFrom, end);
            }
            closedSet.add(current);
            for (Node neighbor : getNeighbors(current)) {
                if (closedSet.contains(neighbor)) {
                    continue;
                }
                int tentativeGScore = gScore.get(current) + neighbor.getCost();
                if (!openSet.contains(neighbor) || tentativeGScore < gScore.get(neighbor)) {
                    cameFrom.put(neighbor, current);
                    gScore.put(neighbor, tentativeGScore);
                    neighbor.setFValue(tentativeGScore + heuristic(neighbor, end));
                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    }
                }
            }
        }
        return null;
    }
}