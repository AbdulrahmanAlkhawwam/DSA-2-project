package First_Question.files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
}
