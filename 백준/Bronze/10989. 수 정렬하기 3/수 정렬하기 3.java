import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] counts = new int[10001];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            counts[num]++;
        }

        for (int i = 1; i < 10001; i++) {
            while (counts[i] > 0) {
                sb.append(i).append('\n');
                counts[i]--; 
            }
        }

        System.out.println(sb);
    }
}