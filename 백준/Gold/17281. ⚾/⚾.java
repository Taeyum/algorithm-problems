import java.util.*;
import java.io.*;

// 순열
public class Main {

    static int N;
    static int[][] innings;
    static int max = 0;
    static int[] order = new int[9]; 
    static boolean[] visited = new boolean[9]; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        innings = new int[N][9];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                innings[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        order[3] = 0; // 4번 타자 고정 
        visited[0] = true;
        dfs(0);
        
        System.out.println(max);
    }

    static int playGame(int[] order) {
        int score = 0;
        int tajar = 0; // 타자 순서

        for (int inning = 0; inning < N; inning++) {
            int outCount = 0;
            boolean[] bases = new boolean[3]; // 1,2,3루

            while (outCount < 3) {
                // 현재 타석
                int curPlayer = order[tajar];
                // 현재 타석 결과
                int result = innings[inning][curPlayer];

                switch (result) {
                    case 0: // 아웃
                        outCount++;
                        break;
                    case 1: // 안타
                        if (bases[2]) { // 3루 -> 홈
                            score++;
                            bases[2] = false;
                        }
                        if (bases[1]) { // 2루 -> 3루
                            bases[2] = true;
                            bases[1] = false;
                        }
                        if (bases[0]) { // 1루 -> 2루
                            bases[1] = true;
                            bases[0] = false;
                        }
                        bases[0] = true; // 타자 1루
                        break;
                    case 2: // 2루타 (2칸 씩)
                        if (bases[2]) {
                            score++;
                            bases[2] = false;
                        }
                        if (bases[1]) {
                            score++;
                            bases[1] = false;
                        }
                        if (bases[0]) {
                            bases[2] = true;
                            bases[0] = false;
                        }
                        bases[1] = true; // 타자 2루
                        break;
                    case 3: // 3루타 (3칸 씩)
                        for (int i = 2; i >= 0; i--) {
                            if (bases[i]) {
                                score++;
                                bases[i] = false;
                            }
                        }
                        bases[2] = true; // 타자 3루
                        break;
                    case 4: // 홈런
                        for (int i = 2; i >= 0; i--) {
                            if (bases[i]) {
                                score++;
                                bases[i] = false;
                            }
                        }
                        score++;
                        break;
                }
                // 다음 
                tajar = (tajar + 1) % 9;
            }
        }

        return score;
    }

    static void dfs(int depth) {
        // 4번 타자(idx 3)는 이미 1번 선수로 채워져 있으므로 건너뛴다.
        if (depth == 3) {
            dfs(depth + 1);
            return;
        }

        // 9명의 타순이 모두 정해진 경우
        if (depth == 9) {
            // 시뮬레이션 실행
            int score = playGame(order); 
            max = Math.max(max, score); // 전역 변수 max 갱신
            return;
        }

        // 0번(1번 선수) ~ 8번(9번 선수)까지 반복
        for (int i = 0; i < 9; i++) {
            // 아직 타순에 배치되지 않은 선수(i)라면
            if (!visited[i]) {
                visited[i] = true;      
                order[depth] = i;       
                dfs(depth + 1);         

                visited[i] = false;    
            }
        }
    }
}