import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static Deque<Integer> deque = new ArrayDeque<>();
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            command(c);
        }
    }

    static void command(int c) {
        switch (c) {
            case 1:
                int Fx = Integer.parseInt(st.nextToken());
                deque.offerFirst(Fx);
                break;
            case 2:
                int Lx = Integer.parseInt(st.nextToken());
                deque.offerLast(Lx);
                break;
            case 3:
                if(!deque.isEmpty()) System.out.println(deque.pollFirst());
                else System.out.println(-1);
                break;
            case 4:
                if(!deque.isEmpty()) System.out.println(deque.pollLast());
                else System.out.println(-1);
                break;
            case 5:
                System.out.println(deque.size());
                break;
            case 6:
                if(deque.isEmpty()) System.out.println(1);
                else System.out.println(0);
                break;
            case 7:
                if(!deque.isEmpty()) System.out.println(deque.peekFirst());
                else System.out.println(-1);
                break;
            case 8:
                if(!deque.isEmpty()) System.out.println(deque.peekLast());
                else System.out.println(-1);
                break;
        }
    }
}
