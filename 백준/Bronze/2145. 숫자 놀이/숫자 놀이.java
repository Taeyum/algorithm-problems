import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while(true) {
            int N = sc.nextInt();
            if(N == 0) {
                break;
            } else {
                list.add(N);
            }
        }
        for (Integer i : list) {
            int sum = 0;
            while(true) {
                while(i != 0) {
                    sum += i%10;
                    i /= 10;
                    if(sum / 10 >= 1) {
                        int n = sum % 10;
                        int n1 = sum / 10;
                        sum = n + n1;
                    }
                }
                break;
            }
            System.out.println(sum);
        }
    }
}
