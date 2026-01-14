import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger A = sc.nextBigInteger();
        String str = sc.next();
        BigInteger B = sc.nextBigInteger();

        if(str.equals("*")){
            System.out.println(A.multiply(B));
        }else{
            System.out.println(A.add(B));
        }
    }
}