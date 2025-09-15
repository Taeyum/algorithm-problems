import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1 ; test_case <= T ; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String[] str = new String[N];
			String[] str1 = new String[N];
			String[] str2 = new String[N];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0 ; i < N ; i++) {
				str[i] = st.nextToken();
			}
			for(int i = 0 ; i < N / 2 + 1 ; i++) {
				str1[i] = str[i];
			}
			
			for(int i = N / 2 ; i < N ; i++) {
				str2[i] = str[i];
			}
			
            System.out.print("#" + test_case + " ");
            if(N % 2 == 0) {
				for(int i = 0 ; i < N / 2 ; i++) {
					System.out.print(str1[i] + " " +str2[i+N/2] + " ");	
				}
            } else {
            	for(int i = 0 ; i < N / 2 + 1 ; i++) {
            		System.out.print(str1[i] + " ");
            		if(i < N / 2) {
            			System.out.print(str2[i + N/2 + 1] + " ");
            		}
            	}
            }
			System.out.println();
		}
		
	}
}
