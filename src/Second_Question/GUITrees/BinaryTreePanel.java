package Second_Question.GUITrees;
import Second_Question.Algorithm.*;
import javax.swing.*;
import java.awt.*;

public class BinaryTreePanel extends JPanel {
    BinaryTreeNode root;
    private final Color branchColor = new Color(0, 0, 102); // Dark blue
    private final Color nodeColor = Color.GREEN;

    BinaryTreePanel(BinaryTreeNode root) {
        this.root = root;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (root != null) {
            drawBinaryTree(g, root, 50, 50, getWidth() / 4, 50); // Adjusted initial coordinates
        }
    }

    private void drawBinaryTree(Graphics g, BinaryTreeNode node, int x, int y, int xOffset, int yOffset) {
        g.setColor(nodeColor);
        g.fillOval(x - 15, y - 15, 30, 30); // Draw circle representing node
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(node.key), x - 5, y + 5); // Draw node key
        int childY = y + yOffset;
        if (node.left != null) {
            int childX = x - xOffset;
            g.setColor(branchColor);
            g.drawLine(x, y, childX, childY);
            drawBinaryTree(g, node.left, childX, childY, xOffset / 2, yOffset);
        }
        if (node.right != null) {
            int childX = x + xOffset;
            g.setColor(branchColor);
            g.drawLine(x, y, childX, childY);
            drawBinaryTree(g, node.right, childX, childY, xOffset / 2, yOffset);
        }
    }
}
