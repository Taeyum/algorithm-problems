import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] adjList;
    static int N, M;
    static int up, down;
    static int totalCnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        totalCnt = 0;
        adjList = new int[N+1][N+1];
        
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from][to] = 1;
        }
        
        for(int i = 1 ; i <= N ; i++) {
            up = 0;
            down = 0;
            upperCnt(i, new boolean[N+1]);
            downCnt(i, new boolean[N+1]);
            if(up + down == N - 1) {
                totalCnt++;
            }
        }
        System.out.println(totalCnt);
    }
    
    static void upperCnt(int from , boolean[] visited) {
        visited[from] = true;
        for(int i = 1 ; i <= N ; i++) {
            if(!visited[i] && adjList[from][i] == 1) {
                upperCnt(i,visited);
                up++;
            }
        }
    }
    
    static void downCnt(int to , boolean[] visited) {
        visited[to] = true;
        for(int i = 1 ; i <= N ; i++) {
            if(!visited[i] && adjList[i][to] == 1) {
                downCnt(i,visited);
                down++;
            }
        }
    }
}