package Second_Question.GUITrees;
import Second_Question.Algorithm.*;

import javax.swing.*;
import java.awt.*;

public class TreeGUI extends JPanel {
    Node root;
    private final Color branchColor = Color.BLUE;
    private final Color nodeColor = Color.BLUE; // Adjusted node color

    TreeGUI(Node root) {
        this.root = root;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (root != null) {
            drawTree(g, root, 50, 50, getWidth() / 4, 50); // Adjusted initial coordinates
        }
    }

    private void drawTree(Graphics g, Node node, int x, int y, int xOffset, int yOffset) {
        g.setColor(nodeColor);
        g.fillOval(x - 15, y - 15, 30, 30); // Draw circle representing node
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(node.key), x - 5, y + 5); // Draw node key
        int childY = y + yOffset;
        int numChildren = node.children.size();
        for (int i = 0; i < numChildren; i++) {
            int childX = x + (i * xOffset); // Adjusted x coordinate
            g.setColor(branchColor);
            g.drawLine(x, y, childX, childY);
            drawTree(g, node.children.get(i), childX, childY, xOffset / numChildren, yOffset);
        }
    }

}


