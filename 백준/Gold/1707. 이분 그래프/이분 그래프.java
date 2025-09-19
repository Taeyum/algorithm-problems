import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer>[] list;
    static int[] check;
    static boolean[] visited;
    static boolean result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int t = 0; t < N; t++) {
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);

            list = new ArrayList[V+1];
            visited = new boolean[V+1];
            check = new int[V+1];
            result = true;

            for (int i = 1; i <= V; i++) {
                list[i] = new ArrayList();
            }
            for (int i = 0; i < E; i++) {
                s = br.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                list[a].add(b);
                list[b].add(a);
            }

            for (int i = 1; i <= V; i++) {
                if(result) {
                    DFS(i);
                } else {
                    break;
                }
            }
            if (result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
    
    static void DFS(int node) {
        visited[node] = true;
        for (int i : list[node]) {
            if(!visited[i]) {
                check[i] = (check[node] + 1) % 2;
                DFS(i);
            }
            else if (check[node] == check[i]) {
                result = false;
            }
        }   
    }
}
