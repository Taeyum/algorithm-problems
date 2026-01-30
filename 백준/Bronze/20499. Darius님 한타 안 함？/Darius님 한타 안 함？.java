import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split("/");
        
        int K = Integer.parseInt(str[0]);
        int D = Integer.parseInt(str[1]);
        int A = Integer.parseInt(str[2]);
        
        if (K + A < D || D == 0) {
            System.out.println("hasu");
        } else {
            System.out.println("gosu");
        }
    }
}