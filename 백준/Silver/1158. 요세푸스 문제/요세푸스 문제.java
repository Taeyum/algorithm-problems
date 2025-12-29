import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        while (!queue.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                queue.add(queue.poll());
            }
            
            sb.append(queue.poll());
            
            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }
        
        sb.append(">");
        System.out.println(sb);
    }
}