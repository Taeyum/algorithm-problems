import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int minTime = Integer.MAX_VALUE;
    static int Height;
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 가능한 모든 높이(0 ~ 256)를 탐색
        for (int h = 0; h <= 256; h++) {
            int time = 0;
            int blockRemove = 0;
            int blockPlace = 0;
            
            // 모든 블록을 순회하며 작업량 계산
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int diff = map[i][j] - h;
                    if (diff > 0) { // 제거해야 할 경우
                        blockRemove += diff;
                    } else if (diff < 0) { // 쌓아야 할 경우
                        blockPlace += Math.abs(diff);
                    }
                }
            }
            
            if (blockRemove + B >= blockPlace) {
                time = blockRemove * 2 + blockPlace * 1;
                
                if (time <= minTime) {
                    minTime = time;
                    Height = h;
                }
            }
        }
        
        System.out.println(minTime + " " + Height);
    }

}