import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, X;
    static List<Node>[] list;
    static List<Node>[] reverseList;
    static int[] startDist;
    static int[] endDist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        reverseList = new List[N+1];
        startDist = new int[N+1];
        endDist = new int[N+1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v,w));
            reverseList[v].add(new Node(u,w));
        }

        dijk(X, list, startDist);
        dijk(X, reverseList, endDist);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            int time = startDist[i] + endDist[i];
            if(time > max) {
                max = time;
            }
        }

        System.out.println(max);

    }

    static void dijk(int start, List<Node>[] graph, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int u = cur.vertex;

            if(visited[u]) continue;
            visited[u] = true;

            for(Node nextNode : graph[u]) {
                int v = nextNode.vertex;
                int w = nextNode.value;
                if(dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int value;

        public Node(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value, o.value);
        }
    }
}
