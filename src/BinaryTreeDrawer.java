import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BinaryTreeDrawer {

    private static final int NODE_RADIUS = 20;
    private static final int HORIZONTAL_GAP = 100;
    private static final int VERTICAL_GAP = 100;
    private static final int INITIAL_X = 500;
    private static final int INITIAL_Y = 50;


    /*BinaryTreeNode BuiltTree(){
        String postfix = "(A|(B|C))";
        BinaryTreeNode root = constructTree(postfix);

        String postfix2 = "(D|(E–F))";
        BinaryTreeNode root2 = constructTree(postfix2);



        BinaryTreeNode allroot=new BinaryTreeNode('-');
        allroot.left=root;
        allroot.right=root2;

        return allroot;

    }*/

    public static void drawBinaryTree(BinaryTreeNode root, String filename) {
        int treeHeight = calculateHeight(root);
        int treeWidth = (int) Math.pow(2, treeHeight) * (NODE_RADIUS + HORIZONTAL_GAP);

        BufferedImage image = new BufferedImage(treeWidth, treeHeight * VERTICAL_GAP, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, treeWidth, treeHeight * VERTICAL_GAP);
        g.setColor(Color.BLACK);
        drawTree(root, g, INITIAL_X, INITIAL_Y, treeWidth / 2);
        g.dispose();

        try {
            ImageIO.write(image, "png", new File(filename));
            System.out.println("Binary tree image saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void drawTree(BinaryTreeNode root, Graphics2D g, int x, int y, int xOffset) {
        if (root != null) {
            g.drawOval(x - NODE_RADIUS, y - NODE_RADIUS, 2 * NODE_RADIUS, 2 * NODE_RADIUS);
            g.drawString(String.valueOf(root.data), x - 5, y + 5);
            if (root.left != null) {
                int newX = x - xOffset / 2;
                int newY = y + VERTICAL_GAP;
                g.drawLine(x, y, newX, newY - NODE_RADIUS);
                drawTree(root.left, g, newX, newY, xOffset / 2);
            }
            if (root.right != null) {
                int newX = x + xOffset / 2;
                int newY = y + VERTICAL_GAP;
                g.drawLine(x, y, newX, newY - NODE_RADIUS);
                drawTree(root.right, g, newX, newY, xOffset / 2);
            }
        }
    }


//
//    void printInorder(BinaryTreeNode node) {
//        if (node == null)
//            return;
//
//        printInorder(node.left);
//        System.out.print(node.data + " ");
//        printInorder(node.right);
//    }


    private static int calculateHeight(BinaryTreeNode root) {
        if (root == null)
            return 0;
        else {
            int leftHeight = calculateHeight(root.left);
            int rightHeight = calculateHeight(root.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
