import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N, max, min, map[][];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static List<int[]> list;
	static int totalCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1 ; test_case <= T; test_case++) { 
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			max = 0;
			min = Integer.MAX_VALUE;
            totalCnt = 0;
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			list = new ArrayList();
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(i > 0 && i < N - 1 && j > 0 && j < N - 1 && map[i][j] == 1) {
						list.add(new int[] {i,j});
						totalCnt++;
					}
				}
			}
			go(0,0,0);
			System.out.println("#" + test_case + " " + min);
		}
	}
	
	static void go(int index, int cCnt, int lCnt) {
		if(totalCnt - index + cCnt < max) return;
		
		if(index == totalCnt) {
			if(max < cCnt) {
				max = cCnt;
				min = lCnt;
			} else if(max == cCnt) {
				if(min > lCnt) {
					min = lCnt;
				}
			}
			return;
		}
		int[] cur = list.get(index);
		int r = cur[0];
		int c = cur[1];
		
		for (int d = 0 ; d < 4; d++) {
			if(!isAvailable(r, c, d)) continue;
			int len = setStatus(r, c, d, 2);
			go(index + 1, cCnt + 1, lCnt + len);
			setStatus(r, c, d, 0);
		}
		go(index + 1, cCnt, lCnt);
		
	}
	
	
	static boolean isAvailable(int r, int c, int d) {
		int nr = r, nc = c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;
			if(map[nr][nc] >= 1) {
				return false;
			}
		}
		return true;
	}
	
	
	static int setStatus(int r, int c, int d, int s) {
		int len = 0;
		int nr = r, nc = c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;
			map[nr][nc] = s;
			len++;
		}
		
		return len;
	}
}