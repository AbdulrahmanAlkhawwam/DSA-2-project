package First_Question;

import First_Question.algo.BinaryTree;
import First_Question.algo.Node;
import First_Question.files.readFile;
import First_Question.files.writeFile;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            // convert a tree-bt1 (string to node)
            BinaryTree bt1 = new BinaryTree("() - ()");
            //BinaryTree bt1 = new BinaryTree("(A[20,10] | (B[20,10]|C[30,10])) - (D[30,50] | (E[40,30] - F[40,20]))");
            //System.out.println(bt1.getTree());
            //System.out.println(bt1.getRoot());

          //  // node build by user for test convert bt2
          //  Node root = new Node('-');
          //  root.setLeft(new Node('|'));
          //  root.getLeft().setLeft(new Node('A',20,10));
          //  root.getLeft().setRight(new Node('|'));
          //  root.getLeft().getRight().setLeft(new Node('B',20,10));
          //  root.getLeft().getRight().setRight(new Node('C',30,10));
          //  root.setRight(new Node('|'));
          //  root.getRight().setLeft(new Node('D',30,50));
          //  root.getRight().setRight(new Node('-'));
          //  root.getRight().getRight().setLeft(new Node('E',40,30));
          //  root.getRight().getRight().setRight(new Node('F',40,20));
//
          //  // convert a tree-bt2 (node to string)
          //  BinaryTree bt2 = new BinaryTree(root);
          //  System.out.println(bt2.nodes.toString());
          //  //System.out.println(bt2.getRoot());
          //  //System.out.println(bt2.getTreeString());
//
          //  // import tree to file
          //  writeFile.WriteTreeString(bt2.getTree(),"src/First_Question/files/inputs_and_outputs/order_2/order2_write");

            // expert tree from file

            // Input probabilities :-
            // 1. " "           => null
            // 2. " - "         => root (-) / root.right = null / root.left = null
            // 3. " () - "      => root (-) / root.right = null / root.left ()
            // 4. " - () "      => root (-) / root.right ()     / root.left = null
            // 5. " () - () "   => root (-) / root.right ()     / root.left ()
            //String input = "(A[20,10] | (B[20,10]|C[30,10])) - (D[30,50] | (E[40,30] - F[40,20]))";
            //String input = "(A[200,100] | (B[200,100]|C[300,100])) - (D[0,0] | (E[0,030] - F[400,2000]))";
            //String input = "  ( ( A [200,100] - B[200,100] ) | C[300,100] ) | ";
            //String input = "  ( ) | ";
            //BinaryTree tree = new BinaryTree(input);
            //System.out.println(tree.getTreeString());
            //we fix input in last time //System.out.println("input after fix : "+tree.fixInputString(input));
            //we buildTree in last time //tree.buildTree(input);
            //System.out.println("root node : "+tree.getRoot());
            //System.out.println(tree.getTreeString());
            //writeFile.WriteTreeString(tree.fixOutputString(input),"src/First_Question/files/inputs_and_outputs/order_2/order2_write");
            //BinaryTreeDrawer.drawBinaryTree(tree.getRoot(), "binary_tree.png");
            //String output= readFile.readFileAsString("src/First_Question/files/inputs_and_outputs/order_2/order2_read");
            //System.out.println(output);
            //tree.buildTree(output);
            //System.out.println(tree.getRoot());
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }

    }
}