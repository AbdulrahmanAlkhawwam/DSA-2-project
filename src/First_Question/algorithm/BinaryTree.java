package First_Question.algorithm;

import First_Question.files.writeFile;

import java.io.IOException;
import java.util.*;

public class BinaryTree {

    //////////////////////// fisrt order ////////////////////////

    public Map<Character, Node> nodes = new HashMap<>();
    public  ArrayList<Node> nodesList = new ArrayList<>();
    private String tree = null ;
    private Node root ;

    public BinaryTree (Node root){
        this.root = root ;
        String s = this.PrintTree(this.root);
        setTree(s);
        // here we make treeString is not null value
    }
    public BinaryTree (String tree){
        this.tree = tree;
        Node n = this.buildTree(this.tree);
        setRoot(n);
        // here we make node is not null value
    }
    public BinaryTree (){this.root = new Node() ;}

    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }
    public String getTree() {
        return tree;
    }
    public void setTree (String tree){
        this.tree = tree ;
    }

    //////////////////////// second order ////////////////////////

    public Node buildTree (String input){
        Node output = null ;
        // insert node in a map && fix input String from ( spaces & nodes details )
        input = fixInputString(input);
        // validate if a tree only has a root node
        if (input.length()==1){
            return new Node(input.charAt(0),null,null,0,0,true);
        }
        // shrink String => (left subTree String) {String} root name {char} (right subTree String) {String}
        if (input.length() >= 3) {
            String [] shrinkString = shrinkString(input);
            if (shrinkString[0].isEmpty()&&shrinkString[2].isEmpty()) {
                output = new Node(shrinkString[1].charAt(0),null,null);
            }
            else if (shrinkString[2].isEmpty())
                output = new Node(shrinkString[1].charAt(0),null,constructTree(shrinkString[0]));
            else if (shrinkString[0].isEmpty())
                output = new Node(shrinkString[1].charAt(0),constructTree(shrinkString[2]),null);
            else {
                output = new Node(shrinkString[1].charAt(0),constructTree(shrinkString[2]),constructTree(shrinkString[0]));
            }
        }
        return output;
    }
    public Node constructTree(String input) {
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
    public String PrintTree (Node node){
        if (node != null){
            String input =printInorder(node);
            for (int i=0 ;i<input.length();i++){
                if (Character.isLetter(input.charAt(i))){
                    String s = nodes.get(input.charAt(i)).printNode();
                    input  = input.substring(0,i-1)+ s + input.substring(i+2);
                    i+=s.length();
                }
            }
            if (input.charAt(0)=='('&&input.charAt(input.length()-1)==')'){
                return input.substring(1,input.length()-1);
            }
            else if (input.charAt(0)=='('){
                return input.substring(1);
            }
            else if (input.charAt(input.length()-1)==')'){
                return input.substring(0,input.length()-1);
            }
            return input ;
        }
        return "";
    }
    // this is part of PrintTree function
    public String printInorder(Node node) {
        String input ="";
        if (node != null) {
            input += "("+printInorder(node.getLeft());
            input += node.getName() ;
            input +=printInorder(node.getRight())+")";
        }
        input = input.replace("  "," ");
        return input ;
    }
    public String[] shrinkString (String input){
        String [] output = new String[3];
        for (int i=1 ;i<input.length()-1;i++){
            if (((input.charAt(i)== '|') && (input.charAt(i - 1) == ')') && (input.charAt(i + 1) == '(')) || ((input.charAt(i)== '-') && (input.charAt(i - 1) == ')') && (input.charAt(i + 1) == '('))){
                // get left subtree String
                output[0] = input.substring(0,i);
                // get right subtree String
                output[2] = input.substring(i+1);
                // get root node name
                output[1] = String.valueOf(input.charAt(i));
            }
        }
        return output ;
    }
    public String fixInputString (String input){
        input = deleteSpace (input);
        if (input.isEmpty()){
            return "" ;
        }
        fullNodesMap(input);
        input = clearString (input);
        input = validate(input);
        return input ;
    }
    public void fullNodesMap (String input) {
        for (int i = 0; i < input.length(); i++) {
            // if input.charAt (i) is Letter and is leave (not main node)
            if (Character.isLetter(input.charAt(i)) && (input.charAt(i) != '|' || input.charAt(i) != '-')) {
                // leave name
                char name = input.charAt(i);
                // value = [high,width] and between each high and width comma
                StringBuilder value = new StringBuilder();
                int comma = 0;
                // j = first char from value string in input string
                int j = i;
                // stop when you get len value string
                while (input.charAt(i) != ']') {
                    i++;
                    if (input.charAt(i) == ',')
                        comma = i - j;
                    value.append(input.charAt(i));
                }
                // high value
                String nodeWidth = value.substring(1, comma - 1);
                // width value
                String nodeHigh = value.substring(comma, value.length() - 1);
                // create a node and add it to nodes' map
                nodes.put(name, new Node(name, Integer.parseInt(nodeWidth), Integer.parseInt(nodeHigh)));
                nodesList.add(new Node(name, Integer.parseInt(nodeWidth), Integer.parseInt(nodeHigh)));
            }
        }
    }
    public String deleteSpace (String input ){
        return input.replace(" ","");
    }
    public String clearString (String input){
        for (int z : nodes.keySet()){
            input = input.substring(0,input.indexOf('['))+input.substring(input.indexOf(']')+1);
        }
        return input ;
    }
    public String validate (String input){
        if (input.length()!=1){
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
        }
        return input ;
    }


    //////////////////////// 3&4 across /////////////////////////

    public static int calculateTotalWidth(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.getName()=='|') {
            return calculateTotalWidth(node.getLeft()) + calculateTotalWidth(node.getRight());
        } else if (node.getName()=='-') {
            return Math.max(calculateTotalWidth(node.getLeft()), calculateTotalWidth(node.getRight()));
        } else {
            return node.getWidth();
        }
    }
    public static int calculateTotalHeight(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.getName()=='-') {
            return calculateTotalHeight(node.getLeft()) + calculateTotalHeight(node.getRight());
        } else if (node.getName()=='|') {
            return Math.max(calculateTotalHeight(node.getLeft()), calculateTotalHeight(node.getRight()));
        } else {
            return node.getHigh();
        }
    }
    public static void drawRectangle(char[][] canvas, int x, int y, int width, int height, char name  ) {
        for (int i = y; i < y + height; i++) {
            for (int j = x; j < x + width; j++) {
                if (i == y) {
                    canvas[i][j] = '-';
                }
                else if (j == x ) {
                    canvas[i][j] = '|';
                }
                else if((j==canvas[i].length-1))
                    canvas[i][j]='|';
                if (( i ==canvas.length-1))
                    canvas[i][j] = '-';
            }
            canvas[y +1][x + 1] = name;
        }
    }
    public static void drawNode(Node node, char[][] canvas, int x, int y, int totalWidth, int totalHeight) {
        if (node == null) {
            return;
        }
        if (node.getName()=='|') {
            int leftWidth = calculateTotalWidth(node.getLeft());
            drawNode(node.getLeft(), canvas, x, y, leftWidth, totalHeight);
            drawNode(node.getRight(), canvas, x + leftWidth, y, totalWidth - leftWidth, totalHeight);
        } else if (node.getName()=='-') {
            int leftHeight = calculateTotalHeight(node.getLeft());
            drawNode(node.getLeft(), canvas, x, y, totalWidth, leftHeight);
            drawNode(node.getRight(), canvas, x, y + leftHeight, totalWidth, totalHeight - leftHeight);
        } else {
            drawRectangle(canvas, x, y, node.getWidth(), node.getHigh(), node.getName() );
        }
    }
    public char[][] drawTree(Node root, String filePath) throws IOException {
        if (root == null) {
            return null;
        }
        int totalWidth = calculateTotalWidth(root);
        int totalHeight = calculateTotalHeight(root);
        char[][] canvas = new char[totalHeight][totalWidth];
        for (char[] row : canvas) {
            Arrays.fill(row, ' ');
        }
        drawNode(root, canvas, 0, 0, totalWidth, totalHeight);
        writeFile.writeToFile(canvas, filePath);
        return canvas;
    }

    //////////////////////// 4&5 order ////////////////////////
    public void creatTree(ArrayList<Node> nodesList, Node root, String filename) throws IOException {
        answer(nodesList);
        writeFile.drawTree(root,filename);
    }
    public static String answer(ArrayList<Node> nodes){
        String output = "";
        int t=0 ;
        MergeRectangle rectangularPaper = new MergeRectangle();
        rectangularPaper.canFormRectangleHight(nodes);
        rectangularPaper.canFormRectangleWidth(nodes);
        if (rectangularPaper.currentHIGHTPapers.size()==1&&rectangularPaper.currentWidthPapers.size()==1){
            output = "Rectangle can be formed\n";
        }
        else if(rectangularPaper.currentHIGHTPapers.size()==1){
            output = "Rectangle can be formed by H\n";
            t++;
        }
        else if(rectangularPaper.currentWidthPapers.size()==1){
            output = "Rectangle can be formed by W\n";
            t++;
        }
        else{
            output = "Rectangle cant be formed\n";
        }
        if(t==1){
            rectangularPaper.canFormRectangleWidth(nodes);
        }
        output +="all Rectangle can be form is: "+(rectangularPaper.count+nodes.size());
        return output ;
    }

}
