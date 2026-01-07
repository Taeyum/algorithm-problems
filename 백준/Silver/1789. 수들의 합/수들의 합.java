import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();
        
        long sum = 0;
        long n = 1;
        
        while (true) {
            sum += n;
            if (sum > S) break;
            n++;
        }
        
        System.out.println(n - 1);
    }
}