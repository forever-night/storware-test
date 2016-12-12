import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;


public class FileUtilTest {
    private String path;
    
    @Before
    public void setUp() {
        path = getClass().getResource("example.txt").getFile();
    }
    
    @Test
    public void readExampleFile() throws IOException {
        String[] expected = {"add", "0", "multiply", "1", "divide", "1", "subtract", "0", "apply", "5"};
        String[] actual = FileUtil.read(path);
        
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void readFileNotFound() throws IOException {
        String[] actual = FileUtil.read("wrong.txt");
        assertNull(actual);
    }
}