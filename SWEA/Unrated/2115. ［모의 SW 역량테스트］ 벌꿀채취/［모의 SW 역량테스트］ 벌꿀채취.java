import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {
	static int N; // 크기
	static int M; // 캘수 있는 꿀 수
	static int limit; // 최대 꿀 양
	static int[][] map; // 초기 꿀 저장
	static int max; // r1,c1 부터 계속 각 경우의 최대 이익 저장할 변수
	static int totalMax; // 결과 값
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1 ; test_case <= T ; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0  ; j < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			totalMax = 0;
			
			// 초기 시작은 0,0 부터 r1 = 0 부터 N 까지, c1 은 N - M 까지  
			for(int r1 = 0 ; r1 < N ; r1++) {
				for(int c1 = 0 ; c1 <= N-M ; c1++) {
					// r1, c1의 이익
					int profit1 = getMaxProfit(r1, c1);
					
					// 같은 행에서 선택 하는 경우 c1 + M 부터 시작해야 안겹침
					for(int c2 = c1 + M ; c2 <= N - M ; c2++) {
						// r1 , c2의 이익
						int profit2 = getMaxProfit(r1, c2);
						
						// 이 두 개의 이익을 더한 값이 totalMax 보다 크면 저장
						if(profit1 + profit2 > totalMax) {
							totalMax = profit1 + profit2;
						}
					}
					
					// 같은 행이 아닌 다른 열 에서 선택하는 경우 r1 보다 한 칸 뒤의 열에서 전부 탐색 시작
					for(int r2 = r1 + 1 ; r2 < N ; r2++) {
						// 이미 위 행에서 선택 되었다고 가정하니 c2는 0 부터 N - M
						for(int c2 = 0 ; c2 <= N - M ; c2++) {
							// r2, c2 의 이익
							int profit2 = getMaxProfit(r2, c2);
							// 두개의 이익을 더한 값이 totalMax 보다 크면 저장
							if(profit1 + profit2 > totalMax) {
								totalMax = profit1 + profit2;
							}
						}
					}
				}
			}
		
		System.out.println("#"+test_case+ " " + totalMax);
		
		}
	}
	// index M개 꿀통 index, currentSum : 더한 꿀통 값, currentProfit : 꿀통 이익 값 , arr : 새로운 꿀통
	static void solve(int index, int currentSum, int currentProfit, int[] arr) {
		// 기저 조건 : 꿀통 전부 확인 후 현재 이익이 전 보다 크면 max 에 이익 저장
		if(index == M) {
			if(currentProfit > max) {
				max = currentProfit;
			}
			return;
		}
		
		// 더한 꿀통 값 + 현재 꿀통이 limit 보다 작을 때만 꿀통을 추가해주고 값들도 다 올려줌
		if(currentSum + arr[index] <= limit) {
			solve(index + 1, currentSum + arr[index] , currentProfit + arr[index] * arr[index], arr);
		}
		// limit가 크면 다음 꿀통을 탐색하긴 하지만 값들을 추가해주진 않음
		solve(index + 1, currentSum, currentProfit, arr);
	}
	
	// 새로운 꿀통 마다 이익 계산
	static int getMaxProfit(int r, int c) {
		// 해당 r, c 에 맞는 꿀통 저장할 배열
		int[] curHoney = new int[M];
		
		// 메인의 반복 문에서 c 의 범위가 N-M 이니까 결국 c+i 를 해줘야 다 담기가능
		for(int i = 0 ; i < M ; i++) {
			curHoney[i] = map[r][c + i];
		}
		
		// max 초기화
		max = 0;
		// 재귀 시작
		solve(0, 0, 0, curHoney);
		return max;
	}
}
	
