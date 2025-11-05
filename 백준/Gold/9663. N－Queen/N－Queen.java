import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, answer;
    static boolean[] col, slash, bSlash; // col 세로 (가로는 row 로 뺵트래킹), slash 대각선, bSlash 역대각선
    // 대각선은 행과 열의 각각의 값이 같다는 특징을 이용해서 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new boolean[N+1];
        slash = new boolean[2*N+1];
        bSlash = new boolean[2*N];
        
        answer = 0;
        setQueen(1);
        System.out.println(answer);
    }
    
    static void setQueen(int row) {
        if(row > N) {
            answer++;
            return;
        }
        
        for(int c = 1; c <= N ; c++) {
            if(col[c] || slash[row + c] || bSlash[row - c + N]) continue;
            col[c] = slash[row+c] = bSlash[row-c+N] = true;
            setQueen(row+1);
            col[c] = slash[row+c] = bSlash[row-c+N] = false;
        }
    }
}