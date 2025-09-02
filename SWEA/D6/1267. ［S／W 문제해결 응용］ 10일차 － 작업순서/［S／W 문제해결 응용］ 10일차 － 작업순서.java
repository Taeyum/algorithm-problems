import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int V;
	static int E;
	static int[] degrees;
	static Node[] adjList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		
		for(int test_case = 1 ; test_case <= T; test_case++) { 
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			adjList = new Node[V + 1];
			degrees = new int[V + 1];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0 ; i < E ; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjList[from] = new Node(to, adjList[from]);
				degrees[to]++;
			}
			
			StringBuilder sb = new StringBuilder();
			
			List<Integer> list = topologySort();
			
			for(int i : list) {
				sb.append(i + " ");
			}
			
			System.out.println("#" + test_case + " " + sb);
		}
	}
	
	static List<Integer> topologySort() {
		List<Integer> list = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();
		
		for(int i = 1 ; i <= V ; i++) {
			if(degrees[i] == 0) {
				queue.offer(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			list.add(cur);
			for(Node temp = adjList[cur] ; temp != null ; temp = temp.next) {
				if(--degrees[temp.to] == 0) queue.offer(temp.to); 
			}
		}
		
		return list;
	}
	
	
	static class Node {
		int to;
		Node next;
		public Node(int to, Node next) {
			super();
			this.to = to;
			this.next = next;
		}
	}
}