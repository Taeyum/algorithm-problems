import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] list;
	static int[] arr;
	static int count;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		

		list = new List[N + 1];
		arr = new int[N + 1];
		for(int i = 1 ; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[b].add(a);
		}
		for(int i = 1; i < N+1; i++) {
			visited = new boolean[N+1];
			count = 1;
			dfs(i);
			arr[i] = count;
		}
		
		int max = 0;
		for(int i : arr) {
			if(max < i) {
				max = i;
			}
		}
		
		for(int i = 1 ; i < N + 1; i++) {
			if(arr[i] == max) {
				System.out.print(i + " ");
			}
		}
	}
	
	static void dfs(int index) {
		visited[index] = true;
		count++;
		
		for(int a : list[index]) {
			if(visited[a] == false) {
				dfs(a);
			}
		}
	}
}
