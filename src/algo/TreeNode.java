package algo;

public class TreeNode {
  public   Rectangle data;
  public   TreeNode left;
  public   TreeNode right;

    public TreeNode(String name,int width,int hight) {
        this.data=new Rectangle(name,width,hight);
        this.left=null;
        this.right=null;

    }



    public TreeNode() {
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }


    void addChild(TreeNode child, boolean isLeft) {
        if (isLeft) {
            this.left = child;
        } else {
            this.right = child;
        }
    }
    //    public String toString() {
//        return data.getName();
//    }
    private int index = 0;

    public TreeNode buildTree(Rectangle[] characters) {
        if (index >= characters.length) {

            return null;
        }

        Rectangle current = characters[index++];
        TreeNode node = new TreeNode(current.name,current.getWidth(),current.getHeight());

        // If the current node is '-' or '|', it is an internal node
        if (current.name.equals("-") || current.name.equals("|")) {

            node.left = buildTree(characters);  // build left subtree
            node.right = buildTree(characters); // build right subtree
        }


        return node;
    }

    // Helper method to print the tree in pre-order to verify correctness
    public void printTree(TreeNode node) {
        if (node != null) {

            System.out.print(node.data.toString() + " \n");
            printTree(node.left);
            printTree(node.right);
        }
    }
}

