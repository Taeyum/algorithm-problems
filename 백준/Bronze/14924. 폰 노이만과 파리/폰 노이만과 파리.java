import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int t = sc.nextInt();
        int d = sc.nextInt();
        
        int result = d / (s * 2);
        System.out.println(result * t);
    }
}