import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	static int max = Integer.MIN_VALUE;
	static int[][] dp;
	static int recur(int stair, int cnt) {
		if (stair >= N) return -10000000;
		if(stair == N - 1) {
			return arr[stair];
		}
		
		if(dp[stair][cnt] != -1) return dp[stair][cnt];
		
		int cur = 0;
		int a = Integer.MIN_VALUE;
		if(cnt != 2) {
			a = recur(stair + 1, cnt + 1) + arr[stair];
		}
		
		int b = recur(stair + 2, 1) + arr[stair];
		cur = Math.max(a, b);
		dp[stair][cnt] = cur;
		
		return dp[stair][cnt];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		dp = new int[N][3];
		
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				dp[i][j] = -1;
			}
		}
		
		int a = recur(0, 1);
		int b = recur(1, 1);
		System.out.println(Math.max(a, b));
	}
}
