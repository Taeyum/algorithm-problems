import java.util.Scanner;

public class Main {
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String problem = sc.nextLine();
        String[] str = problem.split("-");
        for (int i = 0; i < str.length; i++) {
            int temp = sum(str[i]);
            if(i == 0) {
                result = result + temp;
            } else {
                result = result - temp;
            }
        }
        System.out.println(result);
    }

    static int sum(String a) {
        int sum = 0;
        String temp[] = a.split("[+]");
        for (int i = 0; i < temp.length; i++) {
            sum += Integer.parseInt(temp[i]);
        }
        return sum;
    }
}