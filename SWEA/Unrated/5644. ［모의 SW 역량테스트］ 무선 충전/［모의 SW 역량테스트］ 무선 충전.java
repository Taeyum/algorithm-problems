import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static BC[] bc;
	static int[][] deltas = {{0, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, 0}};
	static Location[][] peoples;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1 ; test_case <= T ; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken()); // 이동 시간
			int A = Integer.parseInt(st.nextToken()); // 충전기 갯수
			
			peoples = new Location[M + 1][2];
			
			// 사용자 위치 (0 초 부터 ~ M까지)
			peoples[0][0] = new Location(1, 1);
			peoples[0][1] = new Location(10, 10);
			
			for(int i = 0 ; i < 2; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int m = 1 ; m < M + 1 ; m++) {
					int d = Integer.parseInt(st.nextToken());
					peoples[m][i] = new Location(peoples[m - 1][i].x + deltas[d][0], 
							peoples[m - 1][i].y + deltas[d][1]);
				}
			}
			
			bc = new BC[A];
			
			for (int a = 0 ; a < A ; a++) {
				st = new StringTokenizer(br.readLine(), " ");
				bc[a] = new BC(Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}
			
			
			int sum = 0;
			List<Integer> p1 = new ArrayList<Integer>();
			List<Integer> p2 = new ArrayList<Integer>();
			
			for(int m = 0 ; m <= M ; m++) {
				// 가능한 배터리 모두 list 추가
				for(int a = 0 ; a < A ; a++) {
					if(bc[a].isAvailable(peoples[m][0])) p1.add(a);
					if(bc[a].isAvailable(peoples[m][1])) p2.add(a);
				}
				
				Collections.sort(p1, new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return bc[o2].power - bc[o1].power;
					}
					
				});
				Collections.sort(p2, new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return bc[o2].power - bc[o1].power;
					}
					
				});
				
				// 가능한 배터리 중 어떤 선택이 나은지 체크
				int max = 0;
				// 둘 다 안되면 넘어감
				if (p1.size() == 0 && p2.size() == 0) continue;
				
				// 둘다 하나 이상
				if(p1.size() >= 1 && p2.size() >= 1) {
					
					for(int i = 0 ; i < Math.min(2, p1.size()) ; i++) {
						for(int j = 0 ; j < Math.min(2, p2.size()) ; j++) {
							if(p1.get(i).equals(p2.get(j))) {
								max = Math.max(max, bc[p1.get(i)].power);
							} 
							else {
								max = Math.max(max, bc[p1.get(i)].power + 
										bc[p2.get(j)].power);
							}
						}
					}
				} else if(p1.size() == 0) {
					max = bc[p2.get(0)].power;
				} else {
					max = bc[p1.get(0)].power;
				}
				
				sum += max;
							
				p1.clear();
				p2.clear();
			}
			
			System.out.println("#" + test_case + " "+ sum);
		}
	}
	
	
	
	static class BC {
		
		Location location;
		int coverage;
		int power;
		
		public BC(int x, int y, int coverage, int power) {
			super();
			this.location = new Location(x, y);
			this.coverage = coverage;
			this.power = power;
		}
		
		boolean isAvailable(Location o) {
			return coverage >= location.diff(o);
		}
	}
	
	
	
	static class Location {
		
		int x;
		int y;
	
		public Location(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		int diff(Location o) { // 입력 받은 o의 위치와 자신의 위치를 반환하는 메서드
			return Math.abs(o.x - x) + Math.abs(o.y - y);
		}
	}
}
