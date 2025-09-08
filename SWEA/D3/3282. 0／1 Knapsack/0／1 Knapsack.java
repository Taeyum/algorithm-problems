import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N; // 물건의 갯수
	static int K; // 가방의 부피 (최대 부피)
	static int[] V; // 물건의 부피 정보들
	static int[] C; // 해당 물건의 가치들
	static int[][] dp;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1 ; test_case <= T ; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			max = 0;
			
			V = new int[N + 1];
			C = new int[N + 1];
			dp = new int[N + 1][K+1]; 
			
			for(int i = 1 ; i <= N ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				V[i] = Integer.parseInt(st.nextToken());
				C[i] = Integer.parseInt(st.nextToken());
			}
			
	
			for(int i = 1 ; i <= N ; i++) {
				for(int w = 1 ; w <= K ; w++) {
					if(V[i] > w) {
						dp[i][w] = dp[i-1][w];
					} else {
						dp[i][w] = Math.max(C[i] + dp[i-1][w-V[i]], dp[i-1][w]);
					}
				}
			}
			
			System.out.println("#"+test_case+" "+dp[N][K]);
			
		}
	}
	
	
}
