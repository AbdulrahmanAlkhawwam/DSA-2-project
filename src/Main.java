import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BinaryTreeExample tree = new BinaryTreeExample();
        BinaryTreeNode root1 = tree.BuiltTree("(A|(B|C))-(D|(E–F))");
        tree.printInorder(root1);
        BinaryTreeExample.SaveInputText("(A|(B|C))-(D|(E–F))");
        BinaryTreeNode root = new BinaryTreeNode('-');
        root.left = new BinaryTreeNode('|');
        root.right = new BinaryTreeNode('|');
        root.left.left = new BinaryTreeNode('|');
        root.left.right = new BinaryTreeNode('a');
        root.right.left = new BinaryTreeNode('b');
        root.right.right = new BinaryTreeNode('d');
        System.out.println();
        BinaryTreeDrawer.drawBinaryTree(root, "binary_tree.png");
        String output= BinaryTreeExample.readFileAsString("src/Text");
        tree.printInorder(tree.BuiltTree(output));
    }
}