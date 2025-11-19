import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); 
        int max = 0; 
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            int cur = 0;
            
            if (a == b && b == c) {
                cur = 10000 + a * 1000;
            } else if (a == b || a == c) {
                cur = 1000 + a * 100;
            } else if (b == c) {
                cur = 1000 + b * 100;
            } else {
                cur = Math.max(a, Math.max(b, c)) * 100;
            }
            
            if (cur > max) {
                max = cur;
            }
        }
        
        System.out.println(max);
    }
}