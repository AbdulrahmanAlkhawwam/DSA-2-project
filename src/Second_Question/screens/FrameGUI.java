package Second_Question.screens;
import Second_Question.algorithm.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class FrameGUI extends JFrame {
     GeneralTreeNode root;
     GeneralTree GT=new GeneralTree();
     BinaryTree bT=new BinaryTree();
    private JButton convertButton;
    private JButton convertBackButton;
    private TreeGUI treePanel;
    private BinaryTreeNode binaryRoot;
    private BinaryTreePanel binaryTreePanel;
    public FrameGUI(GeneralTreeNode root){
        this.root = root;
        setTitle("General Tree and Binary Tree Visualization");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        treePanel = new TreeGUI(root);
        add(treePanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        convertButton = new JButton("Convert to Binary Tree");
        convertButton.setBackground(Color.CYAN); // Adjusted button color
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                binaryRoot = bT.ConvertGeneralToBinary(root);
                remove(treePanel);
                binaryTreePanel = new BinaryTreePanel(binaryRoot);
                add(binaryTreePanel, BorderLayout.CENTER);
                convertButton.setVisible(false); // Hide the button
                convertBackButton.setVisible(true); // Show the convert back button
                revalidate();
                repaint();
            }
        });
        buttonPanel.add(convertButton);

        convertBackButton = new JButton("Convert back to General Tree");
        convertBackButton.setBackground(Color.MAGENTA); // Adjusted button color
        convertBackButton.setVisible(false); // Initially hidden
        convertBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GeneralTreeNode rootl = bT.ConvertBinaryToGeneral(binaryRoot);
                remove(binaryTreePanel);
                treePanel = new TreeGUI(rootl);
                add(treePanel, BorderLayout.CENTER);
                convertBackButton.setVisible(false); // Hide the convert back button
                convertButton.setVisible(true); // Show the convert button
                revalidate();
                repaint();
            }
        });
        buttonPanel.add(convertBackButton);

        add(buttonPanel, BorderLayout.SOUTH);


    }
}
