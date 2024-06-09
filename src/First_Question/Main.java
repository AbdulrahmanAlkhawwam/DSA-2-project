package First_Question;

import First_Question.algorithm.*;
import First_Question.files.readFile;
import First_Question.files.writeFile;
import First_Question.screens.first_Question.StringInputFrame;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            new StringInputFrame();
            // الطلب الاول
            System.out.println("First order .");
            // الطلب الثاني
            System.out.println("second order .");
            // Export tree (String => tree), choose the input which you want: -
            System.out.println("Export order .");
            String input1 = " ( A[200,100] | ( B[200,100] | C[300,100] ) ) - ( D[0,0] | ( E[0,030] - F[400,2000] ) ) ";
            String input2 = " ( A[20,10] | ( B[20,10] | C[30,10] ) ) - ( D[30,50] | ( E[40,30] - F[40,20] ) ) ";
            String input3 = " ( ( c[10,30] | ( D[20,10] - E[10,20] ) ) - B[30,40] ) | ( F[40,70] ) ";
            String input4 = " ( ( A [200,100] - B[200,100] ) | C[300,100] ) | ";
            String input5 = " | ";
            String input6 = "  ";
            String input7 = " ( ) | ";
            BinaryTree bt = new BinaryTree(input2);
            System.out.println(bt.getRoot());

            // Import tree (tree => String), chooses the tree from last order: -
            System.out.println("Import order .");
            String output = bt.PrintTree(bt.getRoot());
            System.out.println(output);

            // الطلب الثالث
            System.out.println("third order .");
            // Export tree (drawing => tree), chooses the input which you want from second order in export function [line-12]: -
            System.out.println("Export order .");
            Node node = readFile.readDrawing("src/First_Question/files/order3/import_3");
            System.out.println(bt.PrintTree(node));

            // Import tree (tree => drawing)
            System.out.println("Import order .");
            writeFile.drawTree(bt.getRoot(),"src/First_Question/files/order3/export_3");

            // الطلب الرابع و الخامس معا
            System.out.println("forth and Fifth order .");
            bt.creatTree(bt.nodesList,bt.getRoot(),"src/First_Question/files/order4/export_4");

            // الطلب السادس


            // convert a tree-bt1 (string to node)
            //bt1.PrintTree(bt1.getRoot());
            //System.out.println(bt1.getRoot());
            //System.out.println(bt1.getTree());
            //System.out.println(bt1.PrintTree(bt1.getRoot()));
            //Node output = bt1.getRoot();

            //Form3Exp Form3=new Form3Exp();
            //Form3.creatTree();
            //Form3Imp Form3I=new Form3Imp();


            //  // node build by user for test convert bt2
          //  GeneralTreeNode root = new GeneralTreeNode('-');
          //  root.setLeft(new GeneralTreeNode('|'));
          //  root.getLeft().setLeft(new GeneralTreeNode('A',20,10));
          //  root.getLeft().setRight(new GeneralTreeNode('|'));
          //  root.getLeft().getRight().setLeft(new GeneralTreeNode('B',20,10));
          //  root.getLeft().getRight().setRight(new GeneralTreeNode('C',30,10));
          //  root.setRight(new GeneralTreeNode('|'));
          //  root.getRight().setLeft(new GeneralTreeNode('D',30,50));
          //  root.getRight().setRight(new GeneralTreeNode('-'));
          //  root.getRight().getRight().setLeft(new GeneralTreeNode('E',40,30));
          //  root.getRight().getRight().setRight(new GeneralTreeNode('F',40,20));
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