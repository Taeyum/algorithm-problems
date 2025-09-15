import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// A : {x1,y1}, B : {x2,y2}
// A -> B (x2 - x1, y2 - y1)
// B -> A (x1 - x2, y1 - y2)

public class Solution {
	static int N;
	static long sum;
	static int[][] input;
	static boolean[] selected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			selected = new boolean[N];
			input = new int[N][2];
			sum = Long.MAX_VALUE;
			
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				input[i][0] = Integer.parseInt(st.nextToken());
				input[i][1] = Integer.parseInt(st.nextToken());
			}
			
			combination(0, 0);
			
			System.out.println("#"+test_case + " " +sum);
			
		}
	}
	
	static void combination(int start, int count) {
		if(count == N / 2) {
			calculate();
			return;
		}
		for(int i = start ; i < N ; i++) {
			selected[i] = true;
			combination(i + 1, count + 1);
			selected[i] = false;
		}
	}
	
	static void calculate() {
		int vectorX = 0;
		int vectorY = 0;
		
		for(int i = 0 ; i < N ; i++) {
			if(selected[i]) {
				vectorX += input[i][0];
				vectorY += input[i][1];
			} else {
				vectorX -= input[i][0];
				vectorY -= input[i][1];
			}
		}
		
		long curSum = getVector(vectorX, vectorY);
		
		if(sum > curSum) {
			sum = curSum;
		}
		
	}
	
	static long getVector(int x, int y) {
		return (long) (Math.pow(x, 2) + Math.pow(y, 2));
	}
}
