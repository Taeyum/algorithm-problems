import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Monkey {
    int r, c, k, dist;

    public Monkey(int r, int c, int k, int dist) {
        this.r = r;
        this.c = c;
        this.k = k;
        this.dist = dist;
    }
}

public class Main {
    static int K, W, H;
    static int[][] map;
    static boolean[][][] visited;

    // 원숭이의 일반적인 상하좌우 움직임
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    // 말의 8가지 움직임
    static int[] hr = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] hc = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        map = new int[H][W];
        visited = new boolean[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Monkey> q = new LinkedList<>();
        q.offer(new Monkey(0, 0, K, 0));
        visited[0][0][K] = true;

        while (!q.isEmpty()) {
            Monkey current = q.poll();
            int r = current.r;
            int c = current.c;
            int k = current.k;
            int dist = current.dist;

            // 목표 지점 도착
            if (r == H - 1 && c == W - 1) {
                return dist;
            }

            // 1. 원숭이의 일반적인 움직임 (상하좌우)
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (isValid(nr, nc) && !visited[nr][nc][k] && map[nr][nc] == 0) {
                    visited[nr][nc][k] = true;
                    q.offer(new Monkey(nr, nc, k, dist + 1));
                }
            }

            // 2. 말처럼 점프
            if (k > 0) {
                for (int i = 0; i < 8; i++) {
                    int nr = r + hr[i];
                    int nc = c + hc[i];
                    if (isValid(nr, nc) && !visited[nr][nc][k - 1] && map[nr][nc] == 0) {
                        visited[nr][nc][k - 1] = true;
                        q.offer(new Monkey(nr, nc, k - 1, dist + 1));
                    }
                }
            }
        }
        return -1; // 도착할 수 없는 경우
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < H && c >= 0 && c < W;
    }
}