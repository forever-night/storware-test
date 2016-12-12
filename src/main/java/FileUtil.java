import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class FileUtil {
    private static final String SEPARATOR = "\\s";
    
    public static String[] read(String path) throws IOException {
        BufferedReader reader;
        
        try {
            reader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            return null;
        }
        
        String line;
        StringBuilder sb = new StringBuilder();
        
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");        // doesn't see new line, so add one
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            reader.close();
        }
    
        return sb.toString().split(SEPARATOR);
    }
}
