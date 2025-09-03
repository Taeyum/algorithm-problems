import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {
	static int N;
	static int M;
	static int limit;
	static int[][] map;
	static int[] tempArr;
	static int max;
	static int totalMax;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1 ; test_case <= T ; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			tempArr = new int[M];
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0  ; j < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			totalMax = 0;
			
			for(int r1 = 0 ; r1 < N ; r1++) {
				for(int c1 = 0 ; c1 <= N-M ; c1++) {
					int profit1 = getMaxProfit(r1, c1);
					
					for(int c2 = c1 + M ; c2 <= N - M ; c2++) {
						int profit2 = getMaxProfit(r1, c2);
						
						if(profit1 + profit2 > totalMax) {
							totalMax = profit1 + profit2;
						}
					}
					
					for(int r2 = r1 + 1 ; r2 < N ; r2++) {
						for(int c2 = 0 ; c2 <= N - M ; c2++) {
							int profit2 = getMaxProfit(r2, c2);
							
							if(profit1 + profit2 > totalMax) {
								totalMax = profit1 + profit2;
							}
						}
					}
				}
			}
		
		System.out.println("#"+test_case+ " " + totalMax);
		
		}
	}
	
	static void solve(int index, int currentSum, int currentProfit, int[] arr) {
		if(index == M) {
			if(currentProfit > max) {
				max = currentProfit;
			}
			return;
		}
		
		
		if(currentSum + arr[index] <= limit) {
			solve(index + 1, currentSum + arr[index] , currentProfit + arr[index] * arr[index], arr);
		}
		
		solve(index + 1, currentSum, currentProfit, arr);
	}
	
	static int getMaxProfit(int r, int c) {
		int[] curHoney = new int[M];
		
		for(int i = 0 ; i < M ; i++) {
			curHoney[i] = map[r][c + i];
		}
		
		max = 0;
		solve(0, 0, 0, curHoney);
		return max;
	}
}
	
