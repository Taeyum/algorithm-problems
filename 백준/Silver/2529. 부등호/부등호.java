import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    
    static String[] signs; 
    static boolean[] visited; 
    static int[] max;
    static int[] min;
    static int K; 
    static boolean foundMax = false; 
    static boolean foundMin = false;
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine()); 
        String str = br.readLine();
        
        max = new int[K + 1];
        min = new int[K + 1];
        visited = new boolean[10];
        signs = str.split(" ");
        
        for (int i = 9; i >= 0; i--) { 
            if (foundMax) break;  
            visited[i] = true;
            max[0] = i; 
            maxSelect(1); 
            visited[i] = false; 
        }

        visited = new boolean[10]; 
        for (int i = 0; i <= 9; i++) { 
            if (foundMin) break;
            visited[i] = true;
            min[0] = i; 
            minSelect(1); 
            visited[i] = false;
        }
        
        StringBuilder sb1 = new StringBuilder();
        for (int i : max) {
            sb1.append(i);
        }
        System.out.println(sb1);

        StringBuilder sb2 = new StringBuilder();
        for (int i : min) {
            sb2.append(i);
        }
        System.out.println(sb2);
    }

    static void maxSelect(int idx) {        
        if (idx == K + 1) { 
            foundMax = true; 
            return;
        }
        
        
        for (int i = 9; i >= 0; i--) {
            if (foundMax) return; 
            
            if (!visited[i]) {
                boolean condition = false;
                
                if (signs[idx - 1].equals("<")) {
                    condition = max[idx - 1] < i; 
                } else { 
                    condition = max[idx - 1] > i; 
                }

                if (condition) {
                    max[idx] = i;
                    visited[i] = true;
                    
                    maxSelect(idx + 1);
                    
                    if (foundMax) return; 
                    visited[i] = false;
                }
            }
        }
    }

  static void minSelect(int idx) {
        if (idx == K + 1) { 
            foundMin = true;
            return;
        }
        
        for (int i = 0; i <= 9; i++) {
            if (foundMin) return;
            
            if (!visited[i]) {
               boolean condition = false;
                
                if (signs[idx - 1].equals("<")) {
                    condition = min[idx - 1] < i;
                } else { 
                    condition = min[idx - 1] > i;
                }

                if (condition) {
                    min[idx] = i;
                    visited[i] = true;
                    minSelect(idx + 1);
                    
                    if (foundMin) return; 
                    visited[i] = false;
                }
            }
        }
    }
}
