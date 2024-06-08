package Second_Question.algorithm;

import java.util.Collections;

public class BinaryTree {
    public BinaryTreeNode ConvertGeneralToBinary(Node root)
    {
        if (root == null)
            return null;

        BinaryTreeNode binaryRoot = new BinaryTreeNode(root.key);

        if (root.children.size() > 0)
            binaryRoot.right = ConvertGeneralToBinary(root.children.get(root.children.size() - 1));

        BinaryTreeNode current = binaryRoot.right;

        for (int i = root.children.size() - 2; i >= 0; i--) {

            Node child = root.children.get(i);
            current.left = ConvertGeneralToBinary(child);
            current = current.left;
        }

        return binaryRoot;
    }

    public  void printBinaryTree(BinaryTreeNode root, String prefix)
    {
        if (root == null) {
            return;
        }

        System.out.println(prefix + root.key);

        printBinaryTree(root.right, prefix + "  ");

        printBinaryTree(root.left, prefix + "  ");
    }

    public Node ConvertBinaryToGeneral(BinaryTreeNode root)
    {
        if (root == null)
            return null;

        Node generalRoot = new Node(root.key);

        BinaryTreeNode current = root.right;

        while (current != null) {
            generalRoot.children.add(ConvertBinaryToGeneral(current));
            current = current.left;
        }

        Collections.reverse(generalRoot.children);

        return generalRoot;
    }

}
