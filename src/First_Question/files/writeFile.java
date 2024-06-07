package First_Question.files;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class writeFile {
    public static boolean WriteTreeString (String TreeString ,String filename){
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
}
