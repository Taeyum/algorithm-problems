import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static ArrayDeque<Integer> stack = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch (str) {
                case "push":
                    int command = Integer.parseInt(st.nextToken());
                    push(command);
                break;
                case "pop":
                    sb.append(pop());
                    sb.append("\n");
                break;
                case "size":
                    sb.append(size());
                    sb.append("\n");
                break;
                case "empty":
                    sb.append(empty());
                    sb.append("\n");
                break;
                case "top":
                    sb.append(top());
                    sb.append("\n");
                break;
            }
        }
        System.out.println(sb);
        
    }

    static void push(int x) {
        stack.push(x);
    }
    static int pop() {
        if(!stack.isEmpty()) {
            return stack.pop();
        }
        return -1;
    }
    static int size() {
        return stack.size();
    }
    static int empty() {
        if(stack.isEmpty()) {
            return 1;
        }
        return 0;
    }
    static int top() {
        if(stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }
}
