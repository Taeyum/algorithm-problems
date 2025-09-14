import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge>{
        int vertex, value;
        public Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }
        public int compareTo(Edge e) {
            if(this.value > e.value) return 1;
            else return -1;
        }
    }
    
    static ArrayList<Edge>[] list;
    static int N, M; // 노드 수, 엣지 수
    static boolean[] visited;
    static int[] dist; // 최단거리 배열

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list[from].add(new Edge(to, value));
        }

        st = new StringTokenizer(br.readLine());

        int startIndex = Integer.parseInt(st.nextToken());
        int endIndex = Integer.parseInt(st.nextToken());
        
        System.out.println(dijkstra(startIndex, endIndex));

    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Edge> p = new PriorityQueue<>();
        p.offer(new Edge(start, 0));
        dist[start] = 0;
        while(!p.isEmpty()) {
            Edge cur = p.poll();
            int now = cur.vertex;
            if(!visited[now]) {
                visited[now] = true;
                for(Edge e : list[now]) {
                    if(!visited[e.vertex] && dist[e.vertex] > dist[now] + e.value) {
                        dist[e.vertex] = dist[now] + e.value;
                        p.offer(new Edge(e.vertex, dist[e.vertex]));
                    }
                }
            }
        }
        return dist[end];
    }
    
}
