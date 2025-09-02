import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int K;
	static int[][] map;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0 ,1, 0};
	static int maxLength;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1 ; test_case <= T; test_case++) { 
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visited = new boolean[N][N];
			maxLength = 0;
			int maxHeight = 0;
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxHeight = Math.max(maxHeight, map[i][j]);
				}
			}
			
			
			List<Point> startPoints = new ArrayList<>();
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(maxHeight == map[i][j]) {
						startPoints.add(new Point(i, j));
					}
				}
			}
			
			for(Point p : startPoints) {
                visited[p.x][p.y] = true; 
				dfs(p.x, p.y, 1, false);
				visited[p.x][p.y]= false;
			}
			
			System.out.println("#" + test_case + " " + maxLength);
		}
	}
	
	
	static void dfs(int x, int y, int length, boolean cut) {
		maxLength = Math.max(maxLength, length);
		
		for(int i = 0 ; i < 4 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {
				continue;
			}
			
			int curHeight = map[x][y];
			int nextHeight = map[nx][ny];
			
			if(curHeight > nextHeight) {
				visited[nx][ny] = true;
				dfs(nx,ny,length + 1,cut);
				visited[nx][ny] = false;
			} else if(!cut) {
				for(int c = 1 ; c <= K ; c++) {
					if(nextHeight - c < curHeight) {
						map[nx][ny] -= c;
						visited[nx][ny] = true;
						dfs(nx, ny, length + 1, true);
						visited[nx][ny] = false;
						map[nx][ny] += c;
						break;
					}
				}
			}
			
			
		}
	}
	
	
	
	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
