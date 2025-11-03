import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dx = {-1,0,1,0}; // 상 우 하 좌
    static int[] dy = {0,1,0,-1};
    static int[][] dist;
    static int[][] map;
    static int count = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            dist = new int[N][N];
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dist[0][0] = map[0][0];

            dijk();

            System.out.println("Problem " + count++ + ": " +dist[N - 1][N - 1]);
        }
    }

    static void dijk() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0,0, map[0][0]));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(cur.w > dist[cur.r][cur.c]) continue;

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dx[i];
                int nc = cur.c + dy[i];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    continue;
                }

                int nw = cur.w + map[nr][nc];

                if(nw < dist[nr][nc]) {
                    dist[nr][nc] = nw;
                    pq.offer(new Node(nr,nc,nw));
                }


            }
        }
    }

    static class Node implements Comparable<Node> {
        int r, c, w;

        public Node(int r, int c, int w) {
            this.r = r;
            this.c = c;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }
}
