import java.io.IOException;
import java.util.Arrays;


// assuming all numbers are integers and are within integer min/max bounds
public class Calculator {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("file not specified");
            return;
        }
        
        String path = args[0];
        System.out.println("file " + path);
        
        Integer result = calculateFromFile(path);
        
        if (result != null) {
            System.out.println("result: " + result);
        }
    }
    
    public static Integer calculateFromFile(String path) throws IOException {
        String[] words = FileUtil.read(path);
            
        if (words != null && words.length > 1) {
            int initialNumber = Integer.parseInt(words[words.length - 1]);
            return calculate(initialNumber, Arrays.copyOfRange(words, 0, words.length - 2));
        } else {
            return null;
        }
    }
    
    public static int calculate(int initialNumber, String[] words) {
        int result = initialNumber;
        
        String currentKeyword;
        int currentNumber;
    
        for (int i = 0; i < words.length; i += 2) {
            currentKeyword = words[i];
            currentNumber = Integer.parseInt(words[i + 1]);
            
            switch (currentKeyword) {
                case "add":
                    result += currentNumber;
                    break;
                case "subtract":
                    result -= currentNumber;
                    break;
                case "multiply":
                    result *= currentNumber;
                    break;
                case "divide":
                    if (currentNumber == 0) {
                        System.out.println("division by zero!");
                        return result;
                    }
                    
                    result /= currentNumber;
                    break;
            }
        }
        
        return result;
    }
}
