import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            a %= 10; 
            
            int result = 1; 
            
            for (int r = 0; r < b; r++) {
                result = (result * a) % 10;
            }
            
            // 결과가 0이면 10번 컴퓨터, 아니면 그 결과값(1~9)이 컴퓨터 번호
            if (result == 0) {
                sb.append(10).append("\n");
            } else {
                sb.append(result).append("\n");
            }
        }
        
        System.out.print(sb);
    }
}