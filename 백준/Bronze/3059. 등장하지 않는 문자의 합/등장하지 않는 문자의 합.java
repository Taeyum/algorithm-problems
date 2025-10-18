import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < T; i++) {
            String S = sc.nextLine();
            int result = 0;
            boolean[] alpha = new boolean[26];

            for (int j = 0; j < S.length(); j++) {
                char s = S.charAt(j);
                alpha[s - 'A'] = true;
            }
            
            for (int j = 0; j < alpha.length; j++) {
                if(!alpha[j]) {
                    result += ('A' + j);
                }
            }

            System.out.println(result);
        }


    }
}