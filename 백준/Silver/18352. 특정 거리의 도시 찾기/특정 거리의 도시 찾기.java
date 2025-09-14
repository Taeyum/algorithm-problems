import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] visited;
    static ArrayList<Integer>[] A;
    static int N,M,K,X;
    static List<Integer> answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();
        A = new ArrayList[N+1];
        answer = new ArrayList<>();

        for(int i = 1 ; i <= N ; i++) {
            A[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
        }
        
        visited = new int[N+1];
        
        for(int i = 0 ; i <= N ; i++) {
            visited[i] = -1;
        }
        
        bfs(X);
        
        for (int i = 0; i <= N; i++) {
            if(visited[i] == K) {
                answer.add(i);
            }
        }
        if(answer.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(answer);
            for(int a : answer) {
                System.out.println(a);
            }
        }
    }    

    static void bfs(int Node) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(Node);
        visited[Node]++;

        while(!queue.isEmpty()) {
            int n_Node = queue.poll();
            for (int i : A[n_Node]) {
                if(visited[i] == -1) {
                    visited[i] = visited[n_Node] + 1;
                    queue.offer(i);
                }
            }
        }
    }
}
