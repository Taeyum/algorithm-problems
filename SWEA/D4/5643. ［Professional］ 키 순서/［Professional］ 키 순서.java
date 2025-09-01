import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 정보들을 인접 행렬에 넣기
// 나보다 작은 애들 찾기
// 나보다 큰 애들 찾기
// 나보다 작은애 + 큰애 = 전체 학생 수 - 1 이면 내 키 번호를 알 수 있다?

public class Solution {
	static int N;
	static int M;
	static int[][] list;
	static int smallCnt;
	static int upperCnt;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1 ; test_case <= T ; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			cnt = 0;
			list = new int[N + 1][N + 1];
			
			for(int i = 0 ; i < M ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from][to] = 1;
			}
			
			for(int i = 1 ; i < N + 1; i++) {
				upperCnt = 0;
				smallCnt = 0;
				findUpper(i, new boolean[N+1]);
				findSmall(i, new boolean[N+1]);
				if(upperCnt + smallCnt == N - 1) {
					cnt++;
				}
			}
			System.out.println("#" + test_case + " " + cnt);
		}
	}
	
	static void findSmall(int to, boolean[] visited) {
		visited[to] = true;
		for(int i = 1 ; i < N + 1 ; i++) {
			if(!visited[i] && list[i][to] == 1) {
				findSmall(i, visited);
				smallCnt++;
			}
		}
		
	}
	
	static void findUpper(int from, boolean[] visited) {
		visited[from] = true;
		for(int i = 1 ; i < N + 1 ; i++) {
			if(!visited[i] && list[from][i] == 1) {
				findUpper(i, visited);
				upperCnt++;
			}
		}
	}
}
