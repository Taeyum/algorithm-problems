import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] arr;
	static int[] dp;
	
	// 상태 -> 파라미터
	// 지금 내가 벌 수 있는 최대값은 얼마지?
	// recur(3) -> 3일에 벌 수 있는 최대값 
	// recur(4) -> 4일에 벌 수 있는 최대값
	static int recur(int day) {
		if (day > N) return -1000000000;
		
		if (day == N) {
			return 0;
		}
		
		if (dp[day] != -1) return dp[day];
		// 여기서부턴 다음에 할 일을 결정
		// 현재 날짜에 일을 하는 경우
		int a = recur(day + arr[day][0]) + arr[day][1];
		// 현재 날짜에 일을 안하는 경우
		int b = recur(day + 1);
		
		dp[day] = Integer.max(a, b);
		// 현재 벌수 있는 최대값 갱신
		return dp[day];
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new int[N];
		for (int i = 0; i < N; i++) {
			dp[i] = -1;
		}
		System.out.println(recur(0));
	}
}
