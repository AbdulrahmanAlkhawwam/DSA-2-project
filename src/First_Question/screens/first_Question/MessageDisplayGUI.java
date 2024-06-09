package First_Question.screens.first_Question;

import First_Question.algorithm.Node;
import First_Question.files.readFile;
import First_Question.files.writeFile;
import First_Question.algorithm.order6.RectangleChar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MessageDisplayGUI {
    private JFrame frame;
    private JLabel messageLabel;
    private JButton addButton,switchButton1,switchButton,switchButton2;
   private JPanel buttonPanel,buttonPanel2,t;

    public MessageDisplayGUI(String message) {
        frame = new JFrame("Message Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout(10, 10));

        // Create panel to hold the message
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new GridLayout(1, 1, 10, 10));
        messagePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        messagePanel.setBackground(new Color(240, 248, 255));

        // Message label
        messageLabel = new JLabel(message, SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 18));
        messageLabel.setForeground(new Color(0, 51, 102));
        messageLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2, true));
        messageLabel.setOpaque(true);
        messageLabel.setBackground(new Color(224, 255, 255));
        messagePanel.add(messageLabel);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.setBackground(new Color(240, 248, 255));

        // Create button
        JButton doneButton = new JButton("الانتقال الى واجهة اخرى");
        doneButton.setFont(new Font("Arial", Font.BOLD, 16));
        doneButton.setForeground(Color.WHITE);
        doneButton.setBackground(new Color(0, 102, 204));
        doneButton.setFocusPainted(false);
        doneButton.setBorder(BorderFactory.createLineBorder(new Color(0, 51, 102), 2, true));



        buttonPanel.add(doneButton);

        frame.add(messagePanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                RectangleChar re=new RectangleChar();
                re.convertStingtochar(RectangleChar.getRec());
                try {
                    frame.dispose();
                    char [][] flip=re.flipRectangle(re.getRec2D());
                    writeFile.writeToFile(flip,"C:\\Users\\dell\\Desktop\\First_Question\\files\\order3\\Form^");
                    JFrame frame1 = new JFrame("Matrix Visualization");
                    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    RectangleDraw Rectangle=new RectangleDraw(flip);
                    frame1.add(Rectangle);
                    switchButton1 = new JButton("الانتقال إلى واجهة أخرى");
                    switchButton1.setPreferredSize(new Dimension(200, 50));
                    t = new JPanel();
                    t.setBackground(new Color(240, 240, 240)); // لون خلفية اللوحة
                    t.add(switchButton1);
                    frame1.add(t, BorderLayout.SOUTH);
                    frame1.pack();
                    frame1.setVisible(true);
                    switchButton1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            frame1.dispose();
                            Node node = readFile.readDrawing("C:\\Users\\dell\\Desktop\\First_Question\\files\\order3\\Form^");
                            JFrame frame2 = new JFrame("Binary Tree Visualization");
                            TreeVisualization treeVisualization = new TreeVisualization(node);
                            frame2.add(treeVisualization);
                            frame2.pack();
                            frame2.setVisible(true);

                        }});
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


            }});

    }
}
