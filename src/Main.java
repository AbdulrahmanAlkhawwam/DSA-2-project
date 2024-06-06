
import static algo.BinaryTree.nodes;

public class Main {
    public static void main(String[] args) throws IOException {
        // Input probabilities :-
        // 1. " "           => null
        // 2. " - "         => root (-) / root.right = null / root.left = null
        // 3. " () - "      => root (-) / root.right = null / root.left ()
        // 4. " - () "      => root (-) / root.right ()     / root.left = null
        // 5. " () - () "   => root (-) / root.right ()     / root.left ()
        //String input = "(A[20,10] | (B[20,10]|C[30,10])) - (D[30,50] | (E[40,30] - F[40,20]))";
        //String input = "(A[200,100] | (B[200,100]|C[300,100])) - (D[0,0] | (E[0,030] - F[400,2000]))";
        //String input = "  ( ( A [200,100] - B[200,100] ) | C[300,100] ) | ";
        String input = "  ( ) | ";
        BinaryTree tree = new BinaryTree();
        System.out.println("input after fix : "+BinaryTree.fixInputString(input));
        tree.buildTree(input);
        System.out.println("root node : "+tree.getRoot());
        System.out.println(tree.printInorder(tree.getRoot()));
     //   writeFile.WriteTreeString(BinaryTree.fixOutputString("(A|(B|C))-(D|(E–F))"),"src/files/inputs_and_outputs/order_2/order2_write");
        BinaryTreeDrawer.drawBinaryTree(tree.getRoot(), "binary_tree.png");
        String output= readFile.readFileAsString("src/files/inputs_and_outputs/order_2/order2_read");
        System.out.println(output);
        
    }
}