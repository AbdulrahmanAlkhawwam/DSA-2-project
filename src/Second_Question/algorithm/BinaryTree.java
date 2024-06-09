package Second_Question.algorithm;

import java.util.Collections;

public class BinaryTree {

    // General tree => Binary tree
    public BinaryTreeNode ConvertGeneralToBinary(GeneralTreeNode GRoot)
    {
        // stop condition
        if (GRoot == null){
            return null;
        }

        // convert root (General tree root) to root (binary tree root)
        BinaryTreeNode BRoot = new BinaryTreeNode(GRoot.getName());

        // when general root have children
        if (GRoot.getChildren().size() > 0){
            // recursion call for children to set them in the right node of Binary Root (node)
            BRoot.setRight(ConvertGeneralToBinary(GRoot.getChildren().get(GRoot.getChildren().size() - 1)));
        }

        // shift to next step by go to right node of binary Root (node)
        BinaryTreeNode current = BRoot.getRight();

        // put a brother of children in left side
        for (int i = GRoot.getChildren().size() - 2; i >= 0; i--) {
            GeneralTreeNode child = GRoot.getChildren().get(i);
            current.setLeft(ConvertGeneralToBinary(child));
            current = current.getLeft();
        }

        return BRoot;
    }

    // print a binary tree on console
    public  void printBinaryTree(BinaryTreeNode root, String prefix)
    {
        if (root == null) {
            return;
        }

        System.out.println(prefix + root.getName());

        printBinaryTree(root.getRight(), prefix + "  ");

        printBinaryTree(root.getLeft(), prefix + "  ");
    }

    // Binary tree => General tree
    public GeneralTreeNode ConvertBinaryToGeneral(BinaryTreeNode BRoot)
    {
        // stop condition
        if (BRoot == null)
            return null;

        // convert root (General tree root) to root (binary tree root)
        GeneralTreeNode GRoot = new GeneralTreeNode(BRoot.getName());

        // get the right node of BRoot to find the children of BRoot node
        BinaryTreeNode current = BRoot.getRight();

        // get the left nodes of the right node (find the children)
        while (current != null) {
            // recursion call to get the left nodes
            GRoot.getChildren().add(ConvertBinaryToGeneral(current));
            // shift to the next step
            current = current.getLeft();
        }

        Collections.reverse(GRoot.getChildren());

        return GRoot;
    }
}
