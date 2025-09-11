import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] map;
	static List<People> list; // 사람들 위치
	static Stair[] stairs;
	
	static int[] selectedStair;
	
	static int minTime = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			list = new ArrayList<>();
			stairs = new Stair[2];
			minTime = Integer.MAX_VALUE;
			
			int index = 0;
			
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						list.add(new People(i, j));
					} else if(map[i][j] > 1) {
						stairs[index++] = new Stair(i, j, map[i][j]);	
					}
				}
			}
			
			int peopleSize = list.size();
			selectedStair = new int[peopleSize];
			selectStairs(0);
			
			System.out.println("#" + t + " " + minTime);
		}
	}
	
	
	static void simulate() {
		// 1번 계단
		List<People> people1 = new ArrayList<>();
		// 2번 계단
		List<People> people2 = new ArrayList<>();
		
		for(int i = 0 ; i < selectedStair.length ; i++) {
			People p = list.get(i);
			p.dist1 = Math.abs(p.x - stairs[0].x) + Math.abs(p.y - stairs[0].y);
			p.dist2 = Math.abs(p.x - stairs[1].x) + Math.abs(p.y - stairs[1].y);
			if(selectedStair[i] == 0) {
				people1.add(p); // 1번 계단 가는 사람들
			} else {
				people2.add(p); // 2번 계단 가는 사람들
			}
		}
		
		int time1 = calcTime(people1, stairs[0].k, 0);
		int time2 = calcTime(people2, stairs[1].k, 1);
		
		int totalTime = Math.max(time1, time2);
		
		minTime = Math.min(minTime, totalTime);
	}
	
	static int calcTime(List<People> peoples, int stairLen, int stairIndex) {
	    if (peoples.isEmpty()) {
	        return 0;
	    }
	    
	    // dist1, dist2로 정렬
	    if (stairIndex == 0) { // 1번 계단
	        peoples.sort(Comparator.comparingInt(p -> p.dist1));
	    } else { // 2번 계단
	        peoples.sort(Comparator.comparingInt(p -> p.dist2));
	    }
	    
	    // 1분의 대기시간이 있으므로 +1
	    List<Integer> arriveTimes = new ArrayList<>();
	    if (stairIndex == 0) {
	        for (People p : peoples) arriveTimes.add(p.dist1 + 1);
	    } else {
	        for (People p : peoples) arriveTimes.add(p.dist2 + 1);
	    }
	    
	    // 계단을 내려가고 있는 사람들의 완료 시간을 저장하는 리스트
	    List<Integer> stairDown = new ArrayList<>();
	    
	    int time = 0;
	    
	    // 모든 사람이 계단을 내려올 때까지 시뮬레이션
	    while (true) {
	        time++;
	        
	        // 현재 초에 계단을 내려오는 것을 마친 사람들을 처리
	        for (int i = 0; i < stairDown.size(); i++) {
	            if (stairDown.get(i) <= time) {
	                stairDown.remove(i);
	                i--;
	            }
	        }
	        
	        // 현재 초에 계단에 도착한 사람들을 계단으로 진입시키기
	        for (int i = 0; i < arriveTimes.size(); i++) {
	            if (stairDown.size() < 3) {
	                if (arriveTimes.get(i) <= time) {
	                    stairDown.add(time + stairLen); // 완료 시간 추가
	                    arriveTimes.remove(i);
	                    i--;
	                } else {
	                    break; // 정렬되어 있으므로 다음 사람도 아직 도착하지 않음
	                }
	            } else {
	                break; // 계단이 꽉 찼음
	            }
	        }
	        
	        // 모든 사람이 계단을 내려갔는지 확인
	        if (arriveTimes.isEmpty() && stairDown.isEmpty()) {
	            break;
	        }
	    }
	    
	    return time;
	}
	
	// 중복 순열
	static void selectStairs(int peopleIndex) {
		// 모든 조합이 완성되면 시뮬
		if(peopleIndex == list.size()) {
			simulate();
			return;
		}
		
		// 0 이면 1 번째 계단 가는 사람이고 , 1 이면 2 번째 계단 가는 사람  
		for(int i = 0 ; i< 2 ; i++) {
			selectedStair[peopleIndex] = i;
			selectStairs(peopleIndex + 1);
		}
	}
	
	static class Stair {
		int x, y, k;

		public Stair(int x, int y, int k) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}
	
	static class People {
		int x, y;
		int dist1, dist2; // 계단 1, 2 까지의 거리
		public People(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
