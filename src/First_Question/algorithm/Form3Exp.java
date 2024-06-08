package First_Question.algorithm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Form3Exp {
    public  void creatTree() throws IOException {
        Node n = new Node('|', 0, 0);
        n.setLeft(new Node('-', 0, 0));
        n.getLeft().setLeft(new Node('|', 0, 0));
        n.getLeft().setRight(new Node('B', 30, 40));
        n.getLeft().getLeft().setLeft(new Node('C', 10, 30));
        n.getLeft().getLeft().setRight(new Node('-', 0, 0));
        n.getLeft().getLeft().getRight().setLeft(new Node('D', 20, 10));
        n.getLeft().getLeft().getRight().setRight(new Node('E', 10, 20));
        n.setRight(new Node('F', 40, 70));
        drawTree(n, "Form3/inoutputRec/DrwoRectangleForm3");


    }
    public static void drawTree(Node root, String filePath) throws IOException {
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

    private static int calculateTotalWidth(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.getName()=='|') {
            return calculateTotalWidth(node.getLeft()) + calculateTotalWidth(node.getRight());
        } else if (node.getName()=='-') {
            return Math.max(calculateTotalWidth(node.getLeft()), calculateTotalWidth(node.getRight()));
        } else {
            return node.getWidth();
        }
    }

    private static int calculateTotalHeight(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.getName()=='-') {
            return calculateTotalHeight(node.getLeft()) + calculateTotalHeight(node.getRight());
        } else if (node.getName()=='|') {
            return Math.max(calculateTotalHeight(node.getLeft()), calculateTotalHeight(node.getRight()));
        } else {
            return node.getHigh();
        }
    }

    private static void drawNode(Node node, char[][] canvas, int x, int y, int totalWidth, int totalHeight) {
        if (node == null) {
            return;
        }
        if (node.getName()=='|') {
            int leftWidth = calculateTotalWidth(node.getLeft());
            drawNode(node.getLeft(), canvas, x, y, leftWidth, totalHeight);
            drawNode(node.getRight(), canvas, x + leftWidth, y, totalWidth - leftWidth, totalHeight);
        } else if (node.getName()=='-') {
            int leftHeight = calculateTotalHeight(node.getLeft());
            drawNode(node.getLeft(), canvas, x, y, totalWidth, leftHeight);
            drawNode(node.getRight(), canvas, x, y + leftHeight, totalWidth, totalHeight - leftHeight);
        } else {
            drawRectangle(canvas, x, y, node.getWidth(), node.getHigh(), node.getName() );
        }
    }

    private static void drawRectangle(char[][] canvas, int x, int y, int width, int height, char label  ) {


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
            canvas[y +1][x + 1] = label;
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
