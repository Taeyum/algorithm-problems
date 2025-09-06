import java.util.Scanner;

public class Main {
    static int[][] dp = new int[41][2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        // fibonacci(0)이 0을 호출하는 횟수: 1, 1을 호출하는 횟수: 0
        dp[0][0] = 1;
        dp[0][1] = 0;
        // fibonacci(1)이 0을 호출하는 횟수: 0, 1을 호출하는 횟수: 1
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int test_case = 0; test_case < T; test_case++) {
            int N = sc.nextInt();

            fibonacci(N);

            System.out.println(dp[N][0] + " " + dp[N][1]);
        }
    }

    static int[] fibonacci(int n) {
        if (dp[n][0] > 0 || dp[n][1] > 0) {
            return dp[n];
        }

        int[] count1 = fibonacci(n - 1);
        int[] count2 = fibonacci(n - 2);

        dp[n][0] = count1[0] + count2[0];
        dp[n][1] = count1[1] + count2[1];

        return dp[n];
    }
}