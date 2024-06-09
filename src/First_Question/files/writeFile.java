package First_Question.files;

import First_Question.algorithm.BinaryTree;
import First_Question.algorithm.Node;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class writeFile {
    public static boolean writeTreeString (String TreeString ,String filename){
        try{
            Path path = Paths.get(filename);
            Files.writeString(path,TreeString, StandardCharsets.UTF_8);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false ;
        }
        return true ;
    }
    public static void writeToFile ( char[][] canvas, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (char[] row : canvas) {
                writer.write(new String(row));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void drawTree(Node root, String filePath) throws IOException {
        if (root == null) {
            return;
        }
        int totalWidth = BinaryTree.calculateTotalWidth(root);
        int totalHeight = BinaryTree.calculateTotalHeight(root);
        char[][] canvas = new char[totalHeight][totalWidth];
        for (char[] row : canvas) {
            Arrays.fill(row, ' ');
        }
        BinaryTree.drawNode(root, canvas, 0, 0, totalWidth, totalHeight);
        writeToFile(canvas, filePath);
    }

}
