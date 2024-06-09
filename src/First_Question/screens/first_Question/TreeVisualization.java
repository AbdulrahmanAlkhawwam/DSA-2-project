package First_Question.screens.first_Question;


import First_Question.algorithm.Node;

import javax.swing.*;
import java.awt.*;

public class TreeVisualization extends JPanel {
    private Node root;

    public TreeVisualization(Node root) {
        this.root = root;
        setPreferredSize(new Dimension(1000, 800));
        setBackground(new Color(240, 240, 240)); // لون الخلفية
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (root != null) {
            drawTree(g, root, getWidth() / 2, 50, getWidth() / 4, 80);
        }
    }

    private void drawTree(Graphics g, Node node, int x, int y, int xOffset, int yOffset) {
        if (node != null) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            String nodeText = node.getName() + "[" + node.getWidth() + "," + node.getHigh() + "]";
            int nodeDiameter = 60;
            int nodeRadius = nodeDiameter / 2;

            // التدرجات اللونية
            Color startColor = new Color(173, 216, 230);
            Color endColor = new Color(0, 102, 204);
            GradientPaint gradient = new GradientPaint(x - nodeRadius, y - nodeRadius, startColor, x + nodeRadius, y + nodeRadius, endColor);
            g2.setPaint(gradient);
            g2.fillOval(x - nodeRadius, y - nodeRadius, nodeDiameter, nodeDiameter);

            // الحدود
            g2.setColor(new Color(0, 51, 102));
            g2.setStroke(new BasicStroke(3));
            g2.drawOval(x - nodeRadius, y - nodeRadius, nodeDiameter, nodeDiameter);

            // النص داخل العقدة
            g2.setColor(Color.WHITE);
            Font font = new Font("Arial", Font.BOLD, 12);
            g2.setFont(font);
            FontMetrics fm = g2.getFontMetrics();
            int textWidth = fm.stringWidth(nodeText);
            int textHeight = fm.getAscent();
            g2.drawString(nodeText, x - textWidth / 2, y + textHeight / 4);

            // رسم الشجرة الفرعية اليسرى
            if (node.getLeft() != null) {
                g2.setColor(new Color(0, 51, 102));
                g2.setStroke(new BasicStroke(2));
                g2.drawLine(x, y + nodeRadius, x - xOffset, y + yOffset - nodeRadius);
                drawTree(g2, node.getLeft(), x - xOffset, y + yOffset, xOffset / 2, yOffset);
            }

            // رسم الشجرة الفرعية اليمنى
            if (node.getRight() != null) {
                g2.setColor(new Color(0, 51, 102));
                g2.setStroke(new BasicStroke(2));
                g2.drawLine(x, y + nodeRadius, x + xOffset, y + yOffset - nodeRadius);
                drawTree(g2, node.getRight(), x + xOffset, y + yOffset, xOffset / 2, yOffset);
            }
        }
    }}