import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int N, W, H ,min;

    static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 횟수
            W = Integer.parseInt(st.nextToken()); // 열크기
            H = Integer.parseInt(st.nextToken()); // 행크기
            int map[][] = new int[H][W];

            for (int r = 0; r < H; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < W; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            min = Integer.MAX_VALUE;
            drop(0, map);

            System.out.println("#" + test_case + " " + min); // 남아있는 벽돌의 최소 수
        }
    }

    static boolean drop(int cnt, int[][] map) { // 해당 구슬 던져보기
        int remainCnt = getRemain(map);
        if(remainCnt == 0) {
            min = 0;
            return true; // 남은 벽돌이 없다. 최적해
        }

        if(cnt == N) {
            min = Math.min(min, remainCnt);
            return false; // 남은 벽돌이 있다. 최적해는 아니다. (다른 경우도 고려해봐야한다.)
        }

        // 전달 받은 배열을 백업으로 사용해야 하므로 새로운 배열 생성해서 작업
        int[][] newMap = new int[H][W];

        // 구슬을 모든 열에 던지는 시도(중복 순열)
        for (int c = 0; c < W; c++) {
            // step1. c열에 던졌을 때 깨지는 맨위 벽돌 찾기
            int r = 0;
            while(r < H && map[r][c] == 0) ++ r;
            // 벽돌이 없다면 비어있는 열이므로 다음열로 구술 던지기
            if(r == H) continue;

            // step2. 깨질 벽돌을 찾았으니 연쇄 작업 처리
            copy(map, newMap);
            // 깨지는 벽돌 주변으로 함께 깨지는 벽돌 찾기
            boom(newMap, r, c);
            // 남은 벽돌 정리
            down(newMap);
            // 다음 구슬 던지러 가기
            if(drop(cnt + 1, newMap)) return true;
        }
        return false;
    }

    static int getRemain(int[][] map) {
        int count = 0;
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                if(map[r][c]>0) ++ count;
            }

        }
        return count;
    }

    static Stack<Integer> stack = new Stack<>();

    static void down(int[][] map) {
        for (int c = 0; c < W; c++) {
            for (int r = 0; r < H; r++) {
                if(map[r][c] == 0) continue;
                stack.push(map[r][c]);
                map[r][c] = 0;
            }
            int r = H - 1;
            while(!stack.isEmpty()) {
                map[r--][c] = stack.pop();
            }
        }
    }
    static void boom(int[][] map, int r, int c) {
        Queue<Point> queue = new ArrayDeque();
        if(map[r][c] > 1) queue.offer(new Point(r,c,map[r][c]));
        map[r][c] = 0;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur.r, nc = cur.c;
                for (int k = 1; k < cur.cnt; k++) {
                    nr += dr[d];
                    nc += dc[d];
                    if(nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != 0) {
                        if(map[nr][nc] > 1) queue.offer(new Point(nr,nc,map[nr][nc]));
                        map[nr][nc] = 0;
                    }
                }
            }
        }
    }

    static void copy(int[][] map, int[][] newMap) {
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                newMap[r][c] = map[r][c];
            }
        }
    }

    static void print(int i, int j, int[][] map, boolean flag) {
        System.out.println(i + " " + j + (flag? " 전" : " ") + " ================");
        for (int[] ints : map) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
