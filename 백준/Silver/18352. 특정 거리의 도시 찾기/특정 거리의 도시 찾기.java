import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

// 출발 노드 설정 -> 출발 노드를 기준으로 각 노드의 최소 비용을 저장
// 방문하지 않는 노드 중에서 가장 비용이 적은 노드 선택
// 해당 노드를 거쳐서 특정한 노드로 가는 경우를 고려하여 최소 비용을 갱신
// 위 두 과정 반복
public class Main {
	static int[] visited;
	static ArrayList<Integer> answer;
	static ArrayList<Integer>[] list;
	static int N, M, K, X; // 도시의 개수, 도로의 개수, 거리 정보(최단 거리), 출발 도시 번호
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		answer = new ArrayList();
		
		for(int i = 1 ; i <= N ; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int vertex = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());
			list[vertex].add(edge);
		}
		
		visited = new int[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			visited[i] = -1; // 미 방문 처리
		}
		
		bfs(X);
		
		for(int i = 1 ; i <= N ; i++) {
			if(visited[i] == K) {
				answer.add(i);
			}
		}
		
		if(answer.isEmpty()) {
			System.out.println("-1");
		} else {
			Collections.sort(answer);
			for(int a : answer) {
				System.out.println(a);
			}
		}
		
		
	}
	
	static void bfs(int Node) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(Node);
		visited[Node]++;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int i : list[cur]) {
				if(visited[i] == -1) {
					visited[i] = visited[cur] + 1;
					queue.offer(i);
				}
			}
		}
	}
	
	
	
}
