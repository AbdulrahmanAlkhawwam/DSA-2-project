package Form4and5;

import algo.TreeNode;
import algo.Rectangle;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Form45 {
    static int t=0;
    static ArrayList <Rectangle> pa=new ArrayList<>();

    public static void CreatTree() throws IOException {

        TreeNode n = new TreeNode("-", 0, 0);
        n.left = new TreeNode("|", 0, 0);
        n.left.left = new TreeNode("A", 30, 10);
        n.left.right = new TreeNode("|", 0, 0);
        n.left.right.left = new TreeNode("B", 10, 10);
        n.left.right.right = new TreeNode("C", 30, 10);
        n.right = new TreeNode("|", 0, 0);
        n.right.left = new TreeNode("D", 30, 50);
        n.right.right = new TreeNode("-", 0, 0);
        n.right.right.left = new TreeNode("E", 40, 30);
        n.right.right.right = new TreeNode("F", 40, 20);
        check(n);
        answer(pa);
        drawTree(n,"Form4and5/DrawRecForm4");

        // System.out.println(pa.toString());
//    for (int i=0;i<pa.size();i++){
//        System.out.println(pa.get(i));
//    }


    }
    public static void check(TreeNode root){
        if(root!=null){
            if(root.left==null &&root.right==null){
                pa.add(root.data);

            }

            check(root.left);
            check(root.right);
        }

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
            drawRectangle(canvas, x, y, node.data.getWidth(), node.data.getHeight(), node.data.getName() );
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
    //    public static boolean isAlpha ( char c){
//        return Character.isLetter(c);
//    }
//    public static void CreatRectanglePaper(){
//        ArrayList<Rectangle> papers = new ArrayList<>();
//        papers.add(new Rectangle("Paper1", 1, 2));
//        papers.add(new Rectangle("Paper2", 1, 4));
//        papers.add(new Rectangle("Paper3", 5, 6));
//        papers.add(new Rectangle("Paper1", 1, 2));
//        papers.add(new Rectangle("Paper2", 1, 4));
//        papers.add(new Rectangle("Paper3", 5, 6));
//        papers.add(new Rectangle("Paper1", 1, 2));
//        papers.add(new Rectangle("Paper2", 1, 4));
//        papers.add(new Rectangle("Paper3", 5, 6));
//        papers.add(new Rectangle("Paper1", 1, 2));
//        papers.add(new Rectangle("Paper2", 1, 4));
//        papers.add(new Rectangle("Paper3", 5, 6));
//        papers.add(new Rectangle("Paper1", 1, 2));
//        papers.add(new Rectangle("Paper2", 1, 4));
//        papers.add(new Rectangle("Paper3", 5, 6));
//        papers.add(new Rectangle("Paper1", 1, 2));
//        papers.add(new Rectangle("Paper2", 1, 4));
//        papers.add(new Rectangle("Paper3", 5, 6));
//        papers.add(new Rectangle("Paper1", 1, 2));
//        papers.add(new Rectangle("Paper2", 1, 4));
//        papers.add(new Rectangle("Paper3", 5, 6));
//        papers.add(new Rectangle("Paper1", 1, 2));
//        papers.add(new Rectangle("Paper2", 1, 4));
//        papers.add(new Rectangle("Paper3", 5, 6));
//     ArrayList<Rectangle> papers1=new ArrayList<>();
//        papers1.add(new Rectangle("Paper1", 20, 10));
//        papers1.add(new Rectangle("Paper2", 20, 10));
//        papers1.add(new Rectangle("Paper3", 30, 10));
//        papers1.add(new Rectangle("Paper4", 30, 50));
//        papers1.add(new Rectangle("Paper5", 40, 30));
//        papers1.add(new Rectangle("Paper6", 40, 20));
//
//        ArrayList<Rectangle> papers3 = new ArrayList<>();
//        papers3.add(new Rectangle("Paper1", 13, 5));
//        papers3.add(new Rectangle("Paper2", 3, 10));
//        papers3.add(new Rectangle("Paper3", 10, 10));
//
//        ArrayList<Rectangle> papers2 = new ArrayList<>();
//        papers2.add(new Rectangle("Paper1", 20, 10));
//        papers2.add(new Rectangle("Paper2", 23, 40));
//        papers2.add(new Rectangle("Paper3", 20, 50));
//        papers2.add(new Rectangle("Paper4", 33, 54));
//        papers2.add(new Rectangle("Paper5", 3, 36));
//        papers2.add(new Rectangle("Paper6", 4, 2));
//        //System.out.println(canFormRectangle(papers2));  // Output: false
//        //answer(papers2);
//
//
//    }
    public static void answer(ArrayList<Rectangle> papers1){
        MergeRectangle rectangularPaper = new MergeRectangle();
        rectangularPaper.canFormRectangleHight(papers1);
        if(rectangularPaper.currentHIGHTPapers.size()==1){
            System.out.println("Rectangle can be formed by H");
            t++;
        }
        else{
            rectangularPaper.canFormRectangleWidth(papers1);
            if(rectangularPaper.currentWidthPapers.size()==1){
                System.out.println("Rectangle can be formed by W");
                t++;
            }
            else{
                System.out.println("Rectangle cant be formed");
            }
        }
        if(t==1){
            rectangularPaper.canFormRectangleWidth(papers1);
            System.out.println("all Rectangle can be form is: "+rectangularPaper.count);

        }else{
            System.out.println("all Rectangle can be form is: "+rectangularPaper.count);
        }



    }
}
