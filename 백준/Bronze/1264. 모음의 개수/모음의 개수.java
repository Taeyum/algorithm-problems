import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[] mo = {'a','e','i','o','u'};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        while(!str.equals("#")) {
            int count = 0;
            str = str.toLowerCase();
            
            for (int i = 0; i < str.length(); i++) {
                char w = str.charAt(i);

                for (char c : mo) {
                    if(w == c) {
                        count++;
                    }
                }
            }
            System.out.println(count);
            str = br.readLine();
        }
    }
}