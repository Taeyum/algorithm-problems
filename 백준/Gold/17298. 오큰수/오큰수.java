import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] ans = new int[N];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(str[i]);
        }
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        
        for (int i = 1; i < N; i++) {
            while(!stack.isEmpty() && A[stack.peek()] < A[i]) {
                ans[stack.pop()] = A[i];
            }
            stack.push(i);
        }   
        while(!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            sb.append(i).append(" ");
        }
        System.out.print(sb.toString());
    }
}