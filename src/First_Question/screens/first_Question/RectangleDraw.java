package First_Question.screens.first_Question;

import javax.swing.*;
import java.awt.*;

public class RectangleDraw extends JPanel {
    private char[][] matrix;
    private static final int CELL_SIZE = 10; // حجم الخلية
    private static final int PADDING = 2; // التباعد بين الخلايا
    private static final Color RECTANGLE_COLOR = new Color(240, 240, 240); // لون خلفية الخلية
    private static final Color TEXT_COLOR = new Color(70, 130, 180); // لون النص داخل الخلية
    private static final Font TEXT_FONT = new Font("Arial", Font.BOLD, 20); // الخط المستخدم للنص

    public RectangleDraw(char[][] matrix) {
        this.matrix = matrix;
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int preferredWidth = numCols * (CELL_SIZE + PADDING) + PADDING;
        int preferredHeight = numRows * (CELL_SIZE + PADDING) + PADDING;
        setPreferredSize(new Dimension(preferredWidth, preferredHeight));
        setBackground(Color.WHITE); // لون الخلفية
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int numRows = matrix.length;
        int numCols = matrix[0].length;

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                char cellChar = matrix[row][col];
                String cellText = String.valueOf(cellChar);

                // حساب موقع وأبعاد الخلية
                int x = PADDING + col * (CELL_SIZE + PADDING);
                int y = PADDING + row * (CELL_SIZE + PADDING);

                // رسم خلية بلون خلفية الخلية
                g.setColor(RECTANGLE_COLOR);
                g.fillRect(x, y, CELL_SIZE, CELL_SIZE);

                // رسم النص داخل الخلية
                g.setColor(TEXT_COLOR);
                g.setFont(TEXT_FONT);
                FontMetrics fm = g.getFontMetrics();
                int textWidth = fm.stringWidth(cellText);
                int textHeight = fm.getAscent();
                g.drawString(cellText, x + (CELL_SIZE - textWidth) / 2, y + (CELL_SIZE - textHeight) / 2);
            }
        }
    }}