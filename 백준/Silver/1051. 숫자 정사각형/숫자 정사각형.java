import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int maxLength;
	static int squareLength;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		maxLength = 0;
		
		for(int i = 0 ; i < N ; i++) {
			String[] str = br.readLine().split("");
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		
		square(0,0);
		
		System.out.println(maxLength * maxLength);
	}
	
	static void square(int r, int c) {
		
		if(r >= N) {
			return;
		}
		
		for(int length = 0; r + length < N && c + length < M ; length++) {
			if(check(r,c,length)) {
				maxLength = Math.max(maxLength, length + 1);
			}
		}
		
		
		if(c+1 < M) {
			square(r, c+1);
		}else {
			square(r+1, 0);
		}
	}
	
	static boolean check(int r, int c, int length) {
		if(map[r][c] == map[r][c+length] && 
				map[r][c] == map[r+length][c] && 
					map[r][c] == map[r+length][c+length]) {
			return true;
		}
		return false;
	}
}
