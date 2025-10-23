import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int count;
	static int[] dx = {-1,0,1,0}; // 상, 우, 하, 좌
	static int[] dy = {0,1,0,-1};
	static int x,y;
	static ArrayList<Integer> house;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		house = new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			char[] arr = br.readLine().toCharArray();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = arr[j] - '0';
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					bfs(i,j);
				}
			}
		}
		
		house.sort(null);
		
		System.out.println(count);
		
		for(int a : house) {
			System.out.println(a);
		}
		
	}
	
	// 시작 지점 찾아야지 (1)
	// 근처에 1 있는지 탐색 -> 있으면 가 , 근처에 0 밖에 없다? 끝내
	// bfs 끝 -> 카운트 올려
	// 다시 시작 지점 찾어
	// 이거 계속 반복	
		
	static void bfs(int startX, int startY) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {startX,startY});
		visited[startX][startY] = true;
		int houseCount = 1;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cur_x = cur[0];
			int cur_y = cur[1];
			for(int i = 0 ; i < 4 ; i++) {
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 0 ||
						visited[nx][ny]) {
					continue;
				}
				visited[nx][ny] = true;
				houseCount++;
				queue.offer(new int[]{nx, ny});
			}
		}
		house.add(houseCount);
		count++;		
	}
}
