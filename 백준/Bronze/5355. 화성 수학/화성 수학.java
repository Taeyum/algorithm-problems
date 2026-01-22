import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double num = Double.parseDouble(st.nextToken());

            while (st.hasMoreElements()) {
                String str = st.nextToken();
                if (str.equals("@")) {
                    num *= 3;
                } else if (str.equals("%")) {
                    num += 5;
                } else if (str.equals("#")) {
                    num -= 7;
                }
            }

            System.out.printf("%.2f\n" , num);
        }
    }
}