import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] alphaPosition = new int[26];

        Arrays.fill(alphaPosition, -1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = ch - 'a'; 

            if (alphaPosition[index] == -1) {
                alphaPosition[index] = i;
            }
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(alphaPosition[i] + " ");
        }
    }
}