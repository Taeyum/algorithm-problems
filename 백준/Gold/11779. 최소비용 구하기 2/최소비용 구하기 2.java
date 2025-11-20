import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<Node>[] list;
	static int[] answer;
	static int[] prev;
	static boolean[] visited;
	static int start, end;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		for(int i = 1 ; i <= N ; i++) {
			list[i] = new ArrayList<>();
		}
		
		answer = new int[N+1];
		prev = new int[N+1];
		visited = new boolean[N+1];
		
		Arrays.fill(answer, Integer.MAX_VALUE);
		
		for(int i = 1 ; i <= M ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, c));
		}
		
		st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dijk(start);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(answer[end]).append("\n");
		
		
		Deque<Integer> stack = new ArrayDeque<>();
		int cur = end;
		while (cur != 0) {
			stack.push(cur);
			cur = prev[cur];
		}
		
		sb.append(stack.size()).append("\n");
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}

		System.out.println(sb);
	}
	
	
	
	static void dijk(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
				
		pq.offer(new Node(start, 0));
		answer[start] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int currentEdge = cur.edge;
			
			if(visited[currentEdge]) continue;
			visited[currentEdge] = true;
			
			for(Node next : list[currentEdge]) {
				if(answer[next.edge] > answer[currentEdge] + next.cost) {
					answer[next.edge] = answer[currentEdge] + next.cost;
					
					prev[next.edge] = cur.edge; // ?
					
					pq.offer(new Node(next.edge, answer[next.edge]));
				}
				
			}
		}
		
		
	}
	
	
	
	static class Node implements Comparable<Node>{
		int edge, cost;

		public Node(int edge, int cost) {
			this.edge = edge;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
		
	}
}
