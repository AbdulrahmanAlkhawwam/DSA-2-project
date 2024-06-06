package Form3;

import algo.TreeNode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Form3Exp {
    public  void creatTree() throws IOException {
        TreeNode n = new TreeNode("-", 0, 0);
        n.left = new TreeNode("|", 0, 0);
        n.left.left = new TreeNode("A", 20, 10);
        n.left.right = new TreeNode("|", 0, 0);
        n.left.right.left = new TreeNode("B", 20, 10);
        n.left.right.right = new TreeNode("C", 30, 10);
        n.right = new TreeNode("|", 0, 0);
        n.right.left = new TreeNode("D", 30, 50);
        n.right.right = new TreeNode("-", 0, 0);
        n.right.right.left = new TreeNode("E", 40, 30);
        n.right.right.right = new TreeNode("F", 40, 20);
        drawTree(n, "Form3/inoutputRec/DrwoRectangleForm3");


    }
    public static void drawTree(TreeNode root, String filePath) throws IOException {
        if (root == null) {
            return;
        }
        int totalWidth = calculateTotalWidth(root);
        int totalHeight = calculateTotalHeight(root);
        char[][] canvas = new char[totalHeight][totalWidth];
        for (char[] row : canvas) {
            Arrays.fill(row, ' ');
        }
        drawNode(root, canvas, 0, 0, totalWidth, totalHeight);
        writeToFile(canvas, filePath);
    }

    private static int calculateTotalWidth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.data.getName().equals("|")) {
            return calculateTotalWidth(node.left) + calculateTotalWidth(node.right);
        } else if (node.data.getName().equals("-")) {
            return Math.max(calculateTotalWidth(node.left), calculateTotalWidth(node.right));
        } else {
            return node.data.getWidth();
        }
    }

    private static int calculateTotalHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.data.getName().equals("-")) {
            return calculateTotalHeight(node.left) + calculateTotalHeight(node.right);
        } else if (node.data.getName().equals("|")) {
            return Math.max(calculateTotalHeight(node.left), calculateTotalHeight(node.right));
        } else {
            return node.data.getHeight();
        }
    }

    private static void drawNode(TreeNode node, char[][] canvas, int x, int y, int totalWidth, int totalHeight) {
        if (node == null) {
            return;
        }
        if (node.data.getName().equals("|")) {
            int leftWidth = calculateTotalWidth(node.left);
            drawNode(node.left, canvas, x, y, leftWidth, totalHeight);
            drawNode(node.right, canvas, x + leftWidth, y, totalWidth - leftWidth, totalHeight);
        } else if (node.data.getName().equals("-")) {
            int leftHeight = calculateTotalHeight(node.left);
            drawNode(node.left, canvas, x, y, totalWidth, leftHeight);
            drawNode(node.right, canvas, x, y + leftHeight, totalWidth, totalHeight - leftHeight);
        } else {
            drawRectangle(canvas, x, y, node.data.getWidth(), node.data.getHeight(), node.data.name );
        }
    }

    private static void drawRectangle(char[][] canvas, int x, int y, int width, int height, String label  ) {


        for (int i = y; i < y + height; i++) {
            for (int j = x; j < x + width; j++) {


                if (i == y) {
                    canvas[i][j] = '-';
                }
                else if (j == x ) {
                    canvas[i][j] = '|';

                }
                else if((j==canvas[i].length-1))
                    canvas[i][j]='|';
                if (( i ==canvas.length-1))
                    canvas[i][j] = '-';

            }

            canvas[y +1][x + 1] = label.charAt(0);
        }
    }
    private static void writeToFile ( char[][] canvas, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (char[] row : canvas) {
                writer.write(new String(row));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
