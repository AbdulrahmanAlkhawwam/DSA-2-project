package Second_Question.algorithm;


import First_Question.algorithm.BinaryTree;

public class BinaryTreeNode {
    private char name;
    private BinaryTreeNode left,right;

    public BinaryTreeNode(char name)
    {
        this.name = name;
        left = null;
        right = null;
    }
    public BinaryTreeNode (char name , BinaryTreeNode left , BinaryTreeNode right){
        this.name = name ;
        this.left = left ;
        this.right = right;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
}
