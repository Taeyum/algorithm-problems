import java.util.Scanner;

// 계단은 한 번에 한 계단씩 or 두 계단씩
// 연속된 세 개의 계단을 모두 밟아서는 안된다.
// 마지막 도착 계단은 반드시 밟아야 한다.

// i 번째 계단에 도착하는 방법은 두 가지.
// i - 1 번째 계단에서 한 칸, i - 2 번째 계단에서 두 칸
// i - 3 번째 계단을 밟고 i - 1 번쨰 계단으로 올라온 상태여야 함 (연속된 세 개의 계단 x) -> dp[i-3] + dp[i - 1] + dp[i]
// i - 2 번째 계단을 밟고 i 번쨰로 (i - 1 밟으면 x) -> dp[i-2] + dp[i]
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] stair = new int[N + 1];
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            stair[i] = sc.nextInt();
        }

        if(N == 1) {
            System.out.println(stair[1]);
            return;
        } else if(N == 2) {
            System.out.println(stair[1] + stair[2]);
            return;    
        }
        
        dp[1] = stair[1];
        dp[2] = stair[1] + stair[2];
        dp[3] = Math.max(stair[1], stair[2]) + stair[3];

        for (int i = 4; i <= N; i++) {
            dp[i] = Math.max(dp[i-3] + stair[i-1], dp[i-2]) + stair[i];
        }
        System.out.println(dp[N]);
    }
}