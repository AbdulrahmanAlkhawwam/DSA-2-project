import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Stack;

public class BinaryTreeExample {
    BinaryTreeNode root;
    BinaryTreeExample()
    {
        root = null;
    }

//    void printInorder(BinaryTreeNode node) {
//        if (node == null)
//            return;
//
//        printInorder(node.left);
//        System.out.print(node.data + " ");
//        printInorder(node.right);
//    }


    BinaryTreeNode constructTree(String expression) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode t, t1, t2;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '(') {
                continue;
            } else if (c == ')') {
                t1 = stack.pop();
                t2 = stack.pop();
                t = stack.pop();
                t2.left = t;
                t2.right = t1;
                stack.push(t2);
            } else if (!isOperator(c)) {
                t = new BinaryTreeNode(c);
                stack.push(t);
            } else {
                t = new BinaryTreeNode(c);
                stack.push(t);
            }
            System.out.println(stack.size());
        }

        return stack.pop();
    }

    void printInorder(BinaryTreeNode node) {
        if (node != null) {
            printInorder(node.left);
            System.out.print(node.data + " ");
            printInorder(node.right);
        }
    }

    boolean isOperator(char c) {
        return c == '|' || c == '-' ;
    }
    
    
    /*BinaryTreeNode BuiltTree(){
        String postfix = "(A|(B|C))";
        BinaryTreeNode root = constructTree(postfix);
        
        String postfix2 = "(D|(E–F))";
        BinaryTreeNode root2 = constructTree(postfix2);
        
        
        
        BinaryTreeNode allroot=new BinaryTreeNode('-');
        allroot.left=root;
        allroot.right=root2;
        
        return allroot;
        
    }*/

    static String shrinkTreeString (String input , char side){
        String lOutput = null ;
        String rOutput = null ;
        for (int i=1 ;i<input.length()-1;i++){
            if ((input.charAt(i) == '-') && (input.charAt(i - 1) == ')') && (input.charAt(i + 1) == '(')){
                lOutput = input.substring(0,i);
                rOutput = input.substring(i+1,input.length());
            }
        }
        if (side =='l')
            return lOutput;
        else if (side == 'r')
            return rOutput;
        else
            return null ;
    }

    BinaryTreeNode BuiltTree(String input){
        String postfix = shrinkTreeString(input,'l');
        BinaryTreeNode root = constructTree(postfix);

        String postfix2 = shrinkTreeString(input , 'r');
        BinaryTreeNode root2 = constructTree(postfix2);



        BinaryTreeNode allroot=new BinaryTreeNode('-');
        allroot.left=root;
        allroot.right=root2;

        return allroot;

    }

    public static boolean SaveInputText (String input){
        try{
            Path path = Paths.get("C:\\Users\\User\\Desktop\\Alog2\\src\\Text");
            Files.writeString(path,input, StandardCharsets.UTF_8);
        }
        catch (Exception e){
            return false ;
        }
        return true ;
    }

    public static String readFileAsString(String filename) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int character;
            while ((character = reader.read()) != -1) {
                stringBuilder.append((char) character);
            }
        }
        return stringBuilder.toString();
    }
}
   

    
    

//   BinaryTreeNode constructTree(String postfix) {
//    Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
//    BinaryTreeNode t, t1, t2;
//
//    for (int i = 0; i < postfix.length(); i++) {
//        if (isOperator(postfix.charAt(i))) {
//            t = new BinaryTreeNode(postfix.charAt(i));
//            stack.push(t);
//        } else {
//            t = new BinaryTreeNode(postfix.charAt(i));
//
//            if (!stack.isEmpty()) {
//                t1 = stack.pop();
//            } else {
//                // Handle error or throw exception for empty stack
//                // Add your logic here
//                return null;
//            }
//
//            if (!stack.isEmpty()) {
//                t2 = stack.pop();
//            } else {
//                // Handle error or throw exception for empty stack
//                // Add your logic here
//                return null;
//            }
//
//            t.right = t1;
//            t.left = t2;
//
//            stack.push(t);
//        }
//    }
//
//    if (!stack.isEmpty()) {
//        t = stack.peek();
//        stack.pop();
//        return t;
//    } else {
//        // Handle error or throw exception for empty stack
//        // Add your logic here
//        return null;
//    }
//   }
//   boolean isOperator(char c) {
//        if (c == '|') {
//            return true;
//        }
//        return false;
//    }
//
//   
//
//    void printInorder(BinaryTreeNode node) {
//        if (node == null)
//            return;
//
//        printInorder(node.left);
//        System.out.print(node.data + " ");
//        printInorder(node.right);
//    }

    

