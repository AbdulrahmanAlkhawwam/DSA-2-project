import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BinaryTree {
    // var && attribute
    static Map<Character, Node> nodes = new HashMap<>();
    Node root ;

    // contracture
    BinaryTree (Node root){this.root = root ;}
    BinaryTree (){this.root = new Node() ;}

    // BuildTree => from String to BinaryTree ...
    //      1- adding nodes in a map
    //      2- fix string from trim
    //      3- analyze string to get two subtree
    //      4- link father node with sun node
    public void buildTree (String input){
        // insert node in a map && fix input String from ( spaces & nodes details )
        input = fixString(input);
        // shrink String => (left subTree String) {String} root name {char} (right subTree String) {String}
        String rightString = null ;
        String leftString  = null ;
        char rootName = 0;
        for (int i=1 ;i<input.length()-1;i++){
            if (((input.charAt(i)== '|') && (input.charAt(i - 1) == ')') && (input.charAt(i + 1) == '(')) || ((input.charAt(i)== '-') && (input.charAt(i - 1) == ')') && (input.charAt(i + 1) == '('))){
                // get left subtree String
                leftString = input.substring(0,i);
                // get right subtree String
                rightString = input.substring(i+1);
                // get root node name
                rootName = input.charAt(i);
            }
        }
        root = new Node(rootName,constructTree(leftString),constructTree(rightString));
        //root.name = rootName;
        //root.left = constructTree(leftString);
        //root.right = constructTree(rightString);
    }

    static public String fixString  (String input){
        // delete spaces
        input = input.replace(" ", "");
        // insert nodes in a map
        for (int i=0 ;i<input.length();i++){
            if (Character.isLetter(input.charAt(i))&&(input.charAt(i)!='|'||input.charAt(i)!='-')){
                String nodeHigh = input.substring(i+2,i+4);
                String nodeWidth = input.substring(i+5,i+7);
                BinaryTree.nodes.put(input.charAt(i),new Node(input.charAt(i),Integer.parseInt(nodeWidth),Integer.parseInt(nodeHigh)));
            }
        }
        // delete node's details from string
        for (int i=0;i<input.length();i++) {
            if (Character.isLetter(input.charAt(i))) {
                input = input.substring(0,i+1)+input.substring(i+8);
            }
        }
        return input ;
    }

    Node constructTree(String input) {
        if (input.length()<=3){
            return nodes.get(input.charAt(1));
        }
        Stack<Node> stack = new Stack<>();
        Node leftNode, rootNode, rightNode ;
        for (int i = 0; i < input .length(); i++) {
            char c = input .charAt(i);
            if (c == '(') {
                continue;
            } else if (c == ')') {
                rightNode = stack.pop();
                rootNode = stack.pop();
                leftNode = stack.pop();
                rootNode.left = leftNode;
                rootNode.right = rightNode;
                stack.push(rootNode);
            } else if (!(c == '|' || c == '-')) {
                leftNode = nodes.get(c);
                stack.push(leftNode);
            } else {
                nodes.put(c,new Node(c));
                stack.push(nodes.get(c));
            }
        }
        return stack.pop();
    }

    void printInorder(Node node) {
        if (node != null) {
            printInorder(node.left);
            System.out.print(node.name + " ");
            printInorder(node.right);
        }
    }

    String writeTree(Node node, String input ){
        if (node !=null) {
            input += writeTree(node.left,input);
            input += node.name ;
            input += writeTree(node.right,input);
        }
        return input;
    }
}
