import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;


public class CalculatorTest {
    private int initial;
    
    @Before
    public void setUp() {
        initial = 3;
    }
    
    @Test
    public void calculateNoInstructions() {
        int actual = Calculator.calculate(initial, new String[]{});
        assertEquals(initial, actual);
    }
    
    @Test
    public void calculateAddResult5() {
        int expected = 5;
        String[] words = {"add", "2"};
                
        int actual = Calculator.calculate(initial, words);
        assertEquals(expected, actual);
    }
    
    @Test
    public void calculateDivisionByZero() {
        String[] words = {"divide", "0"};
        
        int actual = Calculator.calculate(initial, words);
        assertEquals(initial, actual);
    }
    
    @Test
    public void calculateFromExampleFileResult5() throws IOException {
        String path = getClass().getResource("example.txt").getFile();
        
        int expected = 5;
        int actual = Calculator.calculateFromFile(path);
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void calculateFromFileIfFileEmptyResultNull() throws IOException {
        String path = getClass().getResource("empty.txt").getFile();
        
        Integer actual = Calculator.calculateFromFile(path);
        assertNull(actual);
    }
}