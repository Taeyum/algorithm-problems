import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        String[] text = new String[N];
        for (int i = 0; i < N; i++) {
            text[i] = sc.next();
        }
        
        if (N == 0) return;

        int length = text[0].length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char alpha = text[0].charAt(i);
            boolean check = true;

            for (int j = 1; j < N; j++) {
                if (text[j].charAt(i) != alpha) {
                    check = false;
                    break;
                }
            }

            if (check) {
                sb.append(alpha);
            } else {
                sb.append('?');
            }
        }

        System.out.println(sb);
    }
}