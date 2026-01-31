import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long sum = 0;

        while (true) {
            int money = sc.nextInt();
            if (money == -1) {
                break;
            }
            sum += money;
        }

        System.out.println(sum);
    }
}