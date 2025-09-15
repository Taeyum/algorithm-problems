import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class Point implements Comparable<Point>{
        int x,y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int compareTo(Point p) {
            return Integer.compare(this.x, p.x);
        }
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
        List<Point> points = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points.add(new Point(x, y));
		}

        points.sort(null);

        int[] arr = new int[N];
        for(int i = 0 ; i < N; i++) {
            arr[i] = points.get(i).y;
        }
		
        int[] LIS = new int[N];
		int max = 0;

		for (int i = 0; i < N; i++) {
			LIS[i] = 1;// 자신 혼자 증가수열의 끝에 있다고 생각했을때 길이값 1로 초기화
			for (int j = 0; j < i; j++) {
				if(arr[j]<arr[i] && LIS[i]<LIS[j]+1) {
					LIS[i]=LIS[j]+1;
				}
			}
			max = Math.max(max, LIS[i]);
		}
        // 전체 전깃줄 N - 교차하지 않고 남길 수 있는 최대 갯수 max
		System.out.println(N - max); 
	}

}

