
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] C;   // C[house][] 
						// C[][color] 0 : red, 1 : green, 2 : blue
	static int[][] dp;
	
	static int recur(int idx, int prev) {
		if(idx == N) {
			return 0;
		}
		
		if (dp[idx][prev] != -1) return dp[idx][prev];
				
		int a = Integer.MAX_VALUE;
		for (int i = 1; i <= 3; i++) { // 1, 2, 3 빨/초/파
			if (prev != i) {
				a = Math.min(a, recur(idx + 1, i) + C[idx][i]);
			}
		}
		dp[idx][prev] = a;
		return dp[idx][prev];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = new int[N][4];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1 ; j <= 3 ; j++) {
				C[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[N][4];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 4; j++) {
				dp[i][j] = -1;
			}
		}
		
		System.out.println(recur(0, 0));
		
		
	}
}
