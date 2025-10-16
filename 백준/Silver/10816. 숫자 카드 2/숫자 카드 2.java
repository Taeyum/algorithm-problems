import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> sangenCards = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            Long card = Long.parseLong(st.nextToken());
            sangenCards.put(card, sangenCards.getOrDefault(card, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            Long card = Long.parseLong(st.nextToken());
            int cardNum = sangenCards.getOrDefault(card, 0);
            sb.append(cardNum).append(" ");
        }

        System.out.println(sb);
    }
}