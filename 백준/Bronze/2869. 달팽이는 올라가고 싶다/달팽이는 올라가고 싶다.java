import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int A = Integer.parseInt(st.nextToken()); 
        int B = Integer.parseInt(st.nextToken()); 
        int V = Integer.parseInt(st.nextToken()); 
        
        int dis = V - A;
        int cli = A - B;
        int totals;
        
        if (dis <= 0) {
            totals = 1;
        } else {
            int dir = (dis + cli - 1) / cli;
            totals = dir + 1;
        }
        
        System.out.println(totals);
    }
}