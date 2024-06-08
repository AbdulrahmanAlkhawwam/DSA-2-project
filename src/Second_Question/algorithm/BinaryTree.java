package Second_Question.algorithm;

import java.util.Collections;

public class BinaryTree {

    // General tree => Binary tree
    public BinaryTreeNode ConvertGeneralToBinary(GeneralTreeNode root)
    {
        if (root == null)
            return null;

        BinaryTreeNode binaryTreeRoot = new BinaryTreeNode(root.getName());

        if (root.getChildren().size() > 0)
            binaryTreeRoot.setRight(ConvertGeneralToBinary(root.getChildren().get(root.getChildren().size() - 1)));

        BinaryTreeNode current = binaryTreeRoot.getRight();

        for (int i = root.getChildren().size() - 2; i >= 0; i--) {

            GeneralTreeNode child = root.getChildren().get(i);
            current.setLeft(ConvertGeneralToBinary(child));
            current = current.getLeft();
        }

        return binaryTreeRoot;
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
    public GeneralTreeNode ConvertBinaryToGeneral(BinaryTreeNode root)
    {
        if (root == null)
            return null;

        GeneralTreeNode generalRoot = new GeneralTreeNode(root.getName());

        BinaryTreeNode current = root.getRight();

        while (current != null) {
            generalRoot.getChildren().add(ConvertBinaryToGeneral(current));
            current = current.getLeft();
        }

        Collections.reverse(generalRoot.getChildren());

        return generalRoot;
    }

}
