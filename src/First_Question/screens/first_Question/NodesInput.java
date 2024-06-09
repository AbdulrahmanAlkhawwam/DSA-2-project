package First_Question.screens.first_Question;

import First_Question.algorithm.BinaryTree;
import First_Question.algorithm.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class NodesInput {
    private JFrame frame;
    private JTextField nameField;
    private JTextField widthField;
    private JTextField highField;
    private JTextArea outputArea;
    private List<Node> nodeList;

    public NodesInput() {
        nodeList = new ArrayList<>();
        frame = new JFrame("Binary Tree Node Input");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new BorderLayout(10, 10));

        // Input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        inputPanel.setBackground(new Color(224, 255, 255)); // لون الخلفية

        JLabel nameLabel = new JLabel("Node Name (single character):");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        inputPanel.add(nameLabel);
        nameField = new JTextField();
        inputPanel.add(nameField);

        JLabel widthLabel = new JLabel("Width (integer):");
        widthLabel.setFont(new Font("Arial", Font.BOLD, 14));
        inputPanel.add(widthLabel);
        widthField = new JTextField();
        inputPanel.add(widthField);

        JLabel highLabel = new JLabel("High (integer):");
        highLabel.setFont(new Font("Arial", Font.BOLD, 14));
        inputPanel.add(highLabel);
        highField = new JTextField();
        inputPanel.add(highField);

        JButton addButton = new JButton("Add Node");
        addButton.setFont(new Font("Arial", Font.BOLD, 14));
        addButton.setBackground(new Color(100, 149, 237));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.addActionListener(new AddNodeAction());
        inputPanel.add(addButton);

        JButton finishButton = new JButton("Finish");
        finishButton.setFont(new Font("Arial", Font.BOLD, 14));
        finishButton.setBackground(new Color(60, 179, 113));
        finishButton.setForeground(Color.WHITE);
        finishButton.setFocusPainted(false);
        finishButton.addActionListener(new FinishAction());
        inputPanel.add(finishButton);

        frame.add(inputPanel, BorderLayout.NORTH);

        // Output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        outputArea.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Nodes List"),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        JScrollPane scrollPane = new JScrollPane(outputArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private class AddNodeAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                char name = nameField.getText().charAt(0);
                int width = Integer.parseInt(widthField.getText());
                int high = Integer.parseInt(highField.getText());

                Node node = new Node(name, width, high);
                nodeList.add(node);

                outputArea.append(node.toString() + "\n");

                nameField.setText("");
                widthField.setText("");
                highField.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter valid data.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class FinishAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            String s= BinaryTree.answer((ArrayList<Node>) nodeList);
            new MessageDisplayGUI(s);





            // Perform any additional actions needed when finishing
        }
    }}
