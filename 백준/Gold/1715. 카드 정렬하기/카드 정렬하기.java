import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// (정렬)
// 각 묶음의 카드 수 A, B라 함 / 보통 두 묶음을 합쳐서 하나로 만드는 데에는 A+B 번의 비교를 해야함
// 20장 과 30장 을 합치려면  50번 비교가 필요
// 10,20,40 3 묶음 있으면 (10+20) + (30+40) = 100 / (10+40) + (50+20) = 120 번

public class Main {
	static PriorityQueue<Integer> pq;
	static int N;
	static int sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		pq = new PriorityQueue();
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < N ; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		
		while(!pq.isEmpty()) {
			
			int cur1 = pq.poll();
			if(pq.isEmpty()) break;
			int cur2 = pq.poll();
			
			sum += cur1 + cur2;
			pq.offer(cur1 + cur2);
						
		}
		
		System.out.println(sum);
	}
}
