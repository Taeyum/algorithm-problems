import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int result = 0;
            String str = br.readLine();
            char[] arr = str.toCharArray();
            int sum = 0;
            for (char c : arr) {
                if(c == 'O') {
                    sum++;
                    result += sum;
                } else {
                    sum = 0;
                }
            }
            System.out.println(result);
        }

    }
}
