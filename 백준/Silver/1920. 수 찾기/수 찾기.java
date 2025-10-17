import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            map.put(Integer.parseInt(st.nextToken()),0);
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int B[] = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0 ; i < M ; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        for (int i : B) {
            if(map.containsKey(i)) {
                System.out.println(1);
            }else {
                System.out.println(0);
            }
        }


    }
}