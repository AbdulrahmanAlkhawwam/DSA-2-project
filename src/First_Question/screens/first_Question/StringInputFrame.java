/*
package First_Question.screens.first_Question;

import First_Question.algorithm.BinaryTree;
import First_Question.algorithm.Node;
import First_Question.files.readFile;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StringInputFrame extends JFrame {
    static BinaryTree BT;
    private JFrame frame;
    private JTextField inputField;
    private BinaryTree tree;
    private JButton addButton,switchButton1,switchButton,switchButton2;
    JPanel buttonPanel,buttonPanel2;


    public StringInputFrame() {
        tree = new BinaryTree();

        // إعداد الإطار
        frame = new JFrame("Input String");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());

        // اللوحة للإدخال والأزرار
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        panel.setBackground(new Color(245, 245, 245));

        // عنوان التطبيق
        JLabel titleLabel = new JLabel("Input tree String");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);

        // حقل الإدخال للنص
        JLabel label = new JLabel("Input String");
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));
        inputField.setBorder(BorderFactory.createCompoundBorder(
                inputField.getBorder(),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        panel.add(inputField);

        // زر لإضافة العقدة
        addButton = new JButton("Add");
        addButton.setFont(new Font("Arial", Font.BOLD, 16));
        addButton.setBackground(new Color(50, 205, 50));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        addButton.addActionListener(new AddButtonListener());
        panel.add(addButton);

        // إضافة المكونات إلى الإطار
        frame.add(panel, BorderLayout.CENTER);

        // جعل الإطار مرئيًا
        frame.setVisible(true);
    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = inputField.getText();

            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "please Input string");
            } else {
                frame.dispose();
                BT=new BinaryTree(input);
                Node root=BT.getRoot();
                JFrame frame = new JFrame("Binary Tree Visualization Form2");
                TreeVisualization treeVisualization = new TreeVisualization(root);
                frame.add(treeVisualization);
                 switchButton = new JButton("Move to another interface");
                switchButton.setPreferredSize(new Dimension(200, 50));
                 buttonPanel = new JPanel();
                buttonPanel.setBackground(new Color(240, 240, 240)); // لون خلفية اللوحة
                buttonPanel.add(switchButton);

                frame.add(buttonPanel, BorderLayout.SOUTH);
                frame.pack();
                frame.setVisible(true);
                switchButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        try {
                            char [][]Rec=BT.drawTree(BT.getRoot(),"src/First_Question/files/order3/export_3");

                            JFrame frame = new JFrame("Rectangle Visualization Form3EXP");
                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            RectangleDraw Rectangle=new RectangleDraw(Rec);
                            frame.add(Rectangle);
                            switchButton1 = new JButton("Move to another interface");
                            switchButton1.setPreferredSize(new Dimension(200, 50));
                            buttonPanel = new JPanel();
                            buttonPanel.setBackground(new Color(240, 240, 240)); // لون خلفية اللوحة
                            buttonPanel.add(switchButton1);
                            frame.add(buttonPanel, BorderLayout.SOUTH);
                            frame.pack();
                            frame.setVisible(true);
                            switchButton1.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    frame.dispose();
                                    Node node = readFile.readDrawing("src/First_Question/files/order3/import_3");
                                    JFrame frame = new JFrame("Binary Tree Visualization Form3Imp");
                                    TreeVisualization treeVisualization = new TreeVisualization(node);
                                    frame.add(treeVisualization);
                                    switchButton2 = new JButton("Move to another interface");
                                    switchButton2.setPreferredSize(new Dimension(200, 50));
                                    buttonPanel2 = new JPanel();
                                    buttonPanel2.setBackground(new Color(240, 240, 240)); // لون خلفية اللوحة
                                    buttonPanel2.add(switchButton2);
                                    frame.add(buttonPanel2, BorderLayout.SOUTH);
                                    frame.pack();
                                    frame.setVisible(true);
                                    switchButton2.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            frame.dispose();
                                            new NodesInput();

                                        }});

                                }  });


                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }

                    }
                });





            }
        }
    }
}*/
