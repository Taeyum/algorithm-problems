import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        int l = sc.nextInt();
        int count = 0;

        while (k != l) {
            k = (k+1)/2;
            l = (l+1)/2;
            count++;
        }

        System.out.println(count);
    }
}