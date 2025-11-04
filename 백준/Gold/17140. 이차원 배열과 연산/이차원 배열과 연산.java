import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 행의 개수 >= 열의 개수 -> R 연산 (배열 A의 모든 행에 대해서 정렬을 수행한다.)
// 행의 개수 < 열의 개수 -> C 연산 (배열 A의 모든 열에 대해서 정렬을 수행한다.)
// 각각의 수가 몇 번 나왔는지 알아야 하며, 수의 등장 횟수가 1순위 -> 수가 커지는 순 2순위 
// 1 2 1 -> (2,1), (1,2) -> 2 1 1 2                  / 2 1 1 2 0 0
// 2 1 3 -> (1,1), (2,1), (3,1) -> 1 1 2 1 3 1       / 1 1 2 1 3 1
// 3 3 3 -> (3,3) -> 3 3                             / 3 3 0 0 0 0
// 크기가 가장 큰 2번 행 기준으로 1번 3번행의 빈 칸을 0 으로 채움
// 다음에 적용 되는 연산은 행의 개수 < 열의 개수 이므로 C 연산 적용

// r, c, k 가 주어짐 -> r 행 , c 열, k 결과 값
// A[r][c] -> k 가 되기 위한 연산의 최소 시간을 출력 / 100초가 지나도 A[r][c] = k 가 되지 않으면 -1 출력

public class Main {
	static int r, c, k;
	static int[][] A;
	static int row;
	static int col;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		A = new int[100][100];
		row = 3;
		col = 3;
		int time = 0;
		
		for(int i = 0 ; i < 3 ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 3 ; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(time <= 100) {
			if(A[r-1][c-1] == k) {
				System.out.println(time);
				return;
			}
			
			time++;
			
			if(row >= col) {
				newArrR();
			} else {
				newArrC();
			}
		}
		
		System.out.println(-1);
		
		
	}
	
	// R연산
	static void newArrR() {
		int[][] newR = new int[100][100];
		int maxCol = 0;
		
		for(int i = 0 ; i < row ; i++) {
			Map<Integer, Integer> map = new HashMap<>();
			for(int j = 0 ; j < col ; j++) {
				if (A[i][j] == 0) continue;
				map.put(A[i][j], map.getOrDefault(A[i][j], 0) + 1);
			}
			
			List<Pair> list = new ArrayList<>();
			for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
				list.add(new Pair(entry.getKey(), entry.getValue()));
			}
			
			Collections.sort(list);
			
			int curCol = 0;
			for(Pair p : list) {
				if(curCol >= 100) break;
				newR[i][curCol++] = p.number;
				if(curCol >= 100) break;
				newR[i][curCol++] = p.count;
			}
			
			maxCol = Math.max(maxCol, curCol);
		}
		
		A = newR;
		col = maxCol;
	}
	
	
	// C연산
	static void newArrC() {
		int[][] newC = new int[100][100];
		int maxRow = 0;
		
		for(int i = 0 ; i < col ; i++) {
			Map<Integer, Integer> map = new HashMap<>();
			for(int j = 0 ; j < row ; j++) {
				if (A[j][i] == 0) continue;
				map.put(A[j][i], map.getOrDefault(A[j][i], 0) + 1);
			}
			
			List<Pair> list = new ArrayList<>();
			for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
				list.add(new Pair(entry.getKey(), entry.getValue()));
			}
			
			Collections.sort(list);
			
			int curRow = 0;
			for(Pair p : list) {
				if(curRow >= 100) break;
				newC[curRow++][i] = p.number;
				if(curRow >= 100) break;
				newC[curRow++][i] = p.count;
			}
			maxRow = Math.max(maxRow, curRow);
		}
		A = newC;
		row = maxRow;
	}
	
	
	
	static class Pair implements Comparable<Pair>{
		int number, count;

		public Pair(int number, int count) {
			super();
			this.number = number;
			this.count = count;
		}

		@Override
		public int compareTo(Pair o) {
			if(this.count != o.count) {
				return Integer.compare(this.count, o.count);
			}
			else {
				return Integer.compare(this.number, o.number);
			}
		}
		
	}
}
