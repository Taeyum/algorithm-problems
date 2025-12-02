import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0 ,1, 0};
    static int[] dy = {0, 1, 0 , -1};
    static int col, row;
    static int[][] box;
    static boolean[][] visited;
    static int count;
    static Queue<int[]> queue = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        box = new int[row][col];
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1) {
                    queue.offer(new int[] {i,j});
                    visited[i][j] = true;
                }
            }
        }
        bfs();

        System.out.println(getTomato());
    }

    static void bfs() {
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] cur = queue.poll();
                int cx = cur[0];
                int cy = cur[1];

                for (int i = 0; i < 4; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if (rangeCheck(nx, ny)) continue;

                    box[nx][ny] = 1;
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
            if(!queue.isEmpty()) {
                count++;
            }
        }
    }

    static boolean rangeCheck(int nx, int ny) {
        return nx >= row || nx < 0 || ny >= col || ny < 0 || box[nx][ny] == -1 || visited[nx][ny];
    }

    static int getTomato() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(box[i][j] == 0) {
                    return -1;
                }
            }
        }
        return count;
    }
}
