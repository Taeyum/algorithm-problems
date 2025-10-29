import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// N 연구소 크기 , 놓을 수 있는 M 바이러스 개수
// 0 빈 공간, 1 벽, 2 바이러스 놓을 수 있는 위치 (음 조합인가? -> 순서 상관 없지, 중복 x)
// list.size에서 M개 뽑기

public class Main {
	static int N, M;
	static int[][] lab;
	static List<Virus> virusList;
	static int minTime = Integer.MAX_VALUE;
	static Virus[] ableVirus;
	static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dy = {0, 0, 1, -1};
	static int zeroCount = 0;
	static int virusCount = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lab = new int[N][N];
		ableVirus = new Virus[M];
		virusList = new ArrayList();
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if(lab[i][j] == 2) {
					virusList.add(new Virus(i,j));
				} else if(lab[i][j] == 0) {
					zeroCount++;
				}
			}
		}
		
		virusCount = virusList.size();
		int count = zeroCount + (virusCount - M);
		
		if(count == 0) {
			System.out.println(0);
			return;
		}
		
		combinations(0, 0);
		
		if(minTime != Integer.MAX_VALUE) {
			System.out.println(minTime);
		} else {
			System.out.println("-1");
		}
		
		
		
	}
	
	static void bfs(Virus[] virus) {
		int[][] times = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				times[i][j] = -1; // 미방문 표시
				if(lab[i][j] == 1) {
					times[i][j] = -2; // 벽 (확산 불가)
				}
			}
		}
		
		Queue<Virus> queue = new ArrayDeque<>();
		for(Virus vi : virus) {
			queue.offer(vi);
			times[vi.row][vi.col] = 0;
		}
		
		int infectCount = 0; // 감염된 칸 수
		int count = zeroCount + (virusCount - M); // 감염시킬 수 있는 자리 였던 얘들도 감염이 가능하니까
		
		while(!queue.isEmpty()) {
				Virus cur = queue.poll();
				int curTime = times[cur.row][cur.col];
											
				for(int i = 0 ; i < 4 ; i++) {
					int dr = cur.row + dx[i];
					int dc = cur.col + dy[i];
					
					if(dr < 0 || dr >= N || dc < 0 || dc >= N || times[dr][dc] != -1) {
						continue;
					}
					
					times[dr][dc] = curTime + 1;
					queue.offer(new Virus(dr,dc));
					
					if(lab[dr][dc] == 0 || lab[dr][dc] == 2) {
						infectCount++;
					}
				}
			}
		
		if(infectCount == count) {
			int maxTime = 0; // 제일 오래걸린 시간
			
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(lab[i][j] == 0) {	
	                    maxTime = Math.max(maxTime, times[i][j]);
					}
					else if(lab[i][j] == 2 && times[i][j] > 0) {
						maxTime = Math.max(maxTime, times[i][j]);
					}
				}
			}
			

			minTime = Math.min(minTime, maxTime);
			
		}
	}
		
	
	static void combinations(int start, int count) {
		if(count == M) {
			bfs(ableVirus);
			return;
		}
		
		for(int i = start ; i < virusList.size() ; i++) {
			ableVirus[count] = virusList.get(i);
			combinations(i + 1, count + 1);
		}
	}
	
	static class Virus {
		
		int row;
		int col;
		
		public Virus(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}			
	}
}
