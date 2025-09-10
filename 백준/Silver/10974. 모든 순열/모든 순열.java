import java.util.*;
import java.io.*;

public class Main {
    static int[] numbers;
    static boolean[] visited;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numbers = new int[N];
        visited = new boolean[N + 1];
        Perm(0);
    }
    static void Perm(int cnt) {
        if(cnt == N) {
            for(int num : numbers) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        
        for(int i = 1 ; i <= N ; i++) {
            if(visited[i]) continue;
            
            numbers[cnt] = i;
            visited[i] = true;
            Perm(cnt + 1);
            visited[i] = false;
        }
    }
}