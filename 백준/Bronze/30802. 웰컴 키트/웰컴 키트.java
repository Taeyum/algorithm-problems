import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long shirt = 0; 
        int[] count = new int[6];
        for (int i = 0; i < 6; i++) {
            count[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long T = Long.parseLong(st.nextToken()); 
        long P = Long.parseLong(st.nextToken()); 

        for (int c : count) {
            long b = c / T;
            
            if (c % T != 0) {
                b += 1;
            }
            
            shirt += b;
        }
        
        long set = N / P;
        long single = N % P;

        System.out.println(shirt);
        System.out.println(set + " " + single);

    }
}