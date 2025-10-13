import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str.equals("0")) {
                break;
            }
            StringBuilder reversed_sb = new StringBuilder(str);
            String reversed_str = reversed_sb.reverse().toString();

            if (str.equals(reversed_str)) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
        System.out.print(sb);
    }
}