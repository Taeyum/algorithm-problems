import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int C = Integer.parseInt(br.readLine());
            int[] price = {25, 10, 5, 1};
            int[] result = new int[4];
            for (int i = 0; i < 4; i++) {
                int cal = C / price[i];
                result[i] = cal;
                C -= price[i] * cal;
            }
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
