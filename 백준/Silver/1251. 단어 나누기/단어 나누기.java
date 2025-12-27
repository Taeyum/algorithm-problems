import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        int length = str.length();
        
        List<String> resultList = new ArrayList<>();

        for (int i = 1; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                
                String s1 = str.substring(0, i);
                String s2 = str.substring(i, j);
                String s3 = str.substring(j);
                
                StringBuilder sb1 = new StringBuilder(s1).reverse();
                StringBuilder sb2 = new StringBuilder(s2).reverse();
                StringBuilder sb3 = new StringBuilder(s3).reverse();
                
                String sb = sb1.toString() + sb2.toString() + sb3.toString();
                
                resultList.add(sb);
            }
        }
        
        Collections.sort(resultList);
        
        System.out.println(resultList.get(0));
    }
}