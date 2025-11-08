import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int K = sc.nextInt();
		int count = 1;
		int[] arr = new int[N];
		int idx = 0;
		Queue<Integer> queue = new ArrayDeque();
		
		for(int i = 1 ; i <= N ; i++) {
			queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			if (count == K) {
                arr[idx++] = queue.poll();
                count = 1;
            } else {
                queue.offer(queue.poll());
                count++;
            }
		}
        sb.append("<");
		for(int i = 0 ; i < N ; i++) {
            sb.append(arr[i]);
			if(i == N - 1) {
				break;
			}
            sb.append(", ");
			
		}
        sb.append(">");
        System.out.println(sb);
	}
}