import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String courseNumber = br.readLine();
        char firstChar = courseNumber.charAt(0);
        
        if (firstChar == 'F') {
            System.out.println("Foundation");
        } else if (firstChar == 'C') {
            System.out.println("Claves");
        } else if (firstChar == 'V') {
            System.out.println("Veritas");
        } else if (firstChar == 'E') {
            System.out.println("Exploration");
        }
    }
}