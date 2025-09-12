import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] weight = new int[N+1];
		int[] values = new int[N+1];
		int[][] K = new int[N+1][W+1];
		
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			weight[i] = Integer.parseInt(st.nextToken());
			values[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1 ; i <= N ; i++) {
			for(int w = 1 ; w <= W ; w++) {
				int curWeight = weight[i];
				int curValue = values[i];
				
				if(curWeight > w) {
					K[i][w] = K[i-1][w];
				} else {
					K[i][w] = Math.max(curValue + K[i-1][w - curWeight] , K[i-1][w]);
				}	
			}
		}
//		
//		for(int[] a : K) {
//			System.out.println(Arrays.toString(a));
//		}
		System.out.println(K[N][W]);
		
	}
}
