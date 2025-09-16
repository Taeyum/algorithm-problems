import java.util.Scanner;

public class Main {
    static int[] numbers;
    static int N;
    static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        numbers = new int[M];

        combination(0, 1);
    }

    static void combination(int cnt, int start) {
        if (cnt == M) {
            for (int number : numbers) {
                System.out.print(number + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            numbers[cnt] = i;
            combination(cnt + 1, i + 1);
        }
    }
}