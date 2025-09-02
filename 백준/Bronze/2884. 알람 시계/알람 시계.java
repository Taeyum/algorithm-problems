import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();

        if(H == 0 && M - 45 < 0) {
            H = 23;
            M = 60 - 45 + M;
        } else if(M - 45 >= 0) {
            M = M - 45;
        } else {
            H--;
            M = M + 15;
        }

        System.out.println(H + " " + M);
    }
}
