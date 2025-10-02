import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();

        char golbaengi = '@';

        int up = 5 * N; 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < up; j++) {
                System.out.print(golbaengi);
            }
            System.out.println();
        }

        int mid = 3 * N;
        int side = N;        
        for (int i = 0; i < mid; i++) {
            for (int j = 0; j < side; j++) {
                System.out.print(golbaengi);
            }
            System.out.println(); 
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < up; j++) {
                System.out.print(golbaengi);
            }
            System.out.println();
        }
    }
}