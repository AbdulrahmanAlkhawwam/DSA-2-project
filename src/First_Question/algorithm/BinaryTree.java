package First_Question.algorithm;
import First_Question.algorithm.order2.order2;
import First_Question.files.writeFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BinaryTree {

    //////////////////////// fisrt order ////////////////////////

    private String tree = null ;
    private Node root ;

    public BinaryTree (Node root){
        this.root = root ;
        String s = order2.PrintTree(this.root);
        setTree(s);
        // here we make treeString is not null value
    }
    public BinaryTree (String tree){
        this.tree = tree;
        Node n = order2.buildTree(this.tree);
        setRoot(n);
        // here we make node is not null value
    }
    public BinaryTree (){this.root = new Node() ;}

   public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }
    public String getTree() {
        return tree;
    }
    public void setTree (String tree){
        this.tree = tree ;
    }

    //////////////////////// 3&4 across /////////////////////////

    public static int calculateTotalWidth(Node node) {
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
    public static int calculateTotalHeight(Node node) {
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
    public static void drawNode(Node node, char[][] canvas, int x, int y, int totalWidth, int totalHeight) {
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
    public static void drawRectangle(char[][] canvas, int x, int y, int width, int height, char name  ) {
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
            canvas[y +1][x + 1] = name;
        }
    }

    //////////////////////// forth order ////////////////////////


}
