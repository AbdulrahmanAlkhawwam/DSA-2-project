package First_Question.algorithm;

public class Node {
    // vars and attributes
    private char name ;
    private Node right ;
    private Node left ;
    private int width ;
    private int high ;
    public boolean isRoot ;

    // constructors
    public Node (char name , Node right , Node left , int width , int high, boolean isRoot){
        this.name = name ;
        this.right = right ;
        this.left = left ;
        this.width = width ;
        this.high = high ;
        this.isRoot = isRoot ;
    }
    public Node (char name , Node right , Node left ){
        this.name = name ;
        this.right = right ;
        this.left = left ;
        this.width = 0 ;
        this.high = 0 ;
    }
    public Node (char name , int width , int high, boolean isRoot){
        this.name = name ;
        this.width = width ;
        this.high = high ;
        this.isRoot = isRoot ;
    }
    public Node (char name , int width , int high){
        this.name = name ;
        this.width = width ;
        this.high = high ;
    }
    public Node (char name){
        this.name = name ;
        this.width = 0 ;
        this.high = 0 ;
        this.right = null ;
        this.left = null ;
    }
    public Node (){
        this.name = 'N' ;
        this.width = 0 ;
        this.high = 0 ;
        this.right = null ;
        this.left = null ;
        this.isRoot = false ;
    }

    // Getters and setters
    public char getName() {
        return name;
    }
    public void setName(char name) {
        this.name = name;
    }

    public Node getRight() {
        return right;
    }
    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    public int getHigh() {
        return high;
    }
    public void setHigh(int high) {
        this.high = high;
    }

    public String printNode (){
        return this.name +"["+this.width+","+this.high+"]";
    }

    @Override
    public String toString() {
        return "GeneralTreeNode{" +
                "name=" + name +
                ", right=" + right +
                ", left=" + left +
                ", width=" + width +
                ", high=" + high +
                '}';
    }

    // هبد طارق و الله اعلم
    void addChild(Node child, boolean isLeft) {
        if (isLeft) {
            this.left = child;
        } else {
            this.right = child;
        }
    }
    private int index = 0;
    public Node buildTree(Node[] characters) {
        if (index >= characters.length) {
            return null;
        }
        Node current = characters[index++];
        Node node = new Node(current.name,current.getWidth(),current.getHigh());
        // If the current node is '-' or '|', it is an internal node
        if (current.getName()=='-' || current.getName()=='|') {
            node.left = buildTree(characters);  // build left subtree
            node.right = buildTree(characters); // build right subtree
        }
        return node;
    }
    // Helper method to print the tree in pre-order to verify correctness
    public void printTree(Node node) {
        if (node != null) {

            System.out.print(node.getName() + " \n");
            printTree(node.left);
            printTree(node.right);
        }
    }
}

