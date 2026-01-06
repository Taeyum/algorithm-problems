import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String s = st.nextToken();

        HashSet<String> user = new HashSet<>();
        for (int i = 0; i < N; i++) {
            user.add(br.readLine());
        }

        int count = user.size();
        int game = 0;

        if (s.equals("Y")) {
            game = 1;
        } else if (s.equals("F")) {
            game = 2;
        } else if (s.equals("O")) {
            game = 3;
        }

        System.out.println(count / game);
    }
}