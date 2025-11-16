import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        int[] arr = new int[1001];
        int num = 1;
        int count = 0;

        for (int i = 1; i <= 1000; i++) {
            arr[i] = num;
            count++;
            
            if (count == num) {
                num++;
                count = 0;
            }
        }

        int sum = 0;
        for (int i = A; i <= B; i++) {
            sum += arr[i];
        }

        System.out.println(sum);
    }
}