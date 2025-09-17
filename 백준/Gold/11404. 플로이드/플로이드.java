import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				if(i==j) {
					map[i][j] = 0;
				} else {
					map[i][j] = 10000000;
				}
			}
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			if(map[s][e] > v) {
				map[s][e] = v;
			}
		}
		
		for(int k = 1 ; k <= N ; k++) {  // 경유
			for(int s = 1 ; s <= N ; s++) {  // 시작
				for(int e = 1 ; e <= N ; e++) {  // 도착
					if(map[s][e] > map[s][k] + map[k][e]) {
						map[s][e] = map[s][k] + map[k][e];
					}
				}
			}
		}
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				if(map[i][j] == 10000000) {
					System.out.print(0 + " ");
				} else {
					System.out.print(map[i][j] + " ");
				}
			}
			System.out.println();
		}
		
	}
}
