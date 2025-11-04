import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map;
    static int[][] visited;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] str = br.readLine().split("");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(str[j]);
                    visited[i][j] = Integer.MAX_VALUE;
                }
            }
            dijk();

            System.out.println("#"+test_case + " " +visited[N-1][N-1]);
        }
    }
    static void dijk() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0,0,0));
        visited[0][0] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int nr = cur.row;
            int nc = cur.col;
            int nw = cur.cost;

            if(nw > visited[nr][nc]) continue;

            for(int i = 0 ; i < 4 ; i++) {
                int dr = nr + dx[i];
                int dc = nc + dy[i];

                if(dr < 0 || dr >= N || dc < 0 || dc >= N) continue;
                int dw = nw + map[dr][dc];
                if(visited[dr][dc] > dw) {
                    visited[dr][dc] = dw;
                    pq.offer(new Node(dr,dc,dw));
                }
            }



        }
    }

    static class Node implements Comparable<Node> {
        int row;
        int col;
        int cost;

        public Node(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
