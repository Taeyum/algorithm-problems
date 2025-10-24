import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        while (N > 1) {
            if (N % 2 != 0) {
                System.out.println(0);
                return;
            }
            
            N = N / 2;
        }
        System.out.println(1);
    }
}