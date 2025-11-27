import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Deque<int[]> deque;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
	
		deque = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		
		
		for(int i = 0 ; i < N ; i++) {
			deque.offer(new int[] {i+1,Integer.parseInt(st.nextToken())});
		}
		
		while(!deque.isEmpty()) {
			
			int[] cur = deque.poll();
			int idx = cur[0];
			int next = cur[1];
			
			sb.append(idx).append(" ");
			if(deque.isEmpty()) break;
			
			if(next > 0) {
				for(int i = 0 ; i < next-1 ; i++) {
					deque.offerLast(deque.pollFirst());
				}
			} else if(next < 0) {
				for(int i = 0 ; i < Math.abs(next) ; i++) {
					deque.offerFirst(deque.pollLast());
				}
			}
			 
		}
		
		System.out.println(sb);
	}
	
}
