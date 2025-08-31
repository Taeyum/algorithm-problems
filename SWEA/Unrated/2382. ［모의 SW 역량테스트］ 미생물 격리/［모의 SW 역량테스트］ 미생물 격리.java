import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static class Micro {
        int r, c, cnt, dir, total; // 합쳐진 군집의 크기는 total 에 저장
        boolean isDead; // 기본 값 false

        public Micro(int r, int c, int cnt, int dir) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.dir = dir;
            this.total = this.cnt;
        }
    }

    static int N, M, K;
    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, -1, 1};
    static Micro[] list;
    static Micro[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken()); // 맵 크기 (5 <= N <= 100)
            M = Integer.parseInt(st.nextToken()); // 시간. (1 <= M <= 1,000)
            K = Integer.parseInt(st.nextToken()); // 초기 군집 수, (5 <= K <= 1,000)
            // 전체 군집 리스트 (죽은 군집 (통합되어진 군집), 살아있는 군집 다 포함) : 크기 변화 x : 배열 가능
            list = new Micro[K];
            // 매 시간마다 각 셀에 이동한 미생물 정보
            map = new Micro[N][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                list[i] = new Micro(Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()));
            }

            System.out.println("#" + test_case + " " + move());
        }
    }

    private static int move() { // 살아있는 미생물 수 리턴

        // M 시간동안 군집 이동 처리
        int time = M, nr , nc, remainCnt = 0;

        while(time-- > 0) {
            for (Micro cur : list) {
                if (cur.isDead) continue;
                // 한 칸 이동
                nr = cur.r += dr[cur.dir];
                nc = cur.c += dc[cur.dir];
                // 약품 칸 처리
                if (nr == 0 || nr == N - 1 || nc == 0 || nc == N -1) {
                    cur.total = cur.cnt = cur.cnt / 2;
                    if(cur.cnt == 0) {
                        cur.isDead = true;
                        continue;
                    }
                    // 방향 반대로 (홀수 일때 + 1 , 짝수 일 때 -1)
                    if(cur.dir%2 == 1) cur.dir++;
                    else cur.dir--;
                }
                // 군집 병합 관련 처리
                if(map[nr][nc] == null) { // 그 셀에 처음 도착하는 군집
                    map[nr][nc] = cur;
                } else { // 그 셀에 나중에 도착하는 군집(이미 다른 군집이 있는 경우)
                    // 군집의 미생물 크기로 비교해서 큰쪽으로 흡수
                    if(map[nr][nc].cnt > cur.cnt) {
                        map[nr][nc].total += cur.cnt;
                        cur.isDead = true;
                    }else { // 나중에 도착한 군집의 크기가 크면
                        cur.total += map[nr][nc].total;
                        map[nr][nc].isDead = true;
                        map[nr][nc] = cur;
                    }
                }
            } // end for : 군집 리스트 처리
            remainCnt = reset(); // 현재 시간에 이동한 군집을 정리후 살아 있는 미생물 수 받기
        } // end while : 시간 반복


        return remainCnt;
    }

    private static int reset() {
        int total = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == null) continue;
                // 군집이 있다면 정리
                map[i][j].cnt = map[i][j].total;
                total += map[i][j].cnt;
                map[i][j] = null; // 다음 시간 위해 초기화
            }
        }
        return total;
    }

}
