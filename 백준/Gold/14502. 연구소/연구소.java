import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 받은 맵에 벽을 세우는 모든 경우를 돌리고 그중 가장 큰 영역 크기 나온거 저장하면 될듯?

public class Main {
	static int[][] map;
	static int[][] tempMap;
	static List<VirusPoint> list;
	static List<SafePoint> safeList;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int safeZone;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		tempMap = new int[N][M];
		list = new ArrayList<>();
		safeList = new ArrayList<>();
		safeZone = 0;
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					list.add(new VirusPoint(i, j));
				} else if(map[i][j] == 0) {
					safeList.add(new SafePoint(i, j));
				}
			}
		}
		
		combination(0, 0);
		
		System.out.println(safeZone);
		
	}
	
	static void combination(int start, int count) {
		if (count == 3) {
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					tempMap[i][j] = map[i][j];
				}
			}
		
			bfs();
			
			int curSafe = 0;
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					if(tempMap[i][j] == 0) {
						curSafe++;
					}
				}
			}
			
			safeZone = Math.max(curSafe, safeZone);
			return;
		}
		
		for(int i = start ; i < safeList.size() ; i++) {
			SafePoint p = safeList.get(i);
			map[p.x][p.y]= 1;
			combination(i + 1 ,count + 1);
			map[p.x][p.y]= 0; 
		}
	}
	
	static void bfs() {
		Queue<VirusPoint> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		
		for(VirusPoint vp : list) {
			queue.offer(vp);
			visited[vp.x][vp.y] = true; 
		}
		
		while(!queue.isEmpty()) {
			VirusPoint cur = queue.poll();
			
			for(int d = 0 ; d < 4 ; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || tempMap[nx][ny] == 1 || visited[nx][ny]) {
					continue;
				}
				
				if(tempMap[nx][ny] == 0) {
					tempMap[nx][ny] = 2;
					visited[nx][ny] = true;
					queue.offer(new VirusPoint(nx, ny));
				}
			}
		}
	
	}
	
	static class VirusPoint {
		int x, y;

		public VirusPoint(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static class SafePoint {
		int x, y;

		public SafePoint(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
