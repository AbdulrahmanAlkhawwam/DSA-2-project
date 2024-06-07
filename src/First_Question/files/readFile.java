package First_Question.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readFile {
    public static String readFileAsString(String filename) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int character;
            while ((character = reader.read()) != -1) {
                stringBuilder.append((char) character);
            }
        }
        return stringBuilder.toString();
    }
}
