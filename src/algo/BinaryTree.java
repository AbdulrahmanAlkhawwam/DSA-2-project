package algo;

import java.sql.Array;
import java.util.*;

public class BinaryTree {
    // vars && attributes
    static public Map<Character, Node> nodes = new HashMap<>();
    private Node root ;

    // contractures
    public BinaryTree (Node root){this.root = root ;}
    public BinaryTree (){this.root = new Node() ;}

    // BuildTree => from String to BinaryTree ...
    //      1- adding nodes in a map
    //      2- fix string from trim
    //      3- analyze string to get two subtree
    //      4- link father node with sun node
    // input : String
    // output : root node
    public void buildTree (String input){
        // insert node in a map && fix input String from ( spaces & nodes details )
        input = fixInputString(input);
        // shrink String => (left subTree String) {String} root name {char} (right subTree String) {String}
        String rightString = null ;
        String leftString  = null ;
        char rootName = 0;
        if (input.isEmpty()){
            root = null ;
        }
        else {
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
            if (rightString.isEmpty()&&leftString.isEmpty())
                root = new Node(rootName,null,null);
            if (rightString.isEmpty())
                root = new Node(rootName,null,constructTree(leftString));
            else if (leftString.isEmpty())
                root = new Node(rootName,constructTree(rightString),null);
            root = new Node(rootName,constructTree(rightString),constructTree(leftString));
        }
    }

    // done
    // input  = "(A[20,10] | (B[20,10]|C[30,10])) - (D[30,50] | (E[40,30] - F[40,20]))"
    // output = "(A|(B|C))-(D|(E-F))"
    static public String fixInputString  (String input){
        // delete spaces
        input = input.replace(" ", "");
        // insert nodes in a map
        for (int i=0 ;i<input.length();i++){
            // if input.charAt (i) is Letter and is leave (not main node)
            if (Character.isLetter(input.charAt(i))&&(input.charAt(i)!='|'||input.charAt(i)!='-')){
                // leave name
                char name = input.charAt(i);
                // value = [high,width] and between each high and width comma
                StringBuilder value = new StringBuilder();
                int comma = 0 ;
                // j = first char from value string in input string
                int j = i ;
                // stop when you get len value string
                while (input.charAt(i)!=']'){
                    i++;
                    if (input.charAt(i)==',')
                        comma = i-j;
                    value.append(input.charAt(i));
                }
                // high value
                String nodeHigh = value.substring(1,comma-1);
                // width value
                String nodeWidth = value.substring(comma,value.length()-1);
                // create a node and add it to nodes' map
                BinaryTree.nodes.put(name,new Node(name,Integer.parseInt(nodeWidth),Integer.parseInt(nodeHigh)));
            }
        }
        // delete node's details from string
        for (int z : nodes.keySet())
            input = input.substring(0,input.indexOf('['))+input.substring(input.indexOf(']')+1);

        // validate if the tree one side or two
        // | () => () | ()
        if (input.charAt(0)!='(')
            input = "()" + input ;
        // () | => () | ()
        else if (input.charAt(input.length()-1)!=')')
            input = input + "()";
        // () or " " => null
        else if (input.equals("()")){
            return null ;
        }
        return input ;
    }

    // input  = "(A|(B|C))-(D|(E-F))"
    // output = "(A[20,10]|(B[20,10]|C[30,10]))-(D[30,50]|(E[40,30]-F[40,20]))"
    static public String fixOutputString (String input){
        for (int i=0 ;i<input.length();i++){
            if (Character.isLetter(input.charAt(i))&&(input.charAt(i)!='|'||input.charAt(i)!='-')){
                input = input.substring(0,i)+(nodes.get(input.charAt(i))).printNode()+input.substring(i+1);
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
                rootNode.setLeft(leftNode) ;
                rootNode.setRight(rightNode) ;
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

    public String printInorder(Node node) {
        String input ="";
        if (node != null) {
            input += " ( "+printInorder(node.getLeft());
            input += " "+ node.getName() + " ";
            input +=printInorder(node.getRight())+" ) ";
        }
        input = input.replace("  "," ");
        return input ;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
