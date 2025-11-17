import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static char[] alpha;
    static char[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alpha = new char[C];
        result = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alpha[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alpha);

        dfs(0, 0);
        System.out.print(sb);
    }

    static void dfs(int start, int cnt) {
        if (cnt == L) {
            if (isValid()) {
                sb.append(result).append('\n');
            }
            return;
        }

        for (int i = start; i < C; i++) {
            result[cnt] = alpha[i];
            dfs(i + 1, cnt + 1);
        }
    }

    static boolean isValid() {
        int mo = 0;
        int ja = 0;

        for (char c : result) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                mo++;
            } else {
                ja++;
            }
        }

        return mo >= 1 && ja >= 2;
    }
}