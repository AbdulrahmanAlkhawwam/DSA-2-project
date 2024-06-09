package First_Question.algorithm.order2;

import First_Question.algorithm.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class order2 {
    public static Map<Character, Node> nodes = new HashMap<>();
    public static ArrayList<Node> nodesList = new ArrayList<>();

    public static Node buildTree (String input){
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
    public static Node constructTree(String input) {
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
    public static String PrintTree (Node node){
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
    public static String printInorder(Node node) {
        String input ="";
        if (node != null) {
            input += "("+printInorder(node.getLeft());
            input += node.getName() ;
            input +=printInorder(node.getRight())+")";
        }
        input = input.replace("  "," ");
        return input ;
    }
    public static String[] shrinkString (String input){
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
    public static String fixInputString (String input){
        input = deleteSpace (input);
        if (input.isEmpty()){
            return "" ;
        }
        fullNodesMap(input);
        input = clearString (input);
        input = validate(input);
        return input ;
    }
    public static void fullNodesMap (String input) {
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
    public static String deleteSpace (String input ){
        return input.replace(" ","");
    }
    public static String clearString (String input){
        for (int z : nodes.keySet()){
            input = input.substring(0,input.indexOf('['))+input.substring(input.indexOf(']')+1);
        }
        return input ;
    }
    public static String validate (String input){
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

}
