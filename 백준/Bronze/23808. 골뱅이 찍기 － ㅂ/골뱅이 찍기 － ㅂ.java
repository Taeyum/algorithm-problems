import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N*5; i++) {
            // 맨 위 n * 2
            if (i < N * 2) {
                for(int j = 0; j < N; j++) {
                    System.out.print("@");
                }

                for(int j = 0; j < N * 3; j++) {
                    System.out.print(" ");
                }

                for (int j = 0; j < N; j++) {
                    System.out.print("@");
                }
            }
            // 그 다음 n * 3
            else if (i < N * 3) {
                for (int j = 0; j < N * 5; j++) {
                    System.out.print("@");
                }
            }
            // 그 다음 n * 4
            else if (i < N * 4){
                for(int j = 0; j < N; j++) {
                    System.out.print("@");
                }

                for(int j = 0; j < N * 3; j++) {
                    System.out.print(" ");
                }

                for (int j = 0; j < N; j++) {
                    System.out.print("@");
                }
            }
            // 나머지
            else {
                for (int j = 0; j < N * 5; j++) {
                    System.out.print("@");
                }
            }
            System.out.println();
        }
    }
}