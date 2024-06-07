package Second_Question;

import Second_Question.Algorithm.*;
import Second_Question.GUITrees.*;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        try{
            GeneralTree GT=new GeneralTree();
            BinaryTree BT=new BinaryTree();
            //
            GT.CreateTree();
            String treeString = GT.TreeToString(GT.root);
            GT.Import(treeString);
            System.out.println("Level order traversal ");
            GT.printGeneralTree(GT.root ,0);
            Node Gr=GT.Export(GT.ConvertFileToList());

            BinaryTreeNode binaryTreeRoot = BT.ConvertGeneralToBinary(GT.root);
            BT.printBinaryTree(binaryTreeRoot, "");

            SwingUtilities.invokeLater(() -> {
                //Algorithm.Node root = GT.root;
                FrameGUI frame = new FrameGUI(Gr);
                frame.setVisible(true);
            });
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}