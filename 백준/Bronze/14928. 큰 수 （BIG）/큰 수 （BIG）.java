import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();

        long num = 0;

        for (int i = 0; i < n.length(); i++) {
            int digit = n.charAt(i) - '0'; 

            num = (num * 10 + digit) % 20000303;
        }

        System.out.println(num);
    }
}