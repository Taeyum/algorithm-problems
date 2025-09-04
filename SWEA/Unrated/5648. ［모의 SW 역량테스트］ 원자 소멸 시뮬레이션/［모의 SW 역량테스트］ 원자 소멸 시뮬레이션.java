import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	static int sum;
	static List<Atom> list;
	static int[] dx = {0, 0, -1, 1}; // 0 (상), 1 (하), 2 (좌), 3(우)
	static int[] dy = {1, -1, 0, 0};
	static Map<Long, List<Atom>> positionMap = new HashMap<>();
	static List<Atom> nextList = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1 ; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			sum = 0;
			list = new ArrayList<>();
			
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				list.add(new Atom(Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())));
			}
			
			while(!list.isEmpty()) {
				if(!crash()) break;
			}
			
			System.out.println("#"+test_case + " " +sum);
		}
	}
	
	static boolean crash() {
		positionMap.clear();
		nextList.clear();
		
		// 원자들 이동 및 위치별 그룹화
		for(Atom cur : list) {
			cur.x += dx[cur.dir];
			cur.y += dy[cur.dir];
			
			// 범위를 벗어난 원자는 제거 (더 넓은 범위로 설정)
			if(cur.x < -2000 || cur.x > 2000 || cur.y < -2000 || cur.y > 2000) {
				continue;
			}
			
			// 정수 키 사용 (y * 큰수 + x 형태)
			long key = (long)cur.y * 10000L + cur.x;
			positionMap.computeIfAbsent(key, k -> new ArrayList<>()).add(cur);
		}
		
		// 충돌 처리
		for(List<Atom> atomsAtPosition : positionMap.values()) {
			if(atomsAtPosition.size() > 1) {
				// 충돌 발생 - 에너지 합산
				for(Atom atom : atomsAtPosition) {
					sum += atom.energy;
				}
			} else {
				// 충돌 없음 - 다음 턴으로
				nextList.add(atomsAtPosition.get(0));
			}
			atomsAtPosition.clear(); // 메모리 절약
		}
		
		// 리스트 교체
		List<Atom> temp = list;
		list = nextList;
		nextList = temp;
		
		return !list.isEmpty();
	}
	
	static class Atom {
		int x;
		int y;
		int dir; // 0(상), 1(하), 2(좌), 3(우)
		int energy;
		
		public Atom(int x, int y, int dir, int energy) {
			this.x = x * 2;  // 0.5 단위를 정수로 표현하기 위해 2배
			this.y = y * 2;
			this.dir = dir;
			this.energy = energy;
		}
	}
}