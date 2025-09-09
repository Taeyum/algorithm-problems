import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[] LIS;
	static int[] A;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1 ; test_case <= T ; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			LIS = new int[N];
			A = new int[N];
			
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0 ; i < N ; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			for(int i = 0 ; i < N ; i++) {
				LIS[i] = 1;
				for(int j = 0 ; j < i ; j++) {
					if(A[j] < A[i] && LIS[i] < LIS[j] + 1) {
						LIS[i] = LIS[j]+1;
					}
				}
				max =Math.max(max, LIS[i]);
			}
			
			System.out.println("#"+test_case + " " + max);
			
		}
	}
}
